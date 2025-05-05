package com.example.shopcookieui.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopcookieui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookiesScreenUi() {
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(scrollBehavior = scrollBehavior)
        },
        bottomBar = {
            NavBar()
        },
        contentColor = Color.DarkGray,
        content = { contentPadding ->
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
                    .background(Color.DarkGray)
                    .verticalScroll(scrollState)
            ) {
            }
        }
    )
}

@Composable
fun NavBar() {
    NavigationBar(
        modifier = Modifier
            .padding(8.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 35.dp,
                    topEnd = 35.dp,
                    bottomStart = 18.dp,
                    bottomEnd = 18.dp
                )
            ),
        containerColor = Color(0xFF3C3939),
        contentColor = Color(0xFFC9B683),
        content = {
            NavigationBarItem(
                selected = false, onClick = { }, icon = {
                Icon(
                    imageVector = Icons.Outlined.Home, contentDescription = "",
                    tint = Color(0xFFC9B683)
                )
            },
                label = {
                    Text(text = "home", color = Color(0xFFC9B683))
                }
            )
            NavigationBarItem(
                selected = false, onClick = { }, icon = {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart, contentDescription = "",
                        tint = Color(0xFFC9B683)
                    )
                },
                label = {
                    Text(text = "cart", color = Color(0xFFC9B683))
                }
            )
            NavigationBarItem(
                selected = false, onClick = { }, icon = {
                    Icon(
                        imageVector = Icons.Outlined.Search, contentDescription = "",
                        tint = Color(0xFFC9B683)
                    )
                },
                label = {
                    Text(text = "search", color = Color(0xFFC9B683))
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Cookies",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.cabin))
            )
        },
        modifier = modifier
            .wrapContentSize()
            .padding(6.dp),

        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logo), contentDescription = "",
                modifier
                    .size(70.dp)
                    .padding(6.dp)
            )
        },
        actions = {
            Box(
                modifier = modifier.size(55.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.shopping_bag_24),
                    contentDescription = "",
                    modifier = modifier
                        .clip(CircleShape)
                        .size(45.dp)
                        .align(alignment = Alignment.Center)
                        .background(Color.Black)
                        .padding(5.dp)
                )
                Badge {
                    Text(
                        text = "8", fontSize = 18.sp, fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.sora))
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.DarkGray,
            scrolledContainerColor = Color.DarkGray
        )

    )
}
