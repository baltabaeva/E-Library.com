package com.example.e_library

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.annotation.WorkerThread
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_library.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
//    lateinit var button: Button
//    private lateinit var email: String
//    private lateinit var password: String
//    private var ENDPOINT = "http://5.135.99.26:4000"

    //@SuppressLint("MissingInflatedId", "SetTextI18n", "UseSwitchCompatOrMaterialCode")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_genres)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

//        val button = findViewById<Button>(R.id.login_button);
//        val email = findViewById<EditText>(R.id.login_email)
//        val password = findViewById<EditText>(R.id.login_password)
//
//        button.setOnClickListener {
//            val email = email.text
//            val password = password.text
//            Thread {
//                addUser(email.toString(), password.toString())
//            }.start() }


        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.Recommendation, R.id.nav_genres, R.id.AccountPage), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        val btn = findViewById<Switch>(R.id.switch3)
//        btn?.setOnCheckedChangeListener { _, isChecked ->
//            if (btn.isChecked) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                btn.text = "Dark"
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                btn.text = "Light"
//            }
//        }
//    }

//    @WorkerThread
//    private fun addUser(email: String, password: String) {
//        val httpUrlConnection = URL(this.ENDPOINT).openConnection() as HttpURLConnection
//        val body = JSONObject().apply {
//            put(email, password)
//        }
//        httpUrlConnection.apply {
//            connectTimeout = 10000
//            requestMethod = "POST"
//            doOutput = true
//            setRequestProperty("Content-Type", "application/json")
//        }
//        OutputStreamWriter(httpUrlConnection.outputStream).use {
//            it.write(body.toString())
//        }
//        print(httpUrlConnection.responseCode)
//        httpUrlConnection.disconnect()
}

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}