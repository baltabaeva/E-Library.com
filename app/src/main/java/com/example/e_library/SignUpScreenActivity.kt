package com.example.e_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.e_library.databinding.ActivitySignUpScreenBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpScreenActivity : AppCompatActivity() {

        private lateinit var binding: ActivitySignUpScreenBinding
        private lateinit var firebaseAuth: FirebaseAuth
        private lateinit var button: Button
        private lateinit var Email: String
        private lateinit var Pass: String
        private lateinit var confpassword: String
        private lateinit var loginRedirectText: String

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val button = findViewById<Button>(R.id.signup_button)
            val email = findViewById<EditText>(R.id.signup_email)
            val password = findViewById<EditText>(R.id.signup_password)
            val confPassword = findViewById<EditText>(R.id.signup_confirm)
            val loginRedirectText = findViewById<TextView>(R.id.loginRedirectText)

            firebaseAuth = FirebaseAuth.getInstance()

            loginRedirectText.setOnClickListener {
                val intent = Intent(this, SignInScreenActivity::class.java)
                startActivity(intent)
            }
            button.setOnClickListener {
                val email = email.text.toString()
                val password = password.text.toString()
                confPassword.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty() && confpassword.isNotEmpty()) {
                    if (password == confpassword) {
                        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent = Intent(this, SignInScreenActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Empty Fields Are not Allowed!", Toast.LENGTH_SHORT).show()

                }
            }
        }
}
