package com.example.e_library

import android.os.Build
import android.os.Bundle
import android.view.Menu
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.e_library.databinding.ActivityMainBinding
import com.example.e_library.ui.genres.GenresFragment
import com.example.e_library.ui.home.HomeFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_genres.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val FIRST_FRAG_TAG = "f1"
    private val SECOND_FRAG_TAG = "f2"


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_genres)

        val fragmentManager = supportFragmentManager

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().replace(R.id.frame_layout, GenresFragment(), FIRST_FRAG_TAG).commit()
        }
        val genresFragment: GenresFragment? = fragmentManager.findFragmentByTag(FIRST_FRAG_TAG) as GenresFragment?
        val homeFragment: HomeFragment? = fragmentManager.findFragmentByTag(SECOND_FRAG_TAG) as HomeFragment?
        if (homeFragment != null && homeFragment.isVisible()) {
            fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .hide(homeFragment)
                .commit()
        }


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.Recommendation, R.id.nav_genres, R.id.nav_account
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        replaceFragment(GenresFragment(), BooksListFragment())


    }

//    private fun replaceFragment(genresFragment: GenresFragment, booklistfragment: BooksListFragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.add(R.id.frame_layout, genresFragment)
//        fragmentTransaction.commit()
//    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

