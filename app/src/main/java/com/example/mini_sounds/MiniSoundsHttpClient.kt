package com.example.mini_sounds

import android.util.Log
import okhttp3.*
import java.io.IOException

class MiniSoundsHttpClient {

    private val okHttpClient = OkHttpClient()

    fun getString(url: String) {

        val request = Request.Builder().url(url).build()

        return okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (response.isSuccessful)
                        response.body?.string()
                    else
                        throw IOException("Unexpected code $response")
                }
            }
        })
    }
}