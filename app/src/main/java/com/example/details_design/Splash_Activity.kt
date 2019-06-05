package com.example.details_design

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar

class Splash_Activity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private var progressBarStatus = 0
    var dummy : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        progressBar = findViewById(R.id.progressBar)

        Thread(Runnable {
            while (progressBarStatus<100){
                try{
                    dummy = dummy+25
                    Thread.sleep(1000)
                }catch (e : InterruptedException){
                    e.printStackTrace()
                }
                progressBarStatus = dummy
                progressBar.progress = progressBarStatus
            }
        }).start()


    }
}