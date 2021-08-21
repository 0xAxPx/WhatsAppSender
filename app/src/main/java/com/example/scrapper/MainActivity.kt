package com.example.scrapper

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.scrapper.ui.MainContent
import com.example.scrapper.ui.theme.MainTheme

class MainActivity : AppCompatActivity() {

    init {
        instance = this
    }

    companion object {
        private var instance: MainActivity? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.app_name),
                                    color = MaterialTheme.colors.background
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(Icons.Filled.Menu, "")
                                }
                            },
                            backgroundColor = MaterialTheme.colors.primaryVariant,
                            contentColor = MaterialTheme.colors.background,
                            elevation = 12.dp
                        )
                    }, content = {
                        MainContent()
                    })
            }
        }
    }
}