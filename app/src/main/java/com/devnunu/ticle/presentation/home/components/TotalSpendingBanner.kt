package com.devnunu.ticle.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TotalSpendingBanner(
    modifier: Modifier = Modifier,
    label: String
) {
    Column(
        modifier = modifier
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(vertical = 15.dp, horizontal = 10.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "지출",
                fontSize = 12.sp,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "0 원",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}