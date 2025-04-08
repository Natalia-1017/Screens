package com.example.screens.Screen.nav


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.screens.Screens
import com.example.screens.Data.ListaUsuarios
import com.example.screens.Data.Usuario
import com.example.screens.R // <- importante

@Composable
fun ScreenA(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var profesion by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(Color(0xFF0F2027), Color(0xFF203A43), Color(0xFF2C5364))
                )
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.mariposa),
                contentDescription = "Mariposa decorativa",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.White,
                    cursorColor = Color.Cyan
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.White,
                    cursorColor = Color.Cyan
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = profesion,
                onValueChange = { profesion = it },
                label = { Text("Profesión", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.White,
                    cursorColor = Color.Cyan
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    ListaUsuarios.agregarUsuario(Usuario(nombre, correo, profesion))
                    navController.navigate(
                        Screens.ScreenB.createRoute(nombre, correo, profesion)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00BCD4),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
            ) {
                Text("Enviar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
