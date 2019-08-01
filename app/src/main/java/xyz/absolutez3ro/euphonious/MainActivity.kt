package xyz.absolutez3ro.euphonious

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import xyz.absolutez3ro.euphonious.ui.fragment.*
import xyz.absolutez3ro.euphonious.utility.Constants
import xyz.absolutez3ro.euphonious.utility.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_dashboard -> {
                loadFragment(DashboardFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_songs -> {
                loadFragment(SongsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_albums -> {
                loadFragment(AlbumsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_artists -> {
                loadFragment(ArtistsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_playlist -> {
                loadFragment(PlaylistFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        if (PreferenceHelper.getInt(this, Constants.LAST_FRAGMENT, 0) == 0) {
            navView.selectedItemId = R.id.navigation_dashboard
            PreferenceHelper.putInt(this, Constants.LAST_FRAGMENT, navView.selectedItemId)
        } else {
            navView.selectedItemId = PreferenceHelper.getInt(this, Constants.LAST_FRAGMENT, R.id.navigation_dashboard)
        }
    }

    override fun onStop() {
        super.onStop()
        val navigationView: BottomNavigationView = findViewById(R.id.nav_view)
        PreferenceHelper.putInt(this, Constants.LAST_FRAGMENT, navigationView.selectedItemId)
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        fragmentTransaction.commit()
    }


}