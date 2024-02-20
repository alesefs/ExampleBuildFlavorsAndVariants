package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val baseLayout: ConstraintLayout = findViewById(R.id.baseLayoutSecondary)

        when (BuildConfig.FLAVOR) {
            "blueFlavor" -> {
                baseLayout.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.purple_700)
                )
            }
            "redFlavor" -> {
                baseLayout.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.red)
                )
            }
            "greenFlavor" -> {
                baseLayout.setBackgroundColor(
                    ContextCompat.getColor(this, androidx.appcompat.R.color.material_grey_850)
                )
            }
        }
    }
}