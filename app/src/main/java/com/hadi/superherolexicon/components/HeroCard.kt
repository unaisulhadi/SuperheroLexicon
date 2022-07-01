package com.hadi.superherolexicon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.hadi.superherolexicon.R
import com.hadi.superherolexicon.data.model.Hero
import com.hadi.superherolexicon.ui.theme.card

@Composable
fun HeroListItem(hero: Hero, onClick: (Hero) -> Unit) {

    val builder = ImageRequest.Builder(LocalContext.current)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(card)
            .clickable(onClick = { onClick(hero) }),
    ) {


        Box(
            modifier = Modifier
                .height(250.dp)
        ) {


            AsyncImage(
                model = builder.data(data = hero.images?.md)
                    .placeholder(R.drawable.app_placeholder)
                    .error(R.drawable.app_placeholder)
                    .build(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
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
                                Color.Black
                            ),
                            startY = 300f
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
                    color = Color.White
                )
            }
        }

    }


}
