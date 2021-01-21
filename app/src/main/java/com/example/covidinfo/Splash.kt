package com.example.covidinfo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed


class Splash : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable { /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this@Splash, MainActivity::class.java)
            this@Splash.startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())

    }
}