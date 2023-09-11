package com.devnunu.ticle.core.ui.components.dialog

import androidx.compose.runtime.Composable
import com.devnunu.ticle.core.ui.components.bottomsheet.ModalState

@Composable
fun <T> DialogWrapper(
    dialogState: ModalState<T>,
    content: @Composable (tag: T) -> Unit
) {
    if (dialogState is ModalState.Opened) {
        content(dialogState.tag)
    }
}
