package com.example.e_library

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId", "SetTextI18n", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_genres)


//        val btn2 = findViewById<Switch>(R.id.switch1)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)


        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.Recommendation, R.id.nav_genres, R.id.AccountPage
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        val iv_click_me = findViewById(R.id.mybtn) as ImageView
//        iv_click_me.setOnClickListener {
//            startActivity(Intent(this@MainActivity, MainActivity::class.java))
//        }
//        val beforesave = findViewById(R.id.save) as ImageView
//        var iv: ImageView? = null
//        var flag = false
//        var images = intArrayOf(R.drawable.mysave_1, R.drawable.mysave_2)
//        var i = 0
//
//        iv = findViewById<View>(R.id.save) as ImageView
//        flag = true
//        beforesave.setOnClickListener {
//            iv.setImageResource(images[i])
//            i++
//            if (i == 2) i = 0
//        }

        val btn = findViewById<Switch>(R.id.switch3)
        btn?.setOnCheckedChangeListener { _, isChecked ->
            if (btn.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                btn.text = "Dark"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                btn.text = "Light"
            }
        }
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