package com.devnunu.ticle.base

import androidx.lifecycle.ViewModel

interface BaseUi<VM : ViewModel> {
    val viewModel: VM
}