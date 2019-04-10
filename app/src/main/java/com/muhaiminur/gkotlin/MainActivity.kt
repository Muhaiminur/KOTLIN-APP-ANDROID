package com.muhaiminur.gkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //to remove "information bar" above the action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        Handler().postDelayed(Runnable {
            /* Create an Intent that will start the Menu-Activity. */
            startActivity(Intent(this@MainActivity,Home_Page::class.java))
            finish()
        }, 3000)
    }
}
