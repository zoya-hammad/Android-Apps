package com.example.recordkeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.recordkeeper.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        supportFragmentManager.commit {
//            add(R.id.frame_content, RunningFragment())
//        }

        // Set up BottomNavigationView with proper listener
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_running -> onRunningClicked()
                R.id.nav_cycling -> onCyclingClicked()
                else -> false
            }
        }



//        binding.bottomNav.setOnItemSelectedListener(this)

//        binding.btnCycling.setOnClickListener(object : View.OnClickListener{
//
//            override fun onClick(v: View?) {
//
//            }
//
//        } ) --> anonymous class

//        binding.btnCycling.setOnClickListener{
//           onCyclingClicked()
//        }
//
//        binding.btnRunning.setOnClickListener{
//           onRunningClicked()
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.reset_running -> {
                Toast.makeText(this,"Reset Running menu item",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.reset_cycling -> {
                Toast.makeText(this,"Reset Cycling menu item",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.reset_all -> {
                Toast.makeText(this,"Reset All menu item",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onRunningClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        return true
    }

    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
        return true
    }

//    override fun onClick(v: View?) {
//
//        Toast.makeText(this,"I have made the Activity a click listener",Toast.LENGTH_LONG).show()
//    }

}