package com.example.patienttracker.ui.theme.screens.Splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.patienttracker.R
import com.example.patienttracker.navigation.ROUTE_HOME
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val scale= remember{
        Animatable(0f)

    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)

                }
            )
        )
        delay(3000L)
        navController.navigate(ROUTE_HOME)
    }
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.
        fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.bg5), contentDescription = "Logo"

        )

    }

}
@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())

}