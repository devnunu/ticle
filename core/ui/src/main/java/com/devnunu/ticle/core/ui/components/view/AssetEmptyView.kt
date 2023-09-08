package com.devnunu.ticle.core.ui.components.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.R

@Composable
fun AssetEmptyView(
    modifier: Modifier = Modifier,
    description: String
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
        Text(text = description)
    }
}