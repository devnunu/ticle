package com.devnunu.ticle.core.ui.components.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.theme.Bold16
import com.devnunu.ticle.core.ui.theme.Medium16
import com.devnunu.ticle.core.ui.theme.gray70

@Composable
fun KeyValueView(
    key: String,
    value: String?
) {
    Row(
        modifier = Modifier.padding(vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            style = Medium16,
            text = key,
            color = gray70
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            style = Bold16,
            text = value ?: "-"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KeyValueViewPreview() {
    KeyValueView(
        key = "지출 금액",
        value = "30,000원"
    )
}