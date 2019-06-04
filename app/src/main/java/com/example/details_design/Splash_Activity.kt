package com.example.details_design

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar

class Splash_Activity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        progressBar = findViewById(R.id.progressBar)
        progressBar.setVisibility(View.VISIBLE)
        }
}