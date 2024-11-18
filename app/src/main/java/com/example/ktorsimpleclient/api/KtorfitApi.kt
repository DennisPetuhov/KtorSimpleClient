package com.example.ktorsimpleclient.api

import com.example.ktorsimpleclient.models.MyMessage
import com.example.ktorsimpleclient.models.RickResponse
import de.jensklingenberg.ktorfit.http.GET

interface KtorfitApi {
    @GET("api")
    suspend fun fetchData(): RickResponse
    @GET("api")
    suspend fun getJson(): MyMessage
    @GET("websocet/1")
    suspend fun getSocket(): MyMessage

    companion object {
//        const val baseUrl = "https://rickandmortyapi.com/"
        const val baseUrl = "http://localhost:8080/"
    }
}
