package com.devnunu.ticle.presentation.income.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.ticle.R
import com.devnunu.ticle.core.ui.ext.clickableRipple
import com.devnunu.ticle.model.asset.income.UserIncome
import com.devnunu.ticle.core.ui.theme.indigo90
import com.devnunu.ticle.core.ui.theme.white

@Composable
fun IncomeItemView(
    modifier: Modifier = Modifier,
    userIncome: UserIncome,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(white, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .clickableRipple(bounded = true) { onClick() }
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Row {
            Image(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(30.dp)
                    .background(indigo90, RoundedCornerShape(10.dp))
                    .padding(6.dp),
                painter = painterResource(id = R.drawable.ic_money_bag_16px),
                contentDescription = null,
            )
            Column {
                Text(
                    text = userIncome.name
                )
                Text(
                    text = "${userIncome.formattedValueText} 원",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }
        }
    }
}