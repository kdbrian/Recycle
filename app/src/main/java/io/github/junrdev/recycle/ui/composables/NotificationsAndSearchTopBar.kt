package io.github.junrdev.recycle.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.ui.theme.cardo


@Preview
@Composable
private fun NotificationsAndSearchTopBarPrev() {
    MaterialTheme {
        NotificationsAndSearchTopBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsAndSearchTopBar(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {

        Surface(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.White, Color.Black),
                        start = Offset(20f, 200f),
                    )
                )
//                .blur(6.dp)
        ) {
            Image(
                contentDescription = null,
                painter = painterResource(R.drawable.people),
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

//        Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = {},
            modifier = Modifier
                .padding(24.dp),
            scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = null,
                        modifier = Modifier,
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = Color.Transparent,
            ),
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        )

        Text(
            text = "Discover",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            fontFamily = cardo,
            color = Color.White,
            fontSize = 50.sp
        )

    }
}