package com.example.ktorsimpleclient.models.assModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssFile(
    @SerialName("path")
    val path: String
)