package com.example.ktorsimpleclient.repository

import com.example.ktorsimpleclient.api.KtorfitApi
import com.example.ktorsimpleclient.models.MyMessage
import com.example.ktorsimpleclient.models.RickResponse
import com.example.ktorsimpleclient.simpleSocket2

class KtorFitRepositoryImpl(private val ktorFitApi: KtorfitApi) : KtorFitRepository {
    override suspend fun fetchData(): RickResponse {
        return ktorFitApi.fetchData()
    }

    override suspend fun getJson(): MyMessage {
        return ktorFitApi.getJson()
    }

    override suspend fun getSocket(){
      return simpleSocket2()
    }
}