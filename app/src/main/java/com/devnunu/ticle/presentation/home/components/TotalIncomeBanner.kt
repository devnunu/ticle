package com.devnunu.ticle.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.ext.clickableRipple
import com.devnunu.ticle.core.ui.theme.Bold14
import com.devnunu.ticle.core.ui.theme.Bold16
import com.devnunu.ticle.core.ui.theme.Regular10
import com.devnunu.ticle.core.ui.theme.white

@Composable
fun TotalIncomeBanner(
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
            .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 15.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            style = Bold16,
            text = text,
            color = white
        )
        Text(
            style = Bold14,
            text = value,
            color = white
        )
        Text(
            modifier = Modifier.align(Alignment.End),
            style = Regular10,
            text = "더보기 >",
            color = white
        )
    }
}