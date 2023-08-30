package com.devnunu.ticle.di

import com.devnunu.ticle.ui.detail.DetailViewModel
import com.devnunu.ticle.ui.home.MainState
import com.devnunu.ticle.ui.home.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {

    viewModel { MainViewModel() }

    viewModel { DetailViewModel() }
}