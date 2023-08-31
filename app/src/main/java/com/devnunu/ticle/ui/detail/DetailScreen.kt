package com.devnunu.ticle.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreen(
    state: DetailState,
    onEvent:(DetailViewEvent) -> Unit
) {
    Column(
        modifier = with(Modifier) { fillMaxSize() }
    ) {
        Text(
            text = "전체 예산"
        )
        Text(
            text = state.budget.toString()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        state = DetailState(budget = 1000000L),
        onEvent = {},
    )
}