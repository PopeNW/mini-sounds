package com.example.mini_sounds.data

import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteConfigApi {
    @GET("{appVersion}/config.json")
    suspend fun getRemoteConfig(@Path("appVersion") appVersion: String): RemoteConfig
}