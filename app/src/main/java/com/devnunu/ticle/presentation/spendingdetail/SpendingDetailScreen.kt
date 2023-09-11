package com.devnunu.ticle.presentation.spendingdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.R
import com.devnunu.ticle.core.ui.components.dialog.DialogWrapper
import com.devnunu.ticle.core.ui.components.dialog.TicleDialog
import com.devnunu.ticle.core.ui.components.scaffold.TicleScaffold
import com.devnunu.ticle.core.ui.components.topbar.TicleTopBar
import com.devnunu.ticle.core.ui.components.view.KeyValueView
import com.devnunu.ticle.core.ui.theme.Bold18
import com.devnunu.ticle.core.ui.theme.gray90
import com.devnunu.ticle.core.ui.theme.indigo90

@Composable
fun SpendingDetailScreen(
    state: SpendingDetailState,
    onEvent: (SpendingDetailViewEvent) -> Unit
) {
    val spending = state.userSpending
    DialogWrapper(dialogState = state.dialogState) { tag ->
        when (tag) {
            SpendingDetailDialogTag.ItemDelete -> {
                TicleDialog(
                    title = "정말로 삭제하시겠습니까?",
                    positiveBtnText = "삭제",
                    negativeBtnText = "취소",
                    onDialogEvent = { onEvent(SpendingDetailViewEvent.OnClickDeleteDialog(it)) }
                )
            }
        }
    }
    TicleScaffold(
        topBar = {
            TicleTopBar(
                rightText = "삭제",
                onClickBackBtn = { onEvent(SpendingDetailViewEvent.OnClickBackPress) },
                onClickRightText = { onEvent(SpendingDetailViewEvent.OnClickDeleteText) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = 20.dp,
                    end = 20.dp
                )
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.padding(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(40.dp)
                        .background(indigo90, RoundedCornerShape(10.dp))
                        .padding(6.dp),
                    painter = painterResource(id = R.drawable.ic_money_bag_16px),
                    contentDescription = null,
                )
                Text(
                    style = Bold18,
                    text = spending?.name.orEmpty()
                )
            }
            Divider(
                modifier = Modifier.padding(top = 30.dp, bottom = 20.dp),
                thickness = 1.dp,
                color = gray90,
            )
            KeyValueView(
                key = "금액",
                value = "${spending?.formattedValueText} 원"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpendingDetailScreenPreview() {
    SpendingDetailScreen(
        state = SpendingDetailState(),
        onEvent = {}
    )
}