package com.example.ktorsimpleclient.models.assModels
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherMaps(
    @SerialName("Meteoblue")
    val meteoBlue: Meteoblue,
    @SerialName("Windy")
    val windy: Windy
)