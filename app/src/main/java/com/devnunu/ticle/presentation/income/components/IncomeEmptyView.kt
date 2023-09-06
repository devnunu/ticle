package com.devnunu.ticle.presentation.income.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.R

@Composable
fun IncomeEmptyView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .padding(bottom = 4.dp),
            painter = painterResource(id = R.drawable.ic_warning_24px),
            contentDescription = null
        )
        Text(text = "수입 내역이 없습니다")
    }
}