package com.devnunu.ticle.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.presentation.home.components.SpendBoxView
import com.devnunu.ticle.presentation.home.components.SummaryBoxView
import com.devnunu.ticle.ui.theme.Purple20
import com.devnunu.ticle.ui.theme.Purple40

@Composable
fun MainScreen(
    onEvent: (MainViewEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            SummaryBoxView(
                modifier = Modifier.weight(1f),
                text = "총 수입",
                value = "0 원",
                backgroundColor = Purple20,
                onClick = {
                    onEvent(MainViewEvent.OnClickIncomeBtn)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            SummaryBoxView(
                modifier = Modifier.weight(1f),
                text = "총 지출",
                value = "0 원",
                backgroundColor = Purple40,
                onClick = {}
            )
        }

        SpendBoxView(
            modifier = Modifier.padding(top = 20.dp),
            label = "고정지출"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        onEvent = {}
    )
}