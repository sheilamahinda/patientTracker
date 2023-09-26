package com.example.patienttracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.patienttracker.ui.theme.screens.Home.Homescreen
import com.example.patienttracker.ui.theme.screens.Login.LoginScreen
import com.example.patienttracker.ui.theme.screens.Patient.PatientScreen
import com.example.patienttracker.ui.theme.screens.Register.RegisterScreen
import com.example.patienttracker.ui.theme.screens.Splash.SplashScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_SPLASH) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_HOME) {
            Homescreen(navController)

        }
        composable(ROUTE_PATIENT) {
            PatientScreen(navController)

        }
        composable(ROUTE_SPLASH) {
            SplashScreen(navController)

        }
    }
}