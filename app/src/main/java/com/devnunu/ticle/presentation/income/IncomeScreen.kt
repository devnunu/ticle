package com.devnunu.ticle.presentation.income

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.ticle.R
import com.devnunu.ticle.model.UserIncome
import com.devnunu.ticle.model.getTotalIncome
import com.devnunu.ticle.presentation.income.components.IncomeEmptyView
import com.devnunu.ticle.presentation.income.components.IncomeItemView
import com.devnunu.ticle.presentation.incomeinput.IncomeInputViewEvent
import com.devnunu.ticle.ui.components.TicleScaffold
import com.devnunu.ticle.ui.components.TicleTopBar
import com.devnunu.ticle.ui.theme.gray99
import com.devnunu.ticle.ui.theme.indigo40
import com.devnunu.ticle.util.NumberFormatUtil

@Composable
fun IncomeScreen(
    state: IncomeState,
    onEvent: (IncomeViewEvent) -> Unit
) {
    val userIncomeList = state.userIncomeList
    TicleScaffold(
        topBar = {
            TicleTopBar(
                rightDrawable = R.drawable.ic_plus_28px,
                onClickBackBtn = { onEvent(IncomeViewEvent.OnClickBackPress) },
                onClickRightDrawable = { onEvent(IncomeViewEvent.OnClickAddIncomeIcon) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = "총 수입",
                    fontSize = 14.sp
                )
                Text(
                    text = buildAnnotatedString {
                        append(state.totalIncomeText)
                        withStyle(style = SpanStyle(fontSize = 16.sp)) {
                            append(" 원")
                        }
                    },
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(gray99)
                    .padding(horizontal = 15.dp, vertical = 10.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("총 ")

                        withStyle(
                            style = SpanStyle(
                                color = indigo40,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            val incomeCount = state.userIncomeList.size.toString()
                            append(incomeCount)
                        }
                        append(" 건")
                    },
                    fontSize = 14.sp,
                )
                if (userIncomeList.isEmpty()) {
                    IncomeEmptyView(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterHorizontally),
                    )
                } else {
                    Spacer(modifier = Modifier.padding(10.dp))
                    userIncomeList.forEach {
                        IncomeItemView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            userIncome = it
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IncomeScreenPreview1() {
    IncomeScreen(
        state = IncomeState(userIncomeList = emptyList()),
        onEvent = {}
    )
}

@Preview(showBackground = true)
@Composable
fun IncomeScreenPreview2() {
    IncomeScreen(
        state = IncomeState(
            userIncomeList = listOf(
                UserIncome("수입", 100000)
            )
        ),
        onEvent = {}
    )
}