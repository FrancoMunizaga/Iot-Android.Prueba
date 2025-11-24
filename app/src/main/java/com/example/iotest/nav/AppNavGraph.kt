package com.example.iotest.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.iotest.R
import com.example.iotest.screens.HomeScreen
import com.example.iotest.screens.LoginScreen
import com.example.iotest.screens.RegisterScreen

// Splash screen display duration in milliseconds
private const val SPLASH_DISPLAY_DURATION = 1500L

@Preview(showBackground = true)

@Composable
fun AppNavGraph() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "splash") {
        composable("splash") {
            SplashLottie {
                nav.navigate(Route.Login.path) {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }
        composable(Route.Login.path) { LoginScreen(nav) }
        composable(Route.Register.path) { RegisterScreen(nav) }
        composable(Route.Home.path) { HomeScreen() }
    }
}


@Composable
fun SplashLottie(onFinish: () -> Unit) {
    // Load the Lottie composition from raw resources
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.ps1carga)
    )
    
    // Animate the composition with infinite iterations for smooth looping
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    // Navigate to next screen after configured delay
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(SPLASH_DISPLAY_DURATION)
        onFinish()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier
                .size(size = 256.dp)
                .align(Alignment.Center)
        )
    }
}
