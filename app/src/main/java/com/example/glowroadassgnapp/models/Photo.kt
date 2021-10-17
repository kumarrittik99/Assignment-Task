package com.example.glowroadassgnapp.models

data class Photo(
    val farm: Int,
    val height_q: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String,
    val url_q: String,
    val width_q: Int
)