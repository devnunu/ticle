package com.devnunu.ticle.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TicleButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    enable: Boolean = true,
    onClickButton: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClickButton,
        enabled = enable,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White,
        )
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true)
@Composable
fun TicleButtonPreview() {
    TicleButton(
        buttonText = "확인",
        onClickButton = { }
    )
}