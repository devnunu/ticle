package com.devnunu.ticle.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.R
import com.devnunu.ticle.core.ui.ext.clickableRipple
import com.devnunu.ticle.core.ui.theme.Bold24
import com.devnunu.ticle.core.ui.theme.Medium18
import com.devnunu.ticle.core.ui.theme.Regular12
import com.devnunu.ticle.core.ui.theme.indigo40
import com.devnunu.ticle.core.ui.theme.white

@Composable
fun SpareMoneyBanner(
    modifier: Modifier = Modifier,
    totalSummaryText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(indigo40, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .clickableRipple(bounded = true) { onClick() }
            .padding(horizontal = 20.dp, vertical = 15.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                style = Medium18,
                text = "여유 자금",
                color = white,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                style = Bold24,
                text = "$totalSummaryText 원",
                color = white,
            )
        }
        Divider(
            modifier = Modifier.padding(vertical = 10.dp),
            thickness = 0.5.dp,
            color = white
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(end = 5.dp),
                style = Regular12,
                text = "투자 계획을 세워보세요",
                color = white,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_calculator_24px),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TotalSummaryBoxViewPreview() {
    SpareMoneyBanner(
        totalSummaryText = "0",
        onClick = {}
    )
}