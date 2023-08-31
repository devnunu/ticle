package com.devnunu.ticle.ui.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.devnunu.ticle.base.BaseActivity

class DetailActivity :
    BaseActivity<DetailState, DetailSideEffect, DetailViewEvent, DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreen(viewModel = viewModel)
        }
        intent.getLongExtra(PARAM_BUDGET, 0L).let {
            viewModel.setBudget(it)
        }
    }

    companion object {
        const val PARAM_BUDGET = "PARAM_BUDGET"
    }

}