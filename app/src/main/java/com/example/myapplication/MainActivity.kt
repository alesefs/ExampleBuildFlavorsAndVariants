package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.blueFlavor.BlueActivity
import com.example.myapplication.greenFlavor.GreenActivity
import com.example.myapplication.redFlavor.RedActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseLayout: ConstraintLayout = findViewById(R.id.baseLayout)

        val centerBtn: Button = findViewById(R.id.btn)
        centerBtn.setOnClickListener {
            when (BuildConfig.FLAVOR) {
                "blueFlavor" -> {
                    val intent = Intent(this, BlueActivity::class.java)
                    startActivity(intent)

                }
                "redFlavor" -> {
                    val intent = Intent(this, RedActivity::class.java)
                    startActivity(intent)

                }
                "greenFlavor" -> {
                    val intent = Intent(this, GreenActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        Snackbar.make(baseLayout, "Flavour: "+BuildConfig.FLAVOR + " My type: "+BuildConfig.BUILD_TYPE, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
    }
}