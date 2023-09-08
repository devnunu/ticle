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
import com.devnunu.ticle.presentation.home.components.TotalSpendingBanner
import com.devnunu.ticle.presentation.home.components.TotalIncomeBanner
import com.devnunu.ticle.core.ui.theme.Purple20
import com.devnunu.ticle.core.ui.theme.Purple40
import com.devnunu.ticle.presentation.home.components.SpareMoneyBanner

@Composable
fun MainScreen(
    state: MainState,
    onEvent: (MainViewEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        SpareMoneyBanner(
            totalSummaryText = state.totalSummaryText,
            onClick = {}
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TotalIncomeBanner(
                modifier = Modifier.weight(1f),
                text = "월 수입",
                value = "${state.totalIncomeText} 원",
                backgroundColor = Purple20,
                onClick = {
                    onEvent(MainViewEvent.OnClickIncomeBtn)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            TotalIncomeBanner(
                modifier = Modifier.weight(1f),
                text = "월 지출",
                value = "${state.totalSpendingText} 원",
                backgroundColor = Purple40,
                onClick = {
                    onEvent(MainViewEvent.OnClickSpendingBtn)
                }
            )
        }

        TotalSpendingBanner(
            modifier = Modifier.padding(top = 20.dp),
            label = "고정지출"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        state = MainState(),
        onEvent = {}
    )
}