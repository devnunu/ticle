package com.devnunu.ticle.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.ticle.core.ui.theme.Bold12
import com.devnunu.ticle.core.ui.theme.Bold14
import com.devnunu.ticle.core.ui.theme.Bold18
import com.devnunu.ticle.core.ui.theme.Medium14
import com.devnunu.ticle.core.ui.theme.gray60
import com.devnunu.ticle.core.ui.theme.gray90
import com.devnunu.ticle.model.asset.spending.UserSpending
import com.devnunu.ticle.util.NumberFormatUtil

@Composable
fun TotalSpendingBanner(
    modifier: Modifier = Modifier,
    label: String,
    spendingList: List<UserSpending>,
    value: Long,
) {
    Column(
        modifier = modifier
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(top = 15.dp, bottom = 15.dp, start = 10.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                style = Bold18,
                text = label,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "총 ${NumberFormatUtil.toCurrencyFormText(value)} 원",
                style = Bold14,
            )
        }
        if (spendingList.isNotEmpty()) {
            Divider(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                thickness = 1.dp,
                color = gray90,
            )
        }
        spendingList.map {
            Row(
                modifier = Modifier.padding(vertical = 10.dp),
            ) {
                Text(
                    style = Medium14,
                    text = it.name,
                    color = gray60
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    style = Bold14,
                    text = "${NumberFormatUtil.toCurrencyFormText(it.value)} 원",
                    color = gray60
                )
            }
        }
    }
}