package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class textpayment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textpayment)

        val buttonnext = findViewById<Button>(R.id.conbtn)
        val progressbtn = findViewById<ProgressBar>(R.id.progressBar)


            buttonnext.isEnabled = false

            // add TextWatcher to all the EditTexts to check if all fields are filled
            val nameowner = findViewById<TextInputEditText>(R.id.nameowner)
            val ncard = findViewById<TextInputEditText>(R.id.ncard)
            val datecard = findViewById<TextInputEditText>(R.id.datecard)
            val securtiy = findViewById<TextInputEditText>(R.id.securtiy)

            val textWatcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    // enable the button if all fields are filled
                    buttonnext.isEnabled = nameowner.text?.isNotEmpty() == true && ncard.text?.isNotEmpty() == true && datecard.text?.isNotEmpty() == true && securtiy.text?.isNotEmpty() == true
                }
            }

            nameowner.addTextChangedListener(textWatcher)
            ncard.addTextChangedListener(textWatcher)
            datecard.addTextChangedListener(textWatcher)
            securtiy.addTextChangedListener(textWatcher)

        buttonnext.setOnClickListener {
            // validate the input fields
            val name = nameowner.text.toString().trim()
            val cardNumber = ncard.text.toString().trim()
            val date = datecard.text.toString().trim()
            val securityCode = securtiy.text.toString().trim()

            if (name.split("").size <15) {
                // show error message for invalid name
                Toast.makeText(this, "Invalid name", Toast.LENGTH_SHORT).show()
            } else if (cardNumber.length != 15) {
                // show error message for invalid card number
                Toast.makeText(this, "Invalid card number", Toast.LENGTH_SHORT).show()
            } else if (date.split("/").size != 2) {
                // show error message for invalid date format
                Toast.makeText(this, "Invalid date format", Toast.LENGTH_SHORT).show()
            } else if (securityCode.length != 3) {
                // show error message for invalid security code
                Toast.makeText(this, "Invalid security code", Toast.LENGTH_SHORT).show()
            } else {
                // show the progress bar
                progressbtn.visibility = ProgressBar.VISIBLE

                val thread = Thread {
                    try {
                        // simulate payment processing
                        Thread.sleep(5000)

                        runOnUiThread {
                            // show the snackbar when payment is successful
                            val snackbar = Snackbar.make(findViewById(android.R.id.content), "Payment successful", Snackbar.LENGTH_SHORT)
                            snackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                            snackbar.show()

                            // clear all the input fields
                            nameowner.text = null
                            ncard.text = null
                            datecard.text = null
                            securtiy.text = null

                            // start the next activity
                        }

                    } catch (e: Exception) {
                    } finally {
                        // hide the progress bar
                        progressbtn.visibility = ProgressBar.INVISIBLE
                    }
                }
                thread.start()
            }
        }
    }}