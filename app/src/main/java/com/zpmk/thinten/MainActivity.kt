package com.zpmk.thinten

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.zpmk.thinten.ui.components.MainBannerItem
import com.zpmk.thinten.ui.theme.*
import com.zpmk.thinten.util.CourseGenerator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme()
        }
    }
}

@Composable
fun MainTheme(){
    ThinTenTheme {
        Surface(color = MaterialTheme.colors.background) {
           Column {
               Spacer(modifier = Modifier.height(10.dp))
               Row (
                   modifier = Modifier
                       .padding(horizontal = 25.dp, vertical = 10.dp)
                       .fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween,
               ){
                   Column {
                       SmallText(text = "Good Morning")
                       TitleText(text = "Anissa Saraswati")
                   }
                   Image(
                       painter = painterResource(id = R.drawable.jisoo),
                       contentDescription = "Profile picture",
                       modifier = Modifier
                           .size(32.dp)
                           .clip(CircleShape),
                       contentScale = ContentScale.Crop
                   )
               }
               Row(
                   modifier = Modifier.padding(horizontal = 25.dp, vertical = 10.dp)
               ) {
                   MyButton(
                       text = "Favourites",
                       icon = Icons.Default.Favorite,
                       iconBgColor = FavouriteColor,
                       onClick = {}
                   )
                   Spacer(modifier = Modifier.width(10.dp))
                   MyButton(
                       text = "Recent",
                       icon = Icons.Default.Refresh,
                       iconBgColor = RecentColor,
                       onClick = {}
                   )
               }
               Spacer(modifier = Modifier.height(20.dp))
               MainBanner()
           }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun MainBanner(){
    val courseList = CourseGenerator.genereate()
    Column {
        val pagerState = rememberPagerState()
        BigText(text = "Start Your Day", modifier = Modifier.padding(horizontal = 25.dp))
        Spacer(modifier = Modifier.height(15.dp))
        HorizontalPager(
            count = 3,
            state = pagerState,
            // Add 32.dp horizontal padding to 'center' the pages
            contentPadding = PaddingValues(horizontal = 40.dp),
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
        ) { page ->
            MainBannerItem(course = courseList[page])
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = SecondaryColor,
            inactiveColor = HintColor
        )
    }
}

@Composable
fun TitleText(
    modifier: Modifier= Modifier,
    text: String,
    color: Color = OnBackgroundColor,
    fontWeight: FontWeight = FontWeight.Bold,
    size: TextUnit = 20.sp
){
    Text(
        text = text,
        fontSize = size,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier
    )
}
@Composable
fun BigText(
    modifier: Modifier= Modifier,
    text: String,
    color: Color = OnBackgroundColor,
    fontWeight: FontWeight = FontWeight.Bold,
    size: TextUnit = 18.sp
){
    Text(
        text = text,
        fontSize = size,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier
    )
}
@Composable
fun NormalText(
    modifier: Modifier= Modifier,
    text: String,
    color: Color = OnBackgroundColor,
    fontWeight: FontWeight = FontWeight.Normal,
    size: TextUnit = TextUnit.Unspecified
){
    Text(
        text = text,
        fontSize = size,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier

    )
}
@Composable
fun SmallText(
    modifier: Modifier= Modifier,
    text: String,
    color: Color = HintColor,
    fontWeight: FontWeight = FontWeight.Normal,
    size: TextUnit = 10.sp
){
    Text(
        text = text,
        fontSize = size,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier
    )
}

@Composable
fun MyButton(text: String, icon: ImageVector = Icons.Default.Favorite, onClick: ()->Unit, iconBgColor: Color = FavouriteColor){
    OutlinedButton(onClick = onClick, shape = RoundedCornerShape(6.dp)) {
        Box(
            modifier = Modifier
                .width(33.dp)
                .height(33.dp)
                .background(iconBgColor, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ){
            Icon(
                icon,
                contentDescription = "Icon",
                tint = Color.White,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, color = OnSurfaceColor)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainTheme()
}