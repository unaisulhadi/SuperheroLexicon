package com.hadi.superherolexicon.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hadi.superherolexicon.components.HeroListItem
import com.hadi.superherolexicon.data.model.Hero
import com.hadi.superherolexicon.ui.theme.Grotesk
import com.hadi.superherolexicon.ui.theme.accentColor
import com.hadi.superherolexicon.viewmodel.HeroViewModel

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun HeroListView(heroList: List<Hero>, viewModel: HeroViewModel, onClick: (Hero) -> Unit) {

    val keyboardController = LocalSoftwareKeyboardController.current

    var search by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Explore",
            style = MaterialTheme.typography.h5,
            color = accentColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 24.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                .border(width = 2.dp, color = accentColor, shape = RoundedCornerShape(6.dp))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 8.dp, end = 8.dp),
                    tint = Color.White
                )

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterStart
                ) {


                    BasicTextField(
                        value = search,
                        onValueChange = {
                            search = it
                        },
                        maxLines = 1,
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontFamily = Grotesk,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        )
                    )

                    if (search.isEmpty()) {

                        Text(
                            text = "Search heroes...",
                            color = Color.White.copy(0.5F),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        )

                    }

                }
            }
        }



        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.padding(top = 12.dp, start = 4.dp, end = 4.dp)
        ) {
            val heroes = heroList.filter { it.name.contains(search, ignoreCase = true) }
            items(heroes.size) { index ->
                HeroListItem(heroes[index], onClick)
            }
        }
    }
}