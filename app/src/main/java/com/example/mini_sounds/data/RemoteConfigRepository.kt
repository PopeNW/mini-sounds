package com.example.mini_sounds.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val REMOTE_CONFIG_BASE_URL = "https://sounds-mobile-config.files.bbci.co.uk/android/"

class RemoteConfigRepository {

    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
            .baseUrl(REMOTE_CONFIG_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val remoteConfigApi: RemoteConfigApi by lazy {
        retrofit.create(RemoteConfigApi::class.java)
    }

    suspend fun getConfig(appVersion: String): RemoteConfig {
        return remoteConfigApi.getRemoteConfig(appVersion)
    }
}