package com.smartherd.videoplayeronline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     register_main.setOnClickListener {
         startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
     }
        login_main.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
