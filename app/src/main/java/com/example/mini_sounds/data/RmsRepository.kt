package com.example.mini_sounds.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val RMS_BASE_URL = "https://rms.api.bbc.co.uk/"

class RmsRepository {
    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
                .baseUrl(RMS_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }

    private val rmsApi: RmsApi by lazy {
        retrofit.create(RmsApi::class.java)
    }

    suspend fun getRmsStations(): RMS {
        return rmsApi.getRmsAllStations()
    }
}