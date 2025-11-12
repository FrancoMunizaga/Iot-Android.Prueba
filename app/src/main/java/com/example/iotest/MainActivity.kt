package com.example.iotest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.iotest.nav.AppNavGraph
import com.example.iotest.ui.theme.IOTESTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IOTESTTheme { AppNavGraph() }
        }
    }
}