package com.example.ktorsimpleclient.models

import com.example.ktorsimpleclient.models.assModels.Forecast
import com.example.ktorsimpleclient.models.assModels.Weather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssResponse(
    @SerialName("current_forecast")
    val currentForecast: Forecast?,
    @SerialName("errors")
    val errors: List<String>? ,
    @SerialName("forecasts")
    val forecasts: List<Forecast>?,
    @SerialName("weather")
    val weather: Weather?,
)