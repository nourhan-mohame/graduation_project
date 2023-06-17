package com.example.cic19

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color.red
import android.location.Geocoder
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.android.material.snackbar.Snackbar
import java.util.*

class LostChildren : AppCompatActivity(), View.OnClickListener {

    private lateinit var locationTextView: TextView
    private lateinit var locationButton: Button
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var db: FirebaseFirestore
    private lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lostchild)

        locationTextView = findViewById(R.id.loc_txt)
        locationButton = findViewById(R.id.img_button)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        db = FirebaseFirestore.getInstance()
        geocoder = Geocoder(this, Locale.getDefault())

        if (Build.VERSION.SDK_INT >= 23) {
            if (!hasLocationPermissions()) {
                requestLocationPermissions()
            }
        }

        locationButton.setOnClickListener(this)
        locationTextView.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun hasLocationPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(
            this@LostChildren as AppCompatActivity,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(
                    this@LostChildren as AppCompatActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestLocationPermissions() {
        requestPermissions(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            1
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getLastLocation()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_button -> getLastLocation()
            R.id.loc_txt -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(locationTextView.text.toString())
                startActivity(intent)
            }
        }
    }

    @SuppressLint("MissingPermission", "NewApi")
    private fun getLastLocation() {
        if (hasLocationPermissions()) {
            if (isLocationEnabled()) {
                try {
                    fusedLocationClient.lastLocation.addOnCompleteListener { task ->
                        val location = task.result
                        if (location == null) {
                            requestNewLocationData()
                        } else {
                            val latitude = location.latitude
                            val longitude = location.longitude
                            val addressList = geocoder.getFromLocation(latitude, longitude, 1)
                            if (addressList?.isNotEmpty() == true) {
                                val address = addressList?.get(0)
                                val locationName = address?.getAddressLine(0)
                                val mapUrl = "http://maps.google.com/maps?q=loc:$latitude,$longitude"
                                locationTextView.text = "$locationName\n$mapUrl"
                                if (locationName != null) {
                                    saveLocationToFirestore(latitude, longitude, locationName)
                                }
                                val snackbar = Snackbar.make(findViewById(android.R.id.content), "Location sent", Snackbar.LENGTH_SHORT)
                                snackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                                snackbar.show()
                            }
                        }
                    }
                } catch (e: SecurityException) {
                    Snackbar.make(findViewById(android.R.id.content), "Location permission denied", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestLocationPermissions()
        }
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        val locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 5
            fastestInterval = 0
            numUpdates = 1
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val requestLocationUpdates: Task<Void> = fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.myLooper()
        )
    }

    private val locationCallback: LocationCallback = object : LocationCallback() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        override fun onLocationResult(locationResult: LocationResult) {
            val lastLocation = locationResult.lastLocation
            if (lastLocation != null) {
                val latitude = lastLocation.latitude
                val longitude = lastLocation.longitude
                val addressList = geocoder.getFromLocation(latitude, longitude, 1)
                if (addressList != null) {
                    if (addressList.isNotEmpty()) {
                        val address = addressList?.get(0)
                        val locationName = address?.getAddressLine(0)
                        val mapUrl = "http://maps.google.com/maps?q=loc:$latitude,$longitude"
                        locationTextView.text = "$locationName\n$mapUrl"
                        if (locationName != null) {
                            saveLocationToFirestore(latitude, longitude, locationName)
                        }
                        val snackbar = Snackbar.make(findViewById(android.R.id.content), "Location sent", Snackbar.LENGTH_SHORT)
                        snackbar.view.setBackgroundColor(ContextCompat.getColor(this@LostChildren, R.color.red))
                        snackbar.show()
                    }
                }
            }
        }
    }

    private fun saveLocationToFirestore(latitude: Double, longitude: Double, locationName: String) {
        val location = hashMapOf(
            "latitude" to latitude,
            "longitude" to longitude,
            "locationName" to locationName
        )

        db.collection("locations")
            .add(location)
            .addOnSuccessListener { documentReference ->
                // Do something on success
            }
            .addOnFailureListener { e ->
                // Handle errors here
            }
    }
}