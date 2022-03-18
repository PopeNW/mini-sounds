package com.example.mini_sounds.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://sounds-mobile-config.files.bbci.co.uk/android/2.3.0/"

class RemoteConfigRepository {

    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val remoteConfigApi: RemoteConfigApi by lazy {
        retrofit.create(RemoteConfigApi::class.java)
    }

    suspend fun getConfig(): RemoteConfig {
        return remoteConfigApi.getRemoteConfig()
    }
}