package com.devnunu.ticle.core.ui.components.scaffold

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.devnunu.ticle.core.ui.components.bottomsheet.ModalState

@OptIn(ExperimentalMaterialApi::class)
data class ScaffoldBottomSheetView(
    val viewModelSheetState: ModalState<*>,
    val sheetState: ModalBottomSheetState,
    val sheetShape: Shape,
    val sheetContent: @Composable ColumnScope.() -> Unit,
)

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun TicleScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    bottomSheetView: ScaffoldBottomSheetView? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
    ) { paddingValues ->
        content(paddingValues)
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    if (bottomSheetView != null) {
        LaunchedEffect(bottomSheetView.viewModelSheetState) {
            when (bottomSheetView.viewModelSheetState) {
                is ModalState.Closed -> {
                    keyboardController?.hide()
                    bottomSheetView.sheetState.hide()
                }

                is ModalState.Opened -> {
                    keyboardController?.hide()
                    bottomSheetView.sheetState.show()
                }
            }
        }
        ModalBottomSheetLayout(
            sheetState = bottomSheetView.sheetState,
            sheetShape = bottomSheetView.sheetShape,
            sheetContent = bottomSheetView.sheetContent,
            content = {}
        )
    }
}