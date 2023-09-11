package com.devnunu.ticle.presentation.spendinginput

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
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.components.button.TicleButton
import com.devnunu.ticle.core.ui.components.input.TicleInput
import com.devnunu.ticle.core.ui.components.input.TicleSelectInput
import com.devnunu.ticle.core.ui.components.bottomsheet.rememberScaffoldBottomSheetView
import com.devnunu.ticle.core.ui.components.scaffold.TicleScaffold
import com.devnunu.ticle.core.ui.components.topbar.TicleTopBar
import com.devnunu.ticle.presentation.spendinginput.components.SpendingTypeBottomSheet

@Composable
fun SpendingInputScreen(
    state: SpendingInputState,
    onEvent: (SpendingInputViewEvent) -> Unit
) {
    var spendingName by remember { mutableStateOf("") }
    var spending by remember { mutableStateOf<Long?>(null) }
    val spendingType = state.spendingType

    val bottomSheetState = state.bottomSheetState

    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        runCatching {
            focusRequester.requestFocus()
        }
    }
    TicleScaffold(
        topBar = {
            TicleTopBar(
                onClickBackBtn = { onEvent(SpendingInputViewEvent.OnClickBackPress) },
            )
        },
        bottomBar = {
            val isBtnEnable = spendingName.isNotBlank() && spending != null && spendingType != null
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
        },
        bottomSheetView = rememberScaffoldBottomSheetView(
            viewModelSheetState = bottomSheetState,
            onCloseBottomSheet = { onEvent(SpendingInputViewEvent.OnCloseBottomSheet) }
        ) {
            when (bottomSheetState.tag) {
                is SpendingInputBottomSheetTag.SpendingType -> {
                    SpendingTypeBottomSheet(
                        onClickItem = {
                            onEvent(SpendingInputViewEvent.OnClickSpendingTypeBottomSheetItem(it))
                        }
                    )
                }
            }

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
                    focusRequester = focusRequester,
                    onChangeInputText = { str ->
                        spendingName = str
                    }
                )
                TicleInput(
                    modifier = Modifier.padding(top = 40.dp),
                    value = spending?.toString() ?: "",
                    label = "지출 금액",
                    placeholder = "지출 금액을 입력해주세요",
                    unitText = "원",
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
                TicleSelectInput(
                    modifier = Modifier.padding(top = 40.dp),
                    label = "지출 타입",
                    value = spendingType?.displayName,
                    placeholder = "지출 타입을 선택해주세요",
                    onClickInput = { onEvent(SpendingInputViewEvent.OnClickSpendingTypeSelectInput) },
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}