package com.devnunu.ticle.di

import com.devnunu.ticle.presentation.detail.DetailViewModel
import com.devnunu.ticle.presentation.home.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {

    viewModel { MainViewModel() }

    viewModel { DetailViewModel() }
}