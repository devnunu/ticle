package com.devnunu.ticle.presentation.spendinginput.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.ext.clickableRipple
import com.devnunu.ticle.core.ui.theme.Regular14
import com.devnunu.ticle.model.asset.spending.SpendingType

@Composable
fun SpendingTypeBottomSheet(
    onClickItem: (SpendingType) -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickableRipple(bounded = true) { onClickItem(SpendingType.FIXED) }
                .padding(horizontal = 15.dp, vertical = 20.dp),
            style = Regular14,
            text = SpendingType.FIXED.displayName,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickableRipple(bounded = true) { onClickItem(SpendingType.LOAN) }
                .padding(horizontal = 15.dp, vertical = 20.dp),
            style = Regular14,
            text = SpendingType.LOAN.displayName,
        )
    }
}