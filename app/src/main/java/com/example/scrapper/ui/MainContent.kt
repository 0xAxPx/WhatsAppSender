package com.example.scrapper.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrapper.R
import com.example.scrapper.whatsapp.WhatsAppService

@Preview
@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        MaterialTheme {
            TelephoneEditText()
        }

    }

}

@Preview
@Composable
fun TelephoneEditText() {
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        label = {
            Text(
                text = stringResource(
                    id = R.string.phoneNumber
                ),
                style = TextStyle(
                    color = MaterialTheme.colors.primaryVariant
                )
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.phone_placeholder),
                style = TextStyle(
                    color = MaterialTheme.colors.primaryVariant,
                    textAlign = TextAlign.Center
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primaryVariant,
            unfocusedBorderColor = MaterialTheme.colors.primaryVariant,
            focusedLabelColor = MaterialTheme.colors.primaryVariant,
            cursorColor = MaterialTheme.colors.primaryVariant
        ),
        maxLines = 1
    )
    WhatsAppButton(textValue)
}

@Composable
fun WhatsAppButton(phone: MutableState<String>) {
    Button(
        onClick = {
            WhatsAppService.sendMessage(phone)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
        ),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.primaryVariant)
    ) {
        Text(
            text = stringResource(R.string.send),
            color = MaterialTheme.colors.primaryVariant
        )
    }
}
