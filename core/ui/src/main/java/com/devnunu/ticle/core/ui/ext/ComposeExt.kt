package com.devnunu.ticle.core.ui.ext

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

private const val DEFAULT_THROTTLE_DURATION = 300L

fun Modifier.clickableRipple(
    bounded: Boolean = false,
    throttleDuration: Long = DEFAULT_THROTTLE_DURATION,
    onClick: () -> Unit,
): Modifier = composed {
    var lastEventMilli by remember { mutableStateOf(0L) }
    this.clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(bounded = bounded),
        onClick = {
            val now = System.currentTimeMillis()
            if (now - lastEventMilli >= throttleDuration) {
                lastEventMilli = now
                onClick()
            }
        }
    )
}

fun Modifier.clickableNonIndication(
    duration: Long = DEFAULT_THROTTLE_DURATION,
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    onClick: () -> Unit
): Modifier = composed {
    var lastEventMilli by remember { mutableStateOf(0L) }
    this.clickable(
        interactionSource = interactionSource,
        indication = null,
        onClick = {
            val now = System.currentTimeMillis()
            if (now - lastEventMilli >= duration) {
                lastEventMilli = now
                onClick()
            }
        }
    )
}