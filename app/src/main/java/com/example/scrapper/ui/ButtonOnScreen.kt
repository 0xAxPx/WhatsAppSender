package com.example.scrapper.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrapper.R
import com.example.scrapper.whatsapp.WhatsAppService

@Preview
@Composable
fun ExploreButtonOnScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        WhatsAppButton()
    }
}

@Composable
fun WhatsAppButton() {
    Button(
        onClick = {
            WhatsAppService.sendMessage()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(R.color.black)
        ),
        border = BorderStroke(width = 1.dp, color = colorResource(R.color.purple_500))
    ) {
        Text(
            text = stringResource(R.string.app_name),
            color = Color.White
        )
    }
}