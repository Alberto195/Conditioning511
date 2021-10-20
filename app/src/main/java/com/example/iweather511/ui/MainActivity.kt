package com.example.iweather511.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iweather511.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
}