package com.devnunu.ticle.core.ui.components.input

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.R
import com.devnunu.ticle.core.ui.ext.clickableNonIndication
import com.devnunu.ticle.core.ui.theme.Regular14
import com.devnunu.ticle.core.ui.theme.Regular16
import com.devnunu.ticle.core.ui.theme.Regular22
import com.devnunu.ticle.core.ui.theme.black
import com.devnunu.ticle.core.ui.theme.gray40
import com.devnunu.ticle.core.ui.theme.gray80
import com.devnunu.ticle.core.ui.theme.gray95

@Composable
fun TicleSelectInput(
    modifier: Modifier = Modifier,
    label: String,
    value: String?,
    placeholder: String,
    onClickInput: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row {
            Text(
                style = Regular14,
                text = label,
                color = gray40,
            )
        }
        Box {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickableNonIndication { onClickInput() }
                    .padding(top = 10.dp, bottom = 7.dp),
                style = Regular22,
                text = if (value.isNullOrBlank()) placeholder else value,
                color = if (value.isNullOrBlank()) gray80 else black
            )
            Icon(
                modifier = Modifier.align(Alignment.CenterEnd),
                painter = painterResource(id = R.drawable.ic_arrow_down_16px),
                contentDescription = null,
                tint = gray80,
            )
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = gray95,
            thickness = 1.dp
        )
    }
}