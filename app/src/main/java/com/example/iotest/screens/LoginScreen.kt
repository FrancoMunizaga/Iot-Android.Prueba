package com.example.iotest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.iotest.R
import com.example.iotest.nav.Route
import com.example.iotest.ui.theme.IOTESTTheme




@Composable
fun LoginContent(
    user: String,
    pass: String,
    onUserChange: (String) -> Unit,
    onPassChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Image(
                painter = painterResource(id = R.drawable.ps1logo),
                contentDescription = null,
                modifier = Modifier
                    .size(size = 150.dp)
                    .align(Alignment.CenterHorizontally)
            )
        Spacer(Modifier.height(height = 32.dp))

        Text("wena choro", fontSize = 23.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(user, onUserChange, label = { Text("Usuario") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(pass, onPassChange, label = { Text("Contraseña") } )
        Spacer(Modifier.height(16.dp))
        Button(onClick = onLoginClick, modifier = Modifier.fillMaxWidth()) {
            Text("Ingresar")
        }
        TextButton(onClick = onRegisterClick, modifier = Modifier.align(Alignment.End)) {
            Text("¿No tienes cuenta? Regístrate")

        }
    }
}


@Composable
fun LoginScreen(nav: NavController) {
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    LoginContent(
        user, pass,
        onUserChange = { user = it },
        onPassChange = { pass = it },
        onLoginClick = { nav.navigate(Route.Home.path) },
        onRegisterClick = { nav.navigate(Route.Register.path) }
    )
}
@Preview(showBackground = true)
@Composable
fun LoginContentPreview() {
    IOTESTTheme {
        LoginContent(
            user = "javier@demo.cl",
            pass = "123456",
            onUserChange = {},
            onPassChange = {},
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}