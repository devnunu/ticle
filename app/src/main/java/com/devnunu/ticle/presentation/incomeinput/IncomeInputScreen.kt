package com.devnunu.ticle.presentation.incomeinput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.components.button.TicleButton
import com.devnunu.ticle.core.ui.components.input.TicleInput
import com.devnunu.ticle.core.ui.components.scaffold.TicleScaffold
import com.devnunu.ticle.core.ui.components.topbar.TicleTopBar

@Composable
fun IncomeInputScreen(
    state: IncomeInputState,
    onEvent: (IncomeInputViewEvent) -> Unit
) {
    var incomeName by remember { mutableStateOf("") }
    var budget by remember { mutableStateOf<Long?>(null) }

    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        runCatching {
            focusRequester.requestFocus()
        }
    }
    TicleScaffold(
        topBar = {
            TicleTopBar(
                onClickBackBtn = { onEvent(IncomeInputViewEvent.OnClickBackPress) },
            )
        },
        bottomBar = {
            val isBtnEnable = incomeName.isNotBlank() && budget != null
            TicleButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                buttonText = "완료",
                enable = isBtnEnable,
                onClickButton = {
                    val budget = budget ?: return@TicleButton
                    onEvent(IncomeInputViewEvent.OnClickCompleteBtn(incomeName, budget))
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
                    value = incomeName,
                    label = "수입명",
                    placeholder = "수입명을 입력해주세요",
                    focusRequester = focusRequester,
                    onChangeInputText = { str ->
                        incomeName = str
                    }
                )
                Spacer(modifier = Modifier.padding(10.dp))
                TicleInput(
                    modifier = Modifier.padding(top = 20.dp),
                    value = budget?.toString() ?: "",
                    label = "수입 금액",
                    placeholder = "수입 금액을 입력해주세요",
                    unitText = "원",
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
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IncomeInputScreenPreview() {
    IncomeInputScreen(
        state = IncomeInputState(),
        onEvent = {}
    )
}