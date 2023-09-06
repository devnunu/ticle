package com.devnunu.ticle.presentation.income

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.base.BaseActivity

class IncomeActivity :
    BaseActivity<IncomeState, IncomeSideEffect, IncomeViewEvent, IncomeViewModel>() {

    override val viewModel: IncomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IncomeScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
    }

    override fun handleSideEffect(sideEffect: IncomeSideEffect) {
        super.handleSideEffect(sideEffect)
        when (sideEffect) {
            IncomeSideEffect.GoBack -> {
                onBackPressed()
            }
        }
    }
}