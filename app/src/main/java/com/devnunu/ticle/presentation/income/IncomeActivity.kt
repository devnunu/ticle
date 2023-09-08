package com.devnunu.ticle.presentation.income

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.devnunu.ticle.R
import com.devnunu.ticle.base.BaseActivity
import com.devnunu.ticle.presentation.incomeinput.IncomeInputActivity
import com.devnunu.ticle.presentation.incomeinput.IncomeInputSideEffect
import org.koin.androidx.viewmodel.ext.android.viewModel

class IncomeActivity :
    BaseActivity<IncomeState, IncomeSideEffect, IncomeViewEvent, IncomeViewModel>() {

    override val viewModel: IncomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.right_in, R.anim.nothing)
        setContent {
            IncomeScreen(
                state = viewModel.state.collectAsState().value,
                onEvent = viewModel::onEvent
            )
        }
    }

    override fun handleSideEffect(sideEffect: IncomeSideEffect) {
        super.handleSideEffect(sideEffect)
        when (sideEffect) {
            IncomeSideEffect.GoBack -> {
                onBackPressed()
            }

            IncomeSideEffect.StartIncomeInput -> {
                val intent = Intent(this, IncomeInputActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.nothing, R.anim.right_out)
    }
}