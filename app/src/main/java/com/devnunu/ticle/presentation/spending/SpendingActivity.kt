package com.devnunu.ticle.presentation.spending

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.R
import com.devnunu.ticle.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpendingActivity :
    BaseActivity<SpendingState, SpendingSideEffect, SpendingViewEvent, SpendingViewModel>() {

    override val viewModel: SpendingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.right_in, R.anim.nothing)
        setContent {
            SpendScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
    }

    override fun handleSideEffect(sideEffect: SpendingSideEffect) {
        super.handleSideEffect(sideEffect)
        when (sideEffect) {
            SpendingSideEffect.GoBack -> {
                onBackPressed()
            }

            SpendingSideEffect.StartSpendingInput -> {

            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.nothing, R.anim.right_out)
    }
}