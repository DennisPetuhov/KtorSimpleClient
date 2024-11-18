package com.example.ktorsimpleclient.repository

import com.example.ktorsimpleclient.models.MyMessage
import com.example.ktorsimpleclient.models.RickResponse

interface KtorFitRepository {
    suspend fun fetchData(): RickResponse
    suspend fun getJson(): MyMessage
    suspend fun getSocket()
}