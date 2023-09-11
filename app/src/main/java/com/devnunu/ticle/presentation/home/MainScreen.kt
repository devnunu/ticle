package com.devnunu.ticle.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.theme.Bold30
import com.devnunu.ticle.presentation.home.components.TotalSpendingBanner
import com.devnunu.ticle.presentation.home.components.TotalIncomeBanner
import com.devnunu.ticle.core.ui.theme.Purple20
import com.devnunu.ticle.core.ui.theme.Purple40
import com.devnunu.ticle.core.ui.theme.Regular15
import com.devnunu.ticle.core.ui.theme.gray70
import com.devnunu.ticle.core.ui.theme.gray90
import com.devnunu.ticle.model.asset.spending.SpendingType
import com.devnunu.ticle.model.asset.spending.getTotalSpending
import com.devnunu.ticle.presentation.home.components.SpareMoneyBanner
import com.devnunu.ticle.util.NumberFormatUtil

@Composable
fun MainScreen(
    state: MainState,
    onEvent: (MainViewEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                modifier = Modifier.padding(end = 10.dp),
                style = Bold30,
                text = "Ticle"
            )
            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                style = Regular15,
                text = "(티끌모아 부자 되는 예산 계산기)",
                color = gray70
            )
        }
        Spacer(modifier = Modifier.padding(6.dp))
        SpareMoneyBanner(
            totalSummaryText = state.totalSummaryText,
            onClick = { onEvent(MainViewEvent.OnClickInvestBanner) }
        )
        Spacer(modifier = Modifier.padding(6.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TotalIncomeBanner(
                modifier = Modifier.weight(1f),
                text = "월 수입",
                value = "${state.totalIncomeText} 원",
                backgroundColor = Purple20,
                onClick = {
                    onEvent(MainViewEvent.OnClickIncomeBanner)
                }
            )
            Spacer(modifier = Modifier.padding(6.dp))
            TotalIncomeBanner(
                modifier = Modifier.weight(1f),
                text = "월 지출",
                value = "${state.totalSpendingText} 원",
                backgroundColor = Purple40,
                onClick = {
                    onEvent(MainViewEvent.OnClickSpendingBanner)
                }
            )
        }

        Divider(
            modifier = Modifier.padding(vertical = 20.dp),
            thickness = 1.dp,
            color = gray90
        )
        TotalSpendingBanner(
            modifier = Modifier.padding(bottom = 20.dp),
            label = "고정지출",
            spendingList = state.userSpendingList.filter { it.type == SpendingType.FIXED },
            value= state.userSpendingList.getTotalSpending(SpendingType.FIXED)
        )
        TotalSpendingBanner(
            label = "대출",
            spendingList = state.userSpendingList.filter { it.type == SpendingType.LOAN },
            value= state.userSpendingList.getTotalSpending(SpendingType.LOAN)
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