package com.example.e_library

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import com.example.e_library.databinding.ActivityLoginScreenBinding
import com.example.e_library.databinding.ActivityMainBinding
import com.example.e_library.ui.home.HomeFragment

private lateinit var binding: ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_login_screen)

//        val singUp = findViewById<Button>(R.id.singUp)
//        val singIn = findViewById<Button>(R.id.singIn)
//        val logIn = findViewById<Button>(R.id.logIn)
//        val singUpLayout = findViewById<Button>(R.id.singUpLayout)
//        val logInLayout = findViewById<Button>(R.id.logInLayout)

        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonClick = findViewById<Button>(R.id.singIn)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

//        singUp.setOnClickListener {
//            singUp.background = resources.getDrawable(R.drawable.switch_trcks, null)
//            singUp.setTextColor(resources.getColor(R.color.white, null))
//            logIn.background = null
//            singUpLayout.visibility = View.VISIBLE
//            logInLayout.visibility = View.GONE
//            logIn.setTextColor(resources.getColor(R.color.purple_200, null))
//        }
//        logIn.setOnClickListener {
//            singUp.background = resources.getDrawable(R.drawable.switch_trcks, null)
//            singUp.background = null
//            singUp.setTextColor(resources.getColor(R.color.purple_200, null))
//            logIn.background = resources.getDrawable(R.drawable.switch_trcks, null)
//            singUpLayout.visibility = View.GONE
//            logInLayout.visibility = View.VISIBLE
//            logIn.setTextColor(resources.getColor(R.color.white, null))
//        }
//        singIn.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
    }
}