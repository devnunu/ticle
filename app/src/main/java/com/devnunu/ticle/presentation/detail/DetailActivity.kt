package com.devnunu.ticle.presentation.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity :
    BaseActivity<DetailState, DetailSideEffect, DetailViewEvent, DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
        intent.getLongExtra(PARAM_BUDGET, 0L).let {
            viewModel.setBudget(it)
        }
    }

    companion object {
        const val PARAM_BUDGET = "PARAM_BUDGET"
    }

}