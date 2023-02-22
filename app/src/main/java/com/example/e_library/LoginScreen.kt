package com.example.e_library

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.e_library.databinding.ActivityLoginScreenBinding
import com.example.e_library.databinding.ActivityMainBinding

private lateinit var binding: ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonClick = findViewById<Button>(R.id.singIn)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.singUp.setOnClickListener {
            binding.singUp.background = resources.getDrawable(R.drawable.switch_trcks, null)
            binding.singUp.setTextColor(resources.getColor(R.color.white, null))
            binding.logIn.background = null
            binding.singUpLayout.visibility = View.VISIBLE
            binding.logInLayout.visibility = View.GONE
            binding.logIn.setTextColor(resources.getColor(R.color.purple_200, null))
        }
        binding.logIn.setOnClickListener {
            binding.singUp.background = null
            binding.singUp.setTextColor(resources.getColor(R.color.purple_200, null))
            binding.logIn.background = resources.getDrawable(R.drawable.switch_trcks, null)
            binding.singUpLayout.visibility = View.GONE
            binding.logInLayout.visibility = View.VISIBLE
            binding.logIn.setTextColor(resources.getColor(R.color.white, null))
        }
    }
}