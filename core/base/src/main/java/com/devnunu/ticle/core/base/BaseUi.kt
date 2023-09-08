package com.devnunu.ticle.core.base

import androidx.lifecycle.ViewModel

interface BaseUi<VM : ViewModel> {
    val viewModel: VM
}