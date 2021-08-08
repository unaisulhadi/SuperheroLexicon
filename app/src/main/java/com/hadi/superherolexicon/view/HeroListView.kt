package com.hadi.superherolexicon.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hadi.superherolexicon.components.HeroListItem
import com.hadi.superherolexicon.data.model.Hero
import com.hadi.superherolexicon.ui.theme.accentColor

@ExperimentalFoundationApi
@Composable
fun HeroListView(heroList: List<Hero>, onClick: (Hero) -> Unit) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Explore your \nHeroes",
            style = MaterialTheme.typography.h5,
            color = accentColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 24.dp)

        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.padding(top = 12.dp, start = 4.dp, end = 4.dp)
        ) {
            items(heroList.size) { index ->
                HeroListItem(heroList[index], onClick)
            }
        }

    }


}

