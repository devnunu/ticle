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
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            SummaryBoxView(
                modifier = Modifier.weight(1f),
                text = "총 수입",
                value = "0 원",
                backgroundColor = Purple20,
                onClick = {}
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

//        var budget by remember { mutableStateOf<Long?>(null) }
//        TicleInput(
//            modifier = Modifier.padding(top = 20.dp),
//            value = budget?.toString() ?: "",
//            label = "월 예산",
//            unitText = "만원",
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            onChangeInputText = { str ->
//                if (str.isEmpty()) {
//                    budget = null
//                } else {
//                    try {
//                        budget = str.toLong()
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                    }
//                }
//            }
//        )
//        Spacer(modifier = Modifier.weight(1f))
//        TicleButton(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 20.dp),
//            buttonText = "다음",
//            onClickButton = {
//                budget?.let {
//                    onEvent(MainViewEvent.ClickNextBtn(it))
//                }
//            }
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        onEvent = {}
    )
}