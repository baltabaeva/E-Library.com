package com.example.e_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.e_library.databinding.ActivitySignInScreenBinding
import com.google.firebase.auth.FirebaseAuth

class SignInScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var button: Button
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var signupRedirectText: String

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySignInScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val button = findViewById<Button>(R.id.login_button)
            val email = findViewById<EditText>(R.id.login_email)
            val password = findViewById<EditText>(R.id.login_password)
            val signupRedirectText = findViewById<TextView>(R.id.signupRedirectText)

            firebaseAuth = FirebaseAuth.getInstance()
            signupRedirectText.setOnClickListener {
                val intent = Intent(this, SignUpScreenActivity::class.java)
                startActivity(intent)
            }

            button.setOnClickListener {
                val email = email.text.toString()
                val pass = password.text.toString()

                if (email.isNotEmpty() && pass.isNotEmpty()) {

                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onStart() {
            super.onStart()

            if(firebaseAuth.currentUser != null){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
