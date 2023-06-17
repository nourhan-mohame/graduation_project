package com.example.cic19

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cic19.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private var db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.tvdonthaveaccount.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }

        binding.buttonlogin.setOnClickListener {
            val email = binding.edemailregister.text.toString().trim()
            val pass = binding.passwordregister.text.toString().trim()
            val fname = binding.fname.text.toString().trim()
            val lname = binding.lname.text.toString().trim()

            if (email.isEmpty() || pass.isEmpty() || fname.isEmpty() || lname.isEmpty()) {
                Toast.makeText(this, "Please fill in all the required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if the email already exists in the database
            db.collection("user")
                .whereEqualTo("email", email)
                .get()
                .addOnSuccessListener { documents ->
                    if (documents.isEmpty) {
                        // Email is not in use, proceed with registration
                        val usermap = hashMapOf(
                            "firstname" to fname,
                            "lastname" to lname,
                            "email" to email,
                            "password" to pass
                        )

                        db.collection("user").add(usermap)
                            .addOnSuccessListener {
                                binding.edemailregister.text.clear()
                                binding.passwordregister.text.clear()
                                binding.fname.text.clear()
                                binding.lname.text.clear()
                                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener {
                                Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                            }

                        auth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    verifyEmail()
                                } else {
                                    Toast.makeText(
                                        this,
                                        "Registration failed: ${task.exception?.localizedMessage}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            .addOnFailureListener { exception ->
                                Log.e(TAG, "createUserWithEmailAndPassword failed:", exception)
                            }
                    } else {
                        // Email is already in use
                        Toast.makeText(this, "This email is already in use", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }

    private fun verifyEmail() {
        val user = Firebase.auth.currentUser

        user!!.sendEmailVerification()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Verification email sent", Toast.LENGTH_SHORT).show()
                    val i = Intent(this, LoginActivity::class.java)
                    startActivity(i)
                    finish()
                }
            }
    }
}