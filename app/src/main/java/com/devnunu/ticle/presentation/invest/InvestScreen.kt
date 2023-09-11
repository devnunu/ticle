package com.devnunu.ticle.presentation.invest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.components.scaffold.TicleScaffold
import com.devnunu.ticle.core.ui.components.topbar.TicleTopBar
import com.devnunu.ticle.core.ui.theme.Bold16
import com.devnunu.ticle.core.ui.theme.Bold30
import com.devnunu.ticle.core.ui.theme.Medium14
import com.devnunu.ticle.core.ui.theme.gray70
import com.devnunu.ticle.core.ui.theme.indigo10
import com.devnunu.ticle.util.NumberFormatUtil

@Composable
fun InvestScreen(
    state: InvestState,
    onEvent: (InvestViewEvent) -> Unit
) {
    var investAmountSlider by remember { mutableStateOf(0f) }
    var investRateSlider by remember { mutableStateOf(0f) }
    val spareMoney = state.spareMoney

    TicleScaffold(
        topBar = {
            TicleTopBar(
                onClickBackBtn = { onEvent(InvestViewEvent.OnClickBackPress) },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = "총 여유 자금",
                color = gray70
            )
            Text(
                style = Bold30,
                text = NumberFormatUtil.toKrCurrencyText(spareMoney, true)
            )
            Column(
                modifier = Modifier.padding(top = 30.dp)
            ) {
                Row {
                    Column {
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            style = Medium14,
                            text = "투자 금액",
                            color = gray70
                        )
                        val investMoney =
                            NumberFormatUtil.toKrCurrencyText(
                                (spareMoney / 100 * investAmountSlider.toInt()),
                                true
                            )
                        Text(
                            style = Bold16,
                            text = investMoney,
                            color = indigo10,
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column {
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            style = Medium14,
                            text = "투자 퍼센트",
                            color = gray70
                        )
                        val investAmountRate =
                            NumberFormatUtil.toRateFormText(investAmountSlider.toDouble(), 0)
                        Text(
                            style = Bold16,
                            text = "$investAmountRate %",
                            color = indigo10,
                        )
                    }
                }
                Slider(
                    value = investAmountSlider,
                    onValueChange = { investAmountSlider = it },
                    steps = 100,
                    valueRange = 0f..100f
                )
                Row {
                    Column {
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            style = Medium14,
                            text = "예상 수익률",
                            color = gray70
                        )
                        val investRate =
                            NumberFormatUtil.toRateFormText(investRateSlider.toDouble(), 0)
                        Text(
                            style = Bold16,
                            text = "$investRate %",
                            color = indigo10,
                        )
                    }
                }
                Slider(
                    value = investRateSlider,
                    onValueChange = { investRateSlider = it },
                    steps = 100,
                    valueRange = 0f..100f,
                )
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = "예상 연 수익금 (12개월)",
                    color = gray70
                )
                val resultMoney =
                    ((spareMoney / 100 * investAmountSlider.toInt()) / 100 * investRateSlider.toInt()) * 12
                Text(
                    style = Bold30,
                    text = NumberFormatUtil.toKrCurrencyText(resultMoney, true),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InvestScreenPreview() {
    InvestScreen(
        state = InvestState(),
        onEvent = {},
    )
}