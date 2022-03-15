package com.example.mini_sounds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mini_sounds.MiniSoundsHttpClient as MiniSoundsHttpClient

const val TAG = "MainActivity"

fun configUrlBuilder(os: String = "android", appVersion: String = "2.3.0"): String {
    return "https://sounds-mobile-config.files.bbci.co.uk/$os/$appVersion/config.json"
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val configData = MiniSoundsHttpClient().getString(configUrlBuilder())

    }
}