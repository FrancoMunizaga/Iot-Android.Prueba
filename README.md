# Iot-Android.Prueba

Android application with IoT features, built using Jetpack Compose and Material3 design.

## Features

### 🚀 Splash Screen Implementation

This app implements a complete splash screen experience using:

1. **Native Android Splash Screen API** (`core-splashscreen:1.2.0`)
2. **Lottie Animations** for smooth loading experience
3. **Jetpack Compose Navigation** for seamless transitions

#### Splash Flow

The application follows this startup sequence:

```
App Launch → Native Splash (1.2s) → Lottie Animation (1.5s) → Login Screen
```

**Phase 1: Native Splash Screen**
- Displays the `ps1logo` icon on a `purple_700` background
- Shown while the app initializes (approximately 1.2 seconds)
- Uses `Theme.App.Splash` with `postSplashScreenTheme` pointing to `Theme.IOTEST`
- Managed by `MainActivity.installSplashScreen()` with `keepSplash` condition

**Phase 2: Lottie Animation**
- Shows a custom loading animation from `res/raw/ps1carga.json`
- Animated using Lottie Compose library
- Displays for 1.5 seconds with infinite loop animation
- Background color matches Material3 theme primary color

**Phase 3: Navigation**
- Automatically navigates to Login screen after animation
- Uses Navigation Compose with proper backstack management
- Prevents returning to splash screen via back button

#### Technical Implementation

**MainActivity.kt**
```kotlin
val splash = installSplashScreen()
splash.setKeepOnScreenCondition { keepSplash }
// ... delay 1200ms then set keepSplash = false
```

**themes.xml**
```xml
<style name="Theme.App.Splash" parent="Theme.SplashScreen">
    <item name="windowSplashScreenAnimatedIcon">@drawable/ps1logo</item>
    <item name="windowSplashScreenBackground">@color/purple_700</item>
    <item name="postSplashScreenTheme">@style/Theme.IOTEST</item>
</style>
```

**AppNavGraph.kt**
```kotlin
NavHost(navController = nav, startDestination = "splash") {
    composable("splash") {
        SplashLottie { 
            nav.navigate(Route.Login.path) { 
                popUpTo("splash") { inclusive = true } 
            } 
        }
    }
    // ... other routes
}
```

### 📱 Navigation Structure

- **Splash Screen** → Initial loading with animation
- **Login Screen** → User authentication
- **Register Screen** → New user registration
- **Home Screen** → Main application screen

## Dependencies

- Jetpack Compose with Material3
- Navigation Compose (2.8.3)
- Lottie Compose (6.4.0)
- Core SplashScreen (1.2.0)
- Lifecycle Runtime KTX (2.8.6)

## Build Requirements

- Android Studio Iguana or later
- Kotlin 2.0.21
- Android Gradle Plugin 8.3.2
- compileSdk: 36
- minSdk: 24
- targetSdk: 36

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle dependencies
4. Run on emulator or physical device

The splash screen will automatically show on app launch.