package com.devnunu.ticle.presentation.invest

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.R
import com.devnunu.ticle.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class InvestActivity :
    BaseActivity<InvestState, InvestSideEffect, InvestViewEvent, InvestViewModel>() {

    override val viewModel: InvestViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.right_in, R.anim.nothing)
        setContent {
            InvestScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
    }

    override fun handleSideEffect(sideEffect: InvestSideEffect) {
        super.handleSideEffect(sideEffect)
        when (sideEffect) {
            is InvestSideEffect.GoBack -> {
                onBackPressed()
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.nothing, R.anim.right_out)
    }
}