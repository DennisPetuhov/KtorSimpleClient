package com.example.ktorsimpleclient.models

@kotlinx.serialization.Serializable
data class RickResponse(
    val characters: String,
    var episodes: String,
    val locations: String
)