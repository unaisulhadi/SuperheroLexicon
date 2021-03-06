package com.hadi.superherolexicon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.hadi.superherolexicon.R
import com.hadi.superherolexicon.data.model.Hero
import com.hadi.superherolexicon.ui.theme.accentColor


@Composable
fun HeroAppBar(hero: Hero) {

    val builder = ImageRequest.Builder(LocalContext.current)

    Box(
        modifier = Modifier
            .height(450.dp)
    ) {

        AsyncImage(
            model = builder.data(data = hero.images?.lg)
                .placeholder(R.drawable.app_placeholder)
                .error(R.drawable.app_placeholder)
                .build(),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colors.primary
                        ),
                        startY = 500f
                    )
                )
        ) {

        }
        Box(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = hero.name ?: "-",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp
            )
        }
    }

}