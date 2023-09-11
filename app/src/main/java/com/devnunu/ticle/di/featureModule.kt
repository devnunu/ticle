package com.devnunu.ticle.di

import com.devnunu.ticle.presentation.invest.InvestViewModel
import com.devnunu.ticle.presentation.home.MainViewModel
import com.devnunu.ticle.presentation.income.IncomeViewModel
import com.devnunu.ticle.presentation.incomedetail.IncomeDetailViewModel
import com.devnunu.ticle.presentation.incomeinput.IncomeInputViewModel
import com.devnunu.ticle.presentation.spending.SpendingViewModel
import com.devnunu.ticle.presentation.spendingdetail.SpendingDetailViewModel
import com.devnunu.ticle.presentation.spendinginput.SpendingInputViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {

    viewModel { MainViewModel(get()) }

    viewModel { InvestViewModel(get()) }

    viewModel { IncomeViewModel(get()) }

    viewModel { IncomeInputViewModel(get()) }

    viewModel { IncomeDetailViewModel(get()) }

    viewModel { SpendingViewModel(get()) }

    viewModel { SpendingInputViewModel(get()) }

    viewModel { SpendingDetailViewModel(get()) }

}