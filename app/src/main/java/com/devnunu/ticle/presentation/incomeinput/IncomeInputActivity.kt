package com.devnunu.ticle.presentation.incomeinput

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.R
import com.devnunu.ticle.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class IncomeInputActivity :
    BaseActivity<IncomeInputState, IncomeInputSideEffect, IncomeInputViewEvent, IncomeInputViewModel>() {

    override val viewModel: IncomeInputViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.right_in, R.anim.nothing)
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

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.nothing, R.anim.right_out)
    }
}