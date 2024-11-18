package com.example.ktorsimpleclient

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorsimpleclient.models.RickResponse
import com.example.ktorsimpleclient.repository.KtorFitRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val ktorRepo: KtorFitRepository
) : ViewModel() {

    private val _stateFlow =
        MutableStateFlow(RickResponse("", "", ""))
    val stateFlow get() = _stateFlow

    fun fetchData() {
        viewModelScope.launch {
            val a = ktorRepo.fetchData()
            println("****" + a)
            _stateFlow.value = a
        }
    }

    fun getJson() {
        viewModelScope.launch {
            val a = ktorRepo.getJson()
            println("json" + a)
        }
    }

    fun getSocket() {
        viewModelScope.launch {
            val a = ktorRepo.getSocket()
            println("socket" + a)
        }
    }
}