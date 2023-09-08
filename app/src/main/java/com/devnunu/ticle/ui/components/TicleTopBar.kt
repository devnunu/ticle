package com.devnunu.ticle.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.R
import com.devnunu.ticle.ui.ext.clickableRipple

@Composable
fun TicleTopBar(
    rightDrawable: Int? = null,
    onClickBackBtn: () -> Unit,
    onClickRightDrawable: (() -> Unit)? = null,
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
        }
    }
}