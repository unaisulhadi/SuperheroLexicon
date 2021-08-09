package com.hadi.superherolexicon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hadi.superherolexicon.R
import com.hadi.superherolexicon.ui.theme.accentColor
import com.hadi.superherolexicon.ui.theme.primary


@Composable
fun HeroPropertyCard(
    modifier: Modifier = Modifier,
    propertyName: String,
    propertyValue: String,
    icon: Int
) {

    val gradient = Brush.horizontalGradient(
        colors = listOf(
            accentColor,
            primary
        )
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(accentColor),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {

            Image(
                painter = painterResource(id = icon),
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 10.dp),
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    modifier = Modifier
                        .padding(top = 8.dp, end = 4.dp),
                    text = propertyName,
                    color = Color.Black,
                    style = MaterialTheme.typography.subtitle2
                )

                Text(
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 4.dp, end = 4.dp),
                    text = propertyValue,
                    color = Color.Black,
                    style = MaterialTheme.typography.subtitle1
                )

            }

        }

    }


}