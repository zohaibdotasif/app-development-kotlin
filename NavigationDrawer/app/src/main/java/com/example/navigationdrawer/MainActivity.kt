package com.example.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.nav_toolbar)
        setSupportActionBar(toolbar)

        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            navView.setCheckedItem(R.id.nav_home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> replaceFragment(HomeFragment())
            R.id.nav_info -> replaceFragment(InfoFragment())
            R.id.nav_share -> replaceFragment(ShareFragment())
            R.id.nav_settings -> replaceFragment(SettingsFragment())
            R.id.nav_logout -> {
                replaceFragment(HomeFragment())
                Toast.makeText(this, "You have been logged out!", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressedDispatcher.onBackPressed()
        }
    }
}

// ---------------------------------------------------------------------
// Steps to create a navigation drawer
// ---------------------------------------------------------------------

// -----ACTIVITY_MAIN.XML-----
// 1. Create a menu
// 2. Create a header
// 3. Combine both in the activity main
//      - create a drawer layout
//      - create a custom toolbar
//      - create a frame layout
//      - create a navigation view (here we'll combine menu and header)

// ---------------------------------------------------------------------

// -----MAINACTIVITY.KT-----
// 1. Declare and initialize the drawer layout (X)
// 2. Initialize the toolbar (X)
// 3. Initialize the navigation view (X)
// 4. Set the navigation drawer menu on the action bar toggle (X)
// 5. Create a replace fragment method (X)
// 6. Create on back press method (X)
// 7. Set the default fragment (X)
// 8. Create on navigation item selected