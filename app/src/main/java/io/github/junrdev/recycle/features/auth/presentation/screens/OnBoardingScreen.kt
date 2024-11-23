package io.github.junrdev.recycle.features.auth.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil3.compose.rememberAsyncImagePainter
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.ui.composables.LeaderBoardItem
import io.github.junrdev.recycle.ui.composables.RowIconWithText
import io.github.junrdev.recycle.ui.theme.cardo
import io.github.junrdev.recycle.ui.theme.plusjakartasans

class OnBoardingScreen : Fragment() {

    val moveToLoginInfo = {
        findNavController().navigate(R.id.action_onBoardingScreen2_to_enterAccountInfo2)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        println("created")

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    OnBoardingScreenImpl(
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding(),
                        onGetStartedClicked = moveToLoginInfo
                    )
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun OnBoardingScreenPrev() {
    OnBoardingScreenImpl() {}
}


@Composable
fun OnBoardingScreenImpl(modifier: Modifier = Modifier, onGetStartedClicked: () -> Unit) {

    Scaffold(modifier = modifier) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            Surface(modifier = Modifier.fillMaxSize().blur(12.dp)) {
                Image(
                    painter = painterResource(R.drawable.recycled_money),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pellentesque ut purus",
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(Modifier.height(12.dp))


                Button(onClick = onGetStartedClicked) {
                    Text(text = "Get started")
                }

                Spacer(Modifier.height(20.dp))
            }

        }
    }
}

@Composable
fun OnBoardingScreenOne(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A1B25)),
        contentAlignment = Alignment.Center
    ) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Text(
                    text = "Pellentesque ut purus",
                    style = MaterialTheme.typography.labelMedium
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    RowIconWithText()
                    RowIconWithText()
                    RowIconWithText()
                }

            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "Pellentesque ut purus a ante blandit vulputate.",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                style = MaterialTheme.typography.titleLarge,
                fontFamily = cardo,
                color = Color.White,
                textAlign = TextAlign.Center
            )


            Card(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Get started",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = cardo
                )
            }

        }


    }
}

@Composable
fun OnBoardingScreenTwo(modifier: Modifier = Modifier) {

    val imageUrl =
        rememberAsyncImagePainter(
            "https://cdn.vanguardngr.com/wp-content/uploads/2020/07/crowd-population.jpg",
            placeholder = painterResource(R.drawable.image_6)
        )


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A1B25)),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Text(
                    text = "Leaderboards",
                    style = MaterialTheme.typography.labelMedium
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    LazyColumn {
                        item {
                            LeaderBoardItem()
                        }

                        item {
                            LeaderBoardItem()
                        }

                        item {
                            LeaderBoardItem()
                        }
                    }
                }

            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "Pellentesque ut purus a ante blandit vulputate.",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                style = MaterialTheme.typography.titleLarge,
                fontFamily = cardo,
                color = Color.White,
                textAlign = TextAlign.Center
            )


            Card(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Get started",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = cardo
                )
            }

        }


    }
}

@Composable
fun OnBoardingScreenThree(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome to Recycler", style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = cardo,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp
            )
        )


        Text(
            text = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = plusjakartasans,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.LightGray,
                lineHeight = 26.sp
            ),
            modifier = Modifier.padding(top = 10.dp, bottom = 18.dp)
        )


        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(Modifier.width(8.dp))
                Text(text = "Continue with Google")
            }
        }

        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    imageVector = Icons.Outlined.Mail,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(Modifier.width(8.dp))
                Text(text = "Continue with Email")
            }
        }

    }
}