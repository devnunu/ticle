package com.devnunu.ticle.core.ui.components.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.R
import com.devnunu.ticle.core.ui.ext.clickableRipple
import com.devnunu.ticle.core.ui.theme.Regular14
import com.devnunu.ticle.core.ui.theme.gray50

@Composable
fun TicleTopBar(
    rightDrawable: Int? = null,
    rightText: String? = null,
    onClickBackBtn: () -> Unit,
    onClickRightDrawable: (() -> Unit)? = null,
    onClickRightText: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .padding(start = 16.dp, top = 11.dp, bottom = 11.dp)
                .clickableRipple { onClickBackBtn() },
            painter = painterResource(id = R.drawable.ic_arrow_left_bar_28px),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.weight(1f))
        if (rightDrawable != null) {
            Image(
                modifier = Modifier
                    .padding(end = 16.dp, top = 11.dp, bottom = 11.dp)
                    .clickableRipple { onClickRightDrawable?.invoke() },
                painter = painterResource(id = rightDrawable),
                contentDescription = null,
            )
        } else if (rightText != null) {
            Text(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
                    .clickableRipple { onClickRightText?.invoke() },
                style = Regular14,
                text = rightText,
                color = gray50,
            )
        }
    }
}