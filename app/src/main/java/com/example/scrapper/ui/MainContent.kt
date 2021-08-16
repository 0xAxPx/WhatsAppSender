package com.example.scrapper.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrapper.R
import com.example.scrapper.ui.theme.Pink500
import com.example.scrapper.whatsapp.WhatsAppService
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalComposeUiApi
@Preview
@Composable
fun MainContent() {
    val systemUiController = rememberSystemUiController()

    //TODO
    SideEffect {
//        systemUiController.setStatusBarColor(
//            color = Pink500
//        )
//        systemUiController.setSystemBarsColor(
//            color = Color.Black
//        )
//        systemUiController.setNavigationBarColor(
//            color = Color.Green
//        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TelephoneEditText()
    }

}

@ExperimentalComposeUiApi
@Preview
@Composable
fun TelephoneEditText() {
    val textValue = remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        label = {
            Text(
                text = stringResource(
                    id = R.string.phoneNumber
                ),
                style = TextStyle(
                    color = MaterialTheme.colors.secondary,
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
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        keyboardActions = KeyboardActions(
            onDone = {keyboardController?.hide()}
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            unfocusedBorderColor = MaterialTheme.colors.secondary,
            focusedLabelColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.primaryVariant
        ),
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
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.secondary)
    ) {
        Text(
            text = stringResource(R.string.send),
            color = MaterialTheme.colors.primaryVariant
        )
    }
}
