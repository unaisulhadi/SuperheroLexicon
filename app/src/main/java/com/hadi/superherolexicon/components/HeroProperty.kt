package com.hadi.superherolexicon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HeroProperty(
    propertyName: String,
    propertyValue: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = propertyName,
            modifier = Modifier.weight(1F),
            textAlign = TextAlign.End,
            color = Color.White,
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = ":",
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )
        Text(
            text = propertyValue,
            modifier = Modifier.weight(1F),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
        )
    }

}