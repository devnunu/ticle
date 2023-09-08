package com.devnunu.ticle.core.ui.components.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devnunu.ticle.core.ui.theme.Regular14
import com.devnunu.ticle.core.ui.theme.Regular16
import com.devnunu.ticle.core.ui.theme.Regular22
import com.devnunu.ticle.core.ui.theme.gray40
import com.devnunu.ticle.core.ui.theme.gray70
import com.devnunu.ticle.core.ui.theme.gray80
import com.devnunu.ticle.core.ui.theme.gray90
import com.devnunu.ticle.core.ui.theme.indigo40

@Composable
fun TicleInput(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    placeholder: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onChangeInputText: (String) -> Unit,
    unitText: String? = null
) {
    Column(
        modifier = modifier
    ) {
        Text(
            style = Regular14,
            text = label,
            color = gray40,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 5.dp),
                textStyle = Regular22,
                keyboardOptions = keyboardOptions,
                value = value,
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        if (value.isBlank()) {
                            Text(
                                style = Regular22,
                                text = placeholder,
                                color = gray80,
                            )
                        }
                    }
                    innerTextField()
                },
                onValueChange = { newValue ->
                    onChangeInputText(newValue)
                },
            )
            if (!unitText.isNullOrBlank()) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = unitText,
                    fontSize = 16.sp
                )
            }
        }
        val borderColor = if (value.isNotEmpty()) indigo40 else gray90
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
        value = "",
        label = "Enter something",
        placeholder = "placeHolder",
        onChangeInputText = { newValue ->
            inputText = newValue
        },
        unitText = "kg"
    )
}