package com.hadi.superherolexicon.components.stats

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hadi.superherolexicon.ui.theme.accentColor

@Composable
fun CircularProgressBar(
    statTitle: String = "",
    percentage: Float,
    number: Int = 100,
    fontSize: TextUnit = 16.sp,
    radius: Dp = 32.dp,
    color: Color = accentColor,
    strokeWidth: Dp = 5.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(radius * 2f)
        ) {

            Canvas(modifier = Modifier.size(radius * 2f)) {
                drawArc(
                    color = Color.White,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Square)
                )
                drawArc(
                    color = color,
                    startAngle = -90f,
                    sweepAngle = 360 * curPercentage.value,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }
            Text(
                text = (curPercentage.value * number).toInt().toString(),
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                fontSize = fontSize
            )

        }

        Text(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 2.dp),
            text = statTitle,
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
            fontSize = fontSize
        )

    }


}