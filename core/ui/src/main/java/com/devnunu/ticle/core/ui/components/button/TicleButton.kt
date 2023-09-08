package com.devnunu.ticle.core.ui.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devnunu.ticle.core.ui.theme.gray80
import com.devnunu.ticle.core.ui.theme.indigo50
import com.devnunu.ticle.core.ui.theme.white

@Composable
fun TicleButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    containerColor: Color = indigo50,
    contentColor: Color = white,
    enable: Boolean = true,
    onClickButton: () -> Unit
) {
    Button(
        modifier = modifier.height(50.dp),
        onClick = onClickButton,
        enabled = enable,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = containerColor,
            contentColor = contentColor,
            disabledBackgroundColor = gray80,
            disabledContentColor = white,
        )
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            text = buttonText
        )
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