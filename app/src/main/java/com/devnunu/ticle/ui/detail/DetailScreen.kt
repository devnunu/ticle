package com.devnunu.ticle.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun DetailScreen(viewModel: DetailViewModel) {
    val state = viewModel.state.collectAsState().value
    Column {
        Text(text = state.budget.toString())
    }
}