package com.example.myapplication.redFlavor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.BuildConfig
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class RedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_red)

        Toast.makeText(
            this,
            "Flavour: ${BuildConfig.FLAVOR} My type: ${BuildConfig.BUILD_TYPE}",
            Toast.LENGTH_SHORT
        ).show()

        val centerBtn: Button = findViewById(R.id.btnCenter)
        centerBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}