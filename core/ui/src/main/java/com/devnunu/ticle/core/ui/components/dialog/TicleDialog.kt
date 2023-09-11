package com.devnunu.ticle.core.ui.components.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.devnunu.ticle.core.ui.components.button.TicleButton
import com.devnunu.ticle.core.ui.theme.Bold18
import com.devnunu.ticle.core.ui.theme.Regular14
import com.devnunu.ticle.core.ui.theme.black
import com.devnunu.ticle.core.ui.theme.gray70

@Composable
fun TicleDialog(
    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
    title: String? = null,
    description: String? = null,
    positiveBtnText: String? = null,
    negativeBtnText: String? = null,
    onDialogEvent: (DialogBtn) -> Unit = {}
) {
    Dialog(
        onDismissRequest = { onDialogEvent(DialogBtn.DISMISS) },
        properties = properties
    ) {
        Surface(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            color = Color.White,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                ) {
                    Spacer(modifier = Modifier.height(42.dp))
                    title?.let {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            text = it,
                            style = Bold18,
                            textAlign = TextAlign.Center
                        )
                    }
                    description?.let {
                        if (title != null) {
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                        val style = if (title != null) Regular14 else Bold18
                        val color = if (title != null) gray70 else black
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            text = it,
                            style = style,
                            color = color,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.padding(22.dp))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                ) {
                    negativeBtnText?.let {
                        TicleButton(
                            modifier = Modifier.weight(1f),
                            containerColor = gray70,
                            buttonText = it,
                            onClickButton = { onDialogEvent.invoke(DialogBtn.NEGATIVE) }
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    positiveBtnText?.let {
                        TicleButton(
                            modifier = Modifier.weight(1f),
                            buttonText = it,
                            onClickButton = { onDialogEvent.invoke(DialogBtn.POSITIVE) }
                        )
                    }
                }
            }
        }
    }
}