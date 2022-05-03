package com.zpmk.thinten.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zpmk.thinten.ui.theme.OnSecondaryColor
import com.zpmk.thinten.ui.theme.RecentColor
import com.zpmk.thinten.ui.theme.SecondaryColor

@Composable
fun MyChip(
    text: String,
    background: Color = RecentColor,
    color: Color = OnSecondaryColor,
    modifier: Modifier= Modifier,
    paddingHorizontal: Dp = 20.dp,
    paddingVertical: Dp = 3.dp,
    radius: Dp = 20.dp
){
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .background(background, RoundedCornerShape(radius))
                .padding(horizontal = paddingHorizontal, vertical = paddingVertical),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = color, fontSize = 12.sp)
        }
    }
}