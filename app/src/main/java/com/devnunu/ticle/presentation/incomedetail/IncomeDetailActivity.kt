package com.devnunu.ticle.presentation.incomedetail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.R
import com.devnunu.ticle.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class IncomeDetailActivity :
    BaseActivity<IncomeDetailState, IncomeDetailSideEffect, IncomeDetailViewEvent, IncomeDetailViewModel>() {

    override val viewModel: IncomeDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.right_in, R.anim.nothing)
        setContent {
            IncomeDetailScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
        val incomeId = intent.extras?.getInt(EXTRA_INCOME_ID)
        incomeId?.let {
            viewModel.start(incomeId)
        }
    }

    override fun handleSideEffect(sideEffect: IncomeDetailSideEffect) {
        super.handleSideEffect(sideEffect)
        when (sideEffect) {
            IncomeDetailSideEffect.GoBack -> {
                onBackPressed()
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.nothing, R.anim.right_out)
    }

    companion object {
        const val EXTRA_INCOME_ID = "EXTRA_INCOME_ID"
    }
}