package com.devnunu.ticle.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicleInput(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onChangeInputText: (String) -> Unit,
    unitText: String? = null
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            fontSize = 15.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 10.dp),
                textStyle = TextStyle.Default.copy(fontSize = 25.sp),
                keyboardOptions = keyboardOptions,
                value = value,
                onValueChange = { newValue ->
                    onChangeInputText(newValue)
                },
            )
            if (!unitText.isNullOrBlank()) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = unitText,
                    fontSize = 25.sp
                )
            }
        }
        val borderColor = if (value.isNotEmpty()) Color.Blue else Color.Gray
        Divider(
            thickness = 1.dp,
            color = borderColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputPreview() {
    var inputText by remember { mutableStateOf("10000") }
    TicleInput(
        value = inputText,
        label = "Enter something",
        onChangeInputText = { newValue ->
            inputText = newValue
        },
        unitText = "kg"
    )
}