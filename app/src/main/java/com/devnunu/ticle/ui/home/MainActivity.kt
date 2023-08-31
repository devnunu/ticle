package com.devnunu.ticle.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.devnunu.ticle.base.BaseActivity
import com.devnunu.ticle.base.BaseUi
import com.devnunu.ticle.base.EmptyState
import com.devnunu.ticle.ui.detail.DetailActivity

class MainActivity
    : BaseActivity<EmptyState, MainSideEffect, MainViewEvent, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                onEvent = viewModel::onEvent
            )
        }
    }

    override fun handleSideEffect(sideEffect: MainSideEffect) {
        when (sideEffect) {
            is MainSideEffect.StartDetailActivity -> {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.PARAM_BUDGET, sideEffect.budget)
                startActivity(intent)
            }
        }
    }
}