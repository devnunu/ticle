package com.devnunu.ticle.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.components.TicleButton
import com.devnunu.ticle.components.TicleInput

@Composable
fun MainScreen(
    onEvent: (MainViewEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        var budget by remember { mutableStateOf<Long?>(null) }
        TicleInput(
            modifier = Modifier.padding(top = 20.dp),
            value = budget?.toString() ?: "",
            label = "월 예산",
            unitText = "만원",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onChangeInputText = { str ->
                if (str.isEmpty()) {
                    budget = null
                } else {
                    try {
                        budget = str.toLong()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        TicleButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            buttonText = "다음",
            onClickButton = {
                budget?.let {
                    onEvent(MainViewEvent.ClickNextBtn(it))
                }
            }
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