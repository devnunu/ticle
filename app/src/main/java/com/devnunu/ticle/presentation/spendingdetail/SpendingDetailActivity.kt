package com.devnunu.ticle.presentation.spendingdetail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.R
import com.devnunu.ticle.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpendingDetailActivity :
    BaseActivity<SpendingDetailState, SpendingDetailSideEffect, SpendingDetailViewEvent, SpendingDetailViewModel>() {

    override val viewModel: SpendingDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.right_in, R.anim.nothing)
        setContent {
            SpendingDetailScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
        val spendingId = intent.extras?.getInt(EXTRA_SPENDING_ID)
        spendingId?.let {
            viewModel.start(spendingId)
        }
    }

    override fun handleSideEffect(sideEffect: SpendingDetailSideEffect) {
        super.handleSideEffect(sideEffect)
        when(sideEffect) {
            SpendingDetailSideEffect.GoBack -> {
                onBackPressed()
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.nothing, R.anim.right_out)
    }

    companion object {
        const val EXTRA_SPENDING_ID = "EXTRA_SPENDING_ID"
    }
}