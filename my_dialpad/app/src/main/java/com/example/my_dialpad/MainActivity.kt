package com.example.my_dialpad

import android.content.pm.PackageManager
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    lateinit var textViewDialedNumber: TextView
    lateinit var clearBtn : Button
    lateinit var callBtn : Button

    val dialedNumber = StringBuilder()

    // Request code for permissions
    private val REQUEST_CALL_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewDialedNumber = findViewById(R.id.textViewDialedNumber)
        clearBtn = findViewById(R.id.buttonClear)
        callBtn = findViewById(R.id.buttonCall)

        val buttonIds = listOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9,
            R.id.buttonStar, R.id.buttonHash
        )

        // Add functionality to number buttons
        for (id in buttonIds) {
            findViewById<Button>(id).setOnClickListener { button ->
                val text = (button as Button).text
                dialedNumber.append(text)
                textViewDialedNumber.text = dialedNumber.toString()
            }
        }

        // Clear button functionality
        clearBtn.setOnClickListener {
            dialedNumber.clear()
            textViewDialedNumber.text = ""
        }

        // Call button functionality
        callBtn.setOnClickListener {
            val phoneNumber = dialedNumber.toString()
            if (phoneNumber.isNotEmpty()) {
                // Check for call permission
                if (ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // Request permission if not granted
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        REQUEST_CALL_PERMISSION
                    )
                } else {
                    // Make the call if permission is granted
                    makeCall(phoneNumber)
                }
            }
        }
    }

    // Handle the result of the permission request
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val phoneNumber = dialedNumber.toString()
                makeCall(phoneNumber)
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to make the call
    private fun makeCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }
}
