package com.devnunu.ticle.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.base.BaseActivity
import com.devnunu.ticle.base.EmptyState
import com.devnunu.ticle.presentation.detail.DetailActivity
import com.devnunu.ticle.presentation.income.IncomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity
    : BaseActivity<MainState, MainSideEffect, MainViewEvent, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
    }

    override fun handleSideEffect(sideEffect: MainSideEffect) {
        when (sideEffect) {
            is MainSideEffect.StartIncomeActivity -> {
                val intent = Intent(this, IncomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}