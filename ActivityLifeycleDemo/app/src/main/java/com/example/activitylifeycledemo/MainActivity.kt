package com.example.activitylifeycledemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.activitylifeycledemo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.io.File
import java.nio.file.Files
import java.util.Timer


class MainActivity : AppCompatActivity(), TestFragment.TestFragmentListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var timer: Timer
    private var seconds = 0
    private val testFragment = TestFragment()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        binding.textViewSavedMsg.text = savedInstanceState?.getString("savedMessage")
//        binding.btnExit.setOnClickListener {
//            finish()
//        }
         onBackPressedDispatcher.addCallback(){ showDialog() }

//        binding.btnSave.setOnClickListener{ saveMessage() }

        binding.btnShowFragment.setOnClickListener { showFragment() }
        binding.btnRmvFragment.setOnClickListener{ removeFragment()}
    }

    private fun removeFragment() {

        supportFragmentManager.commit {
            remove(testFragment)
        }

    }

    private fun showFragment() {

        supportFragmentManager.commit{
            add(R.id.fragment_container, testFragment)
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        val savedTextViewMessage = binding.textViewSavedMsg.text.toString()
//        outState.putString("savedMessage",savedTextViewMessage)
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun saveMessage() {
//        val userMessage = binding.editTextInput.text.toString()
//        File(filesDir, "user_message.txt").writeText(userMessage)
//        binding.textViewSavedMsg.text = "Message saved successfully!\n\nMessage Preview:\n$userMessage"
//        binding.editTextInput.setText("")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        val message = binding.editTextInput.text.toString()
//        File(filesDir, "user_message.txt").writeText(message)
//    }

//    override fun onPause() {
//        super.onPause()
//        timer.cancel()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        timer = fixedRateTimer(period = 1000L) {
//            runOnUiThread {
//                binding.textViewRefreshStatus.text =
//                    "You have been staring at this for ${seconds++} seconds"
//            }
//        }
//    }

//    override fun onResume() {
//        super.onResume()
//        numLoads++
//        binding.textViewRefreshStatus.text = "Refreshed your feed... Loaded $numLoads times"
//
//    }

//    override fun onRestart() {
//        super.onRestart()
//        binding.textViewRefreshStatus.text = "Refreshed your feed..."
//    }

    private fun showDialog(){
        AlertDialog.Builder(this)
            .setTitle("Warning")
            .setMessage("You are about to leave the app. Are you sure you want to exit?")
            .setPositiveButton("Yes"){_,_, ->
                finish()
            }
            .setNegativeButton("No"){dialog,_, ->
                dialog.dismiss()
            }
            .setNeutralButton("More Info"){_,_,->
                Snackbar.make(binding.root,"Here is some more info",Snackbar.LENGTH_SHORT).show()
            }
            .show()
    }

    override fun clearActivityScreen() {
        binding.editTextInput.setText("")
        binding.textViewSavedMsg.text = ""
        removeFragment()
    }


}