package com.hadi.superherolexicon.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hadi.superherolexicon.components.AliasItem
import com.hadi.superherolexicon.components.HeroAppBar
import com.hadi.superherolexicon.components.HeroProperty
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
                .padding(start =12.dp,end = 12.dp, top = 12.dp),
            text = "BIO",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        HeroProperty(propertyName = "Name", propertyValue = hero.name ?: "-")
        HeroProperty(propertyName = "Full Name", propertyValue = hero.biography?.fullName ?: "-")
        HeroProperty(propertyName = "Alter Ego", propertyValue = hero.biography?.alterEgos ?: "-")
        HeroProperty(
            propertyName = "Place of Birth",
            propertyValue = hero.biography?.placeOfBirth ?: "-"
        )
        HeroProperty(
            propertyName = "First Appearance",
            propertyValue = hero.biography?.firstAppearance ?: "-"
        )
        HeroProperty(propertyName = "Publisher", propertyValue = hero.biography?.publisher ?: "-")
        HeroProperty(
            propertyName = "Alignment",
            propertyValue = hero.biography?.alignment?.uppercase(Locale.getDefault()) ?: "-"
        )


        //Hero Statistics
        StatView(hero = hero)


        //Aliases
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start =12.dp,end = 12.dp, top = 12.dp),
            text = "ALIASES",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 12.dp,end = 12.dp, top = 8.dp)
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
                .padding(start =12.dp,end = 12.dp, top = 12.dp),
            text = "APPEARANCE",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        HeroProperty(propertyName = "Gender", propertyValue = hero.appearance?.gender ?: "-")
        HeroProperty(propertyName = "Race", propertyValue = hero.appearance?.race ?: "-")
        HeroProperty(
            propertyName = "Height",
            propertyValue = hero.appearance?.height?.let { height ->
                "${height[0]} inches \n${height[1]}"
            } ?: " - ")
        HeroProperty(
            propertyName = "Weight",
            propertyValue = hero.appearance?.weight?.let { weight ->
                "${weight[0]}\n${weight[1]}"
            } ?: " - ")
        HeroProperty(propertyName = "Eye Color", propertyValue = hero.appearance?.eyeColor ?: "-")
        HeroProperty(propertyName = "Hair Color", propertyValue = hero.appearance?.hairColor ?: "-")


        //Occupation
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start =12.dp,end = 12.dp, top = 12.dp),
            text = "OCCUPATION",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = hero.work?.occupation ?: "-",
            modifier = Modifier
                .padding(horizontal = 12.dp,vertical = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )

        //Base
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start =12.dp,end = 12.dp, top = 12.dp),
            text = "BASE",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = hero.work?.base ?: "-",
            modifier = Modifier
                .padding(horizontal = 12.dp,vertical = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )


        //Affiliation
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start =12.dp,end = 12.dp, top = 12.dp),
            text = "GROUP AFFILIATION",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = hero.connections?.groupAffiliation ?: "-",
            modifier = Modifier
                .padding(horizontal = 12.dp,vertical = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )


        //Relatives
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start =12.dp,end = 12.dp, top = 12.dp),
            text = "RELATIVES",
            color = accentColor,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = hero.connections?.relatives ?: "-",
            modifier = Modifier
                .padding(horizontal = 12.dp,vertical = 4.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )
    }


}


