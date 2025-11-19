package com.example.iotest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.iotest.nav.Route
import com.example.iotest.ui.theme.IOTESTTheme


@Composable
fun RegisterScreen(nav: NavController) {
    var name by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf(value = "")}
    var telefono by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().padding(20.dp), verticalArrangement =
        Arrangement.Center) {
        Text("Crear cuenta", fontSize = 22.sp)
        OutlinedTextField(name, { name = it }, label = { Text("Nombre") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = apellido, {apellido = it}, label = {Text( "Apellido") })
        Spacer(Modifier.height(height = 8.dp))
        OutlinedTextField(value = telefono, {telefono = it}, label = {Text("Telefono") })
        Spacer(Modifier.height(height = 8.dp))
        OutlinedTextField(email, { email = it }, label = { Text("Correo") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(pwd, { pwd = it }, label = { Text("Contraseña") })
        Spacer(Modifier.height(16.dp))
        Button(onClick = { nav.navigate(Route.Login.path) }, modifier =
            Modifier.fillMaxWidth()) {
            Text("Crear cuenta")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    IOTESTTheme {
        RegisterScreen(
            nav = rememberNavController()
        )
    }
}