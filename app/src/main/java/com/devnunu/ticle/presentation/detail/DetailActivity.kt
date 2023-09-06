package com.devnunu.ticle.presentation.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.base.BaseActivity

class DetailActivity :
    BaseActivity<DetailState, DetailSideEffect, DetailViewEvent, DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModels()

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