package com.devnunu.ticle.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

abstract class BaseActivity<STATE, SIDE_EFFECT, VIEW_EVENT, VIEW_MODEL : BaseViewModel<STATE, SIDE_EFFECT, VIEW_EVENT>>
    : AppCompatActivity(), BaseUi<VIEW_MODEL> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEventFlow()
    }

    private fun setEventFlow() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.collectDataFlow(this)
                viewModel.subscribeSideEffect(this@repeatOnLifecycle, ::handleSideEffect)
            }
        }
    }

    open fun handleSideEffect(sideEffect: SIDE_EFFECT) {}
}