package com.example.ktorsimpleclient.di


import com.example.ktorsimpleclient.MainScreenViewModel
import com.example.ktorsimpleclient.repository.KtorFitRepository
import com.example.ktorsimpleclient.repository.KtorFitRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = module {
    single<KtorFitRepository> { KtorFitRepositoryImpl(ktorFitApi = get()) }
    viewModel { MainScreenViewModel(ktorRepo = get()) }
}