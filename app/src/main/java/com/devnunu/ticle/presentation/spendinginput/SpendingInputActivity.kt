package com.devnunu.ticle.presentation.spendinginput

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.R
import com.devnunu.ticle.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpendingInputActivity :
    BaseActivity<SpendingInputState, SpendingInputSideEffect, SpendingInputViewEvent, SpendingInputViewModel>() {

    override val viewModel: SpendingInputViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.right_in, R.anim.nothing)
        setContent {
            SpendingInputScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
    }

    override fun handleSideEffect(sideEffect: SpendingInputSideEffect) {
        super.handleSideEffect(sideEffect)
        when (sideEffect) {
            is SpendingInputSideEffect.GoBack -> {
                onBackPressed()
            }

            is SpendingInputSideEffect.CompleteAddSpending -> {
                finish()
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.nothing, R.anim.right_out)
    }
}