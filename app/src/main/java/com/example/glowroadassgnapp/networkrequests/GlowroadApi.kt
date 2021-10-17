package com.example.glowroadassgnapp.networkrequests

import com.example.glowroadassgnapp.models.GlowroadPhoto
import com.example.glowroadassgnapp.utils.Constant.Companion.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GlowroadApi {
    companion object {
        operator fun invoke() : GlowroadApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(GlowroadApi::class.java)
        }
    }

    @GET("test_response.json")
    suspend fun getGRPhotoResponse() : Response<GlowroadPhoto>
}