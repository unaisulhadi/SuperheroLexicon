package com.hadi.superherolexicon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hadi.superherolexicon.ui.theme.accentColor

@Composable
fun AliasItem(alias: String) {
    Box(
        modifier = Modifier
            .height(42.dp)
            .padding(end = 8.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(accentColor),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = alias,
            style = MaterialTheme.typography.subtitle1,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

    }
}