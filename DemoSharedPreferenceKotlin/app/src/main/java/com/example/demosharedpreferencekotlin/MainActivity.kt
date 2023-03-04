package com.example.demosharedpreferencekotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var sharedPreference: SharedPreferences?=null
    var editor:SharedPreferences.Editor?=null
    var SHARED_PRE_NAME:String?="STATUS"
    var CURRENT_STATUS:String?="CURRENT_STATUS"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        anhXa()

        sharedPreference = getSharedPreferences(SHARED_PRE_NAME, MODE_PRIVATE)
        intContent()

        btnEL?.setOnClickListener(View.OnClickListener {

        })

    }

    private fun intContent() {

    }
}