package com.zpmk.thinten.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.zpmk.thinten.BigText
import com.zpmk.thinten.R
import com.zpmk.thinten.SmallText
import com.zpmk.thinten.model.CourseItem
import com.zpmk.thinten.ui.theme.OnSecondaryColor

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainBannerItem(course: CourseItem) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        elevation = 3.dp,
        modifier = Modifier.padding(end = 10.dp)
    ) {
        ConstraintLayout{
            val (title, row, chip) = createRefs()
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(course.posterUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.jisoo),
                contentDescription = course.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color(0xA4000000)),
                            startY = size.height / 3,
                            endY = size.height
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient)
                        }
                    },
            )
            BigText(text = course.title, color = OnSecondaryColor, modifier = Modifier.constrainAs(title){
                bottom.linkTo(row.top, margin = 5.dp)
                absoluteLeft.linkTo(parent.absoluteLeft, margin = 10.dp)
            })
            MyChip(text = course.status, modifier = Modifier.constrainAs(chip){
                top.linkTo(parent.top, margin=10.dp)
                absoluteLeft.linkTo(parent.absoluteLeft, margin = 10.dp)
            })
            Row(modifier = Modifier.constrainAs(row){
                bottom.linkTo(parent.bottom, margin = 10.dp)
                absoluteLeft.linkTo(parent.absoluteLeft, margin = 10.dp)
            }) {
                Icon(Icons.Default.PlayArrow, contentDescription = "Play", Modifier.size(12.dp), tint = OnSecondaryColor)
                Spacer(modifier = Modifier.width(5.dp))
                SmallText(text = course.type, color = OnSecondaryColor)
                Spacer(modifier = Modifier.width(5.dp))
                SmallText(text = course.durationString, color = OnSecondaryColor)
            }
        }
    }
}
