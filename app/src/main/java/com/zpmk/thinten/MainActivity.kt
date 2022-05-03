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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zpmk.thinten.ui.theme.FavouriteColor
import com.zpmk.thinten.ui.theme.OnSurfaceColor
import com.zpmk.thinten.ui.theme.RecentColor
import com.zpmk.thinten.ui.theme.ThinTenTheme

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
           Column() {
               Spacer(modifier = Modifier.height(10.dp))
               Row (
                   modifier = Modifier
                       .padding(horizontal = 25.dp, vertical = 10.dp)
                       .fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween,
               ){
                   Column {
                       Text(
                           text = "Good morning",
                           fontSize = 11.sp
                       )
                       Text(
                           text = "Anissa Saraswati",
                           fontSize = 18.sp,
                           fontWeight = FontWeight.Bold
                       )
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
           }
        }
    }
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