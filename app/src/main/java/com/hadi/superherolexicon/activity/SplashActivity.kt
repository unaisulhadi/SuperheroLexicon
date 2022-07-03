package com.hadi.superherolexicon.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hadi.superherolexicon.R
import com.hadi.superherolexicon.ui.theme.SuperheroLexiconTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scale = remember {
                Animatable(initialValue = 0F)
            }

            val context = LocalContext.current

            LaunchedEffect(key1 = true){
                scale.animateTo(
                    0.5F,
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = {
                            OvershootInterpolator(2F).getInterpolation(it)
                        }
                    )
                )
                delay(2500L)
                val intent = Intent(context,HeroesActivity::class.java)
                startActivity(intent)
                finish()
            }


            SuperheroLexiconTheme {
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center) {



                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .scale(scale = scale.value),
                        painter = painterResource(id = R.drawable.superhero_logo_colored),
                        contentDescription = "Splash Logo"
                    )

                }
            }
        }
    }
}
