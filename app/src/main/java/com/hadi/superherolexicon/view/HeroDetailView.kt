package com.hadi.superherolexicon.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hadi.superherolexicon.R
import com.hadi.superherolexicon.components.AliasItem
import com.hadi.superherolexicon.components.HeroAppBar
import com.hadi.superherolexicon.components.HeroProperty
import com.hadi.superherolexicon.components.HeroPropertyCard
import com.hadi.superherolexicon.components.stats.StatView
import com.hadi.superherolexicon.data.model.Hero
import com.hadi.superherolexicon.ui.theme.accentColor
import java.util.*


@Composable
fun HeroDetailView(hero: Hero) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {

        HeroAppBar(hero = hero)

        //BIO
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            text = "BIO",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )

        HeroPropertyCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            propertyName = "Name",
            propertyValue = hero.name,
            icon = R.drawable.ic_name_3
        )

        HeroPropertyCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            propertyName = "Full Name",
            propertyValue = hero.biography?.fullName ?: "-",
            icon = R.drawable.ic_full_name
        )


        HeroPropertyCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            propertyName = "Alter Ego",
            propertyValue = hero.biography?.alterEgos ?: "-",
            icon = R.drawable.ic_mirror
        )

        HeroPropertyCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            propertyName = "Place of Birth",
            propertyValue = hero.biography?.placeOfBirth ?: "-",
            icon = R.drawable.ic_place_of_birth
        )

        HeroPropertyCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            propertyName = "First Appearance",
            propertyValue = hero.biography?.firstAppearance ?: "-",
            icon = R.drawable.ic_first_appearance
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroPropertyCard(
                modifier = Modifier
                    .weight(3F)
                    .wrapContentHeight()
                    .padding(end = 4.dp),
                propertyName = "Publisher",
                propertyValue = hero.biography?.publisher ?: "-",
                icon = R.drawable.ic_publisher
            )

            HeroPropertyCard(
                modifier = Modifier
                    .weight(2F)
                    .padding(start = 4.dp),
                propertyName = "Alignment",
                propertyValue = hero.biography?.alignment?.uppercase(Locale.getDefault()) ?: "-",
                icon = R.drawable.ic_alignment
            )
        }


        //Hero Statistics
        StatView(hero = hero)


        //Aliases
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            text = "ALIASES",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp, top = 8.dp)
        ) {
            hero.biography?.aliases?.let { aliases ->
                items(aliases.size) { index ->
                    AliasItem(alias = aliases[index])
                }
            }
        }

        //Appearance
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            text = "APPEARANCE",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroPropertyCard(
                modifier = Modifier
                    .weight(1F)
                    .padding(end = 4.dp),
                propertyName = "Gender",
                propertyValue = hero.appearance?.gender ?: "-",
                icon = R.drawable.ic_gender
            )

            HeroPropertyCard(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 4.dp),
                propertyName = "Race",
                propertyValue = hero.appearance?.race ?: "-",
                icon = R.drawable.ic_race
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroPropertyCard(
                modifier = Modifier
                    .weight(1F)
                    .padding(end = 4.dp),
                propertyName = "Height",
                propertyValue = hero.appearance?.height?.let { height ->
                    "${height[0]} inches \n${height[1]}"
                } ?: " - ",
                icon = R.drawable.ic_height_2
            )

            HeroPropertyCard(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 4.dp),
                propertyName = "Weight",
                propertyValue = hero.appearance?.weight?.let { weight ->
                    "${weight[0]}\n${weight[1]}"
                } ?: " - ",
                icon = R.drawable.ic_weight
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroPropertyCard(
                modifier = Modifier
                    .weight(1F)
                    .padding(end = 4.dp),
                propertyName = "Eye Color",
                propertyValue = hero.appearance?.eyeColor ?: "-",
                icon = R.drawable.ic_height_2
            )

            HeroPropertyCard(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 4.dp),
                propertyName = "Hair Color",
                propertyValue = hero.appearance?.hairColor ?: "-",
                icon = R.drawable.ic_weight
            )
        }

        //Occupation
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            text = "OCCUPATION",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = hero.work?.occupation ?: "-",
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )

        //Base
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            text = "BASE",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = hero.work?.base ?: "-",
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )


        //Affiliation
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            text = "GROUP AFFILIATION",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = hero.connections?.groupAffiliation ?: "-",
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )


        //Relatives
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            text = "RELATIVES",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = hero.connections?.relatives ?: "-",
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )
    }


}


