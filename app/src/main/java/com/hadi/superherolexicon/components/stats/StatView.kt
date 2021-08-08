package com.hadi.superherolexicon.components.stats

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hadi.superherolexicon.data.model.Hero
import com.hadi.superherolexicon.ui.theme.accentColor
import com.hadi.superherolexicon.utils.getStat

@Composable
fun StatView(hero: Hero) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            text = "POWER STATS",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {

                CircularProgressBar(
                    statTitle = "Intelligence",
                    percentage = hero.powerstats?.intelligence?.getStat()?.div(100) ?: 0f
                )

            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {

                CircularProgressBar(
                    statTitle = "Strength",
                    percentage = hero.powerstats?.strength?.getStat()?.div(100) ?: 0f
                )

            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {

                CircularProgressBar(
                    statTitle = "Speed",
                    percentage = hero.powerstats?.speed?.getStat()?.div(100) ?: 0f
                )

            }

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {

                CircularProgressBar(
                    statTitle = "Durability",
                    percentage = hero.powerstats?.durability?.getStat()?.div(100) ?: 0f
                )

            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {

                CircularProgressBar(
                    statTitle = "Power",
                    percentage = hero.powerstats?.power?.getStat()?.div(100) ?: 0f
                )

            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {

                CircularProgressBar(
                    statTitle = "Combat",
                    percentage = hero.powerstats?.combat?.getStat()?.div(100) ?: 0f
                )

            }

        }

    }

}