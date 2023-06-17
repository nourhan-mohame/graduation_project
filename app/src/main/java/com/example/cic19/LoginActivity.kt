package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cic19.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.tvdonthaveaccount.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
            finish()
        }

        binding.tvforgetpassword.setOnClickListener {
            val email = binding.edemaillogin.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your email.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Password reset email sent.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Error: ${task.exception?.localizedMessage}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.buttonlogin.setOnClickListener {
            val email = binding.edemaillogin.text.toString().trim()
            val password = binding.passwordlogin.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        if (user != null && user.isEmailVerified) {
                            Toast.makeText(this, "Opening home...", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, listopition::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Please verify your email.", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Error: ${task.exception?.localizedMessage}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}