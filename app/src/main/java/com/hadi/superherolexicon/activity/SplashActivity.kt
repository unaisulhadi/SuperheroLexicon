package com.hadi.superherolexicon.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.hadi.superherolexicon.R
import com.hadi.superherolexicon.ui.theme.SuperheroLexiconTheme
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.hero_lottie))
            val progress by animateLottieCompositionAsState(composition)

            val context = LocalContext.current

            LaunchedEffect(key1 = progress) {
                if (progress == 1.0f) {
                    val intent = Intent(context, HeroesActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }

            SuperheroLexiconTheme {
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center) {

                    LottieAnimation(
                        modifier = Modifier.size(140.dp),
                        composition = composition,
                    )

                }
            }
        }
    }
}
