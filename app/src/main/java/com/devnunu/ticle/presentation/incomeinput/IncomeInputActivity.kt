package com.devnunu.ticle.presentation.incomeinput

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class IncomeInputActivity :
    BaseActivity<IncomeInputState, IncomeInputSideEffect, IncomeInputViewEvent, IncomeInputViewModel>() {

    override val viewModel: IncomeInputViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeInputScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
    }

    override fun handleSideEffect(sideEffect: IncomeInputSideEffect) {
        super.handleSideEffect(sideEffect)
        when (sideEffect) {
            IncomeInputSideEffect.GoBack -> {
                onBackPressed()
            }

            IncomeInputSideEffect.CompleteAddIncome -> {
                finish()
            }
        }
    }
}