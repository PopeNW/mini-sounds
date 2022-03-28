package com.example.mini_sounds.data

import retrofit2.http.GET

interface RmsApi {
    @GET("v2/experience/inline/stations")
    suspend fun getRmsAllStations(): RMS
}