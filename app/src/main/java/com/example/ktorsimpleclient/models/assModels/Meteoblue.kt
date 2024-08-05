package com.example.ktorsimpleclient.models.assModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meteoblue(
    @SerialName("location_id")
    val locationId: String,
)