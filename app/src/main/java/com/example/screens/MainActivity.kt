package com.example.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.screens.Screen.nav.ScreenA
import com.example.screens.Screen.nav.ScreenB
import com.example.screens.Screen.nav.ScreenC // 👈 Asegúrate de importar ScreenC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Screens.ScreenA.route) {
                composable(route = Screens.ScreenA.route) {
                    ScreenA(navController)
                }
                composable(
                    route = Screens.ScreenB.route,
                    arguments = listOf(
                        navArgument("nombre") { type = NavType.StringType },
                        navArgument("correo") { type = NavType.StringType },
                        navArgument("profesion") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
                    val correo = backStackEntry.arguments?.getString("correo") ?: ""
                    val profesion = backStackEntry.arguments?.getString("profesion") ?: ""
                    ScreenB(navController, nombre, correo, profesion)
                }

                // 👉 Nueva ruta para pantalla C
                composable(route = Screens.ScreenC.route) {
                    ScreenC(navController)
                }
            }
        }
    }
}
