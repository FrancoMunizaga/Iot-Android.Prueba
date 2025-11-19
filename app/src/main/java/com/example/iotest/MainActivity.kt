package com.example.iotest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.iotest.nav.AppNavGraph
import com.example.iotest.ui.theme.IOTESTTheme

class MainActivity : ComponentActivity() {
    private var keepSplash = true // condición para mantener el splash visible
    override fun onCreate(savedInstanceState: Bundle?) {
        // 1) Instalar Splash antes de super.onCreate
        val splash = installSplashScreen()
        splash.setKeepOnScreenCondition { keepSplash }
        super.onCreate(savedInstanceState)
        // 2) Simular/realizar inicialización breve (1–2 s)
        lifecycleScope.launchWhenCreated {
            // Aquí podrías leer token, preferencias, etc.
            kotlinx.coroutines.delay(1200L)
            keepSplash = false
        }
        // 3) Contenido Compose
        setContent {
            IOTESTTheme {
                AppNavGraph() // Tu NavHost con rutas Splash->Home (abajo un ejemplo)
            }
        }
    }
}