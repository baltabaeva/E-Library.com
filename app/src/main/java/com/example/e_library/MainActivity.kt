package com.example.e_library

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.WorkerThread
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.e_library.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var button: Button
    private lateinit var eMail: String
    private lateinit var password: String
    private var ENDPOINT = "http://5.135.99.26:4000"


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_account)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        val button = findViewById<Button>(R.id.singIn)
        val eMail = findViewById<TextInputEditText>(R.id.eMail)
        val password = findViewById<TextInputEditText>(R.id.passwords)


        button.setOnClickListener {
            val eMail = eMail.text
            val password = password.text
            Thread {
                addUser(eMail.toString(), password.toString())
            }.start()

        }

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.Recommendation, R.id.nav_genres, R.id.AccountPage), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val clickMe = findViewById<ImageView>(R.id.mybtn)

        clickMe.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity::class.java))
        }
        val beforesave = findViewById(R.id.save) as ImageView
        var saveButton: ImageView? = null
        var flag = false
        var images = intArrayOf(R.drawable.save3_, R.drawable.save4_foreground)
        var i = 0

        saveButton = findViewById<View>(R.id.save) as ImageView
        flag = true
        beforesave.setOnClickListener {
            saveButton.setImageResource(images[i])
            i++
            if (i == 2) i = 0
        }

    }
    @WorkerThread
    private fun addUser(eMail: String, password: String) {
        val httpUrlConnection = URL(ENDPOINT).openConnection() as HttpURLConnection
        val body = JSONObject().apply {
            put(eMail, password)
        }
        httpUrlConnection.apply {
            connectTimeout = 10000 // 10 seconds
            requestMethod = "POST"
            doOutput = true
            setRequestProperty("Content-Type", "application/json")
        }
        OutputStreamWriter(httpUrlConnection.outputStream).use {
            it.write(body.toString())
        }
        //httpUrlConnection.responseCode
        print(httpUrlConnection.responseCode)
        httpUrlConnection.disconnect()


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}