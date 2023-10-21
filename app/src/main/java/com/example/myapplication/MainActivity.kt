package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun mode_debutant(view:View){
        var intent = Intent(this, mode_debutant::class.java)
        startActivity(intent)
        finish()
    }

    fun mode_expert(view:View){
        var intent = Intent(this, mode_expert::class.java)
        startActivity(intent)
        finish()
    }
}