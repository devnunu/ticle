package com.devnunu.ticle.presentation.spendinginput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.components.TicleButton
import com.devnunu.ticle.core.ui.components.TicleInput
import com.devnunu.ticle.core.ui.components.TicleScaffold
import com.devnunu.ticle.core.ui.components.TicleTopBar

@Composable
fun SpendingInputScreen(
    state: SpendingInputState,
    onEvent: (SpendingInputViewEvent) -> Unit
) {
    var spendingName by remember { mutableStateOf("") }
    var spending by remember { mutableStateOf<Long?>(null) }

    TicleScaffold(
        topBar = {
            TicleTopBar(
                onClickBackBtn = { onEvent(SpendingInputViewEvent.OnClickBackPress) },
            )
        },
        bottomBar = {
            val isBtnEnable = spendingName.isNotBlank() && spending != null
            TicleButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                buttonText = "완료",
                enable = isBtnEnable,
                onClickButton = {
                    val budget = spending ?: return@TicleButton
                    onEvent(SpendingInputViewEvent.OnClickCompleteBtn(spendingName, budget))
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            Column(
                modifier = Modifier


                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                TicleInput(
                    modifier = Modifier
                        .padding(top = 20.dp),
                    value = spendingName,
                    label = "지출명",
                    placeholder = "지출명을 입력해주세요",
                    onChangeInputText = { str ->
                        spendingName = str
                    }
                )
                Spacer(modifier = Modifier.padding(10.dp))
                TicleInput(
                    modifier = Modifier.padding(top = 20.dp),
                    value = spending?.toString() ?: "",
                    label = "지출 금액",
                    placeholder = "지출 금액을 입력해주세요",
                    unitText = "만원",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onChangeInputText = { str ->
                        if (str.isEmpty()) {
                            spending = null
                        } else {
                            try {
                                spending = str.toLong()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}