package com.devnunu.ticle.presentation.spending

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.ticle.R
import com.devnunu.ticle.core.ui.components.AssetEmptyView
import com.devnunu.ticle.presentation.spending.components.SpendingItemView
import com.devnunu.ticle.core.ui.components.TicleScaffold
import com.devnunu.ticle.core.ui.components.TicleTopBar
import com.devnunu.ticle.core.ui.theme.gray99
import com.devnunu.ticle.core.ui.theme.indigo40

@Composable
fun SpendScreen(
    state: SpendingState,
    onEvent: (SpendingViewEvent) -> Unit
) {
    val userSpendList = state.userSpendingList
    TicleScaffold(
        topBar = {
            TicleTopBar(
                rightDrawable = R.drawable.ic_plus_28px,
                onClickBackBtn = { onEvent(SpendingViewEvent.OnClickBackPress) },
                onClickRightDrawable = { onEvent(SpendingViewEvent.OnClickAddSpendingIcon) }
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
                    text = "총 지출",
                    fontSize = 14.sp
                )
                Text(
                    text = buildAnnotatedString {
                        append(state.totalSpendingText)
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
                            val incomeCount = state.userSpendingList.size.toString()
                            append(incomeCount)
                        }
                        append(" 건")
                    },
                    fontSize = 14.sp,
                )
                if (userSpendList.isEmpty()) {
                    AssetEmptyView(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterHorizontally),
                        description = "지출 내역이 없습니다"
                    )
                } else {
                    Spacer(modifier = Modifier.padding(10.dp))
                    userSpendList.forEach {
                        SpendingItemView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            userSpending = it
                        )
                    }
                }
            }
        }
    }
}