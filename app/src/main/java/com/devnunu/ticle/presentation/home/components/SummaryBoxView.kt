package com.devnunu.ticle.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.ticle.ui.ext.clickableRipple
import com.devnunu.ticle.ui.theme.Purple20
import com.devnunu.ticle.ui.theme.white

@Composable
fun SummaryBoxView(
    modifier: Modifier = Modifier,
    text: String,
    value: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(backgroundColor, RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(15.dp))
            .clickableRipple(bounded = true) { onClick() }
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = white
        )
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = white
        )
        Text(
            modifier = Modifier.align(Alignment.End),
            text = "더보기 >",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = white
        )
    }
}