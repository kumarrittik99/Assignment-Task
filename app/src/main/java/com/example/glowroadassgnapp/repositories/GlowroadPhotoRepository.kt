package com.example.glowroadassgnapp.repositories

import com.example.glowroadassgnapp.networkrequests.GlowroadApi
import com.example.glowroadassgnapp.networkrequests.SafeApiRequest

class GlowroadPhotoRepository(
    private val api: GlowroadApi
) : SafeApiRequest() {
    suspend fun getGRPhotoResponse() = apiRequest { api.getGRPhotoResponse() }
}