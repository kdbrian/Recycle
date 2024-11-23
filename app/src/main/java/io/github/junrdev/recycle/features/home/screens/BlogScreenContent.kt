package io.github.junrdev.recycle.features.home.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.domain.model.FeaturedContent
import io.github.junrdev.recycle.ui.composables.FeaturedContentItem
import io.github.junrdev.recycle.ui.composables.HorizontalFeaturedContentItem
import io.github.junrdev.recycle.ui.composables.TextComposables
import io.github.junrdev.recycle.ui.theme.cardo

class BlogScreenContent : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        containerColor = colorResource(R.color.background_dark)
                    ) { paddingValues ->
                        BlogScreenContentImpl(Modifier.padding(paddingValues))
                    }
                }
            }
        }
    }

    @Composable
    private fun BlogScreenContentImpl(
        modifier: Modifier = Modifier,
        items: List<FeaturedContent> = FeaturedContent.getFeaturedContent()
    ) {

        val scrollState = rememberScrollState()

        Column(modifier = modifier.verticalScroll(scrollState)) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.people),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.4f), color = Color.Black
                ) { }

                Text(
                    text = "Hello world",
                    fontFamily = cardo,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    fontSize = 30.sp,
                    textAlign = TextAlign.Start
                )
            }

            TextComposables.LargeTextPreview(text = "Featured")

            //Todo:inflate rows according to size
            LazyHorizontalGrid(
                rows = GridCells.Fixed(1),
                modifier = Modifier
                    .height(300.dp)
            ) {
                items(items = items.subList(0, 3)) {
                    FeaturedContentItem(item = it)
                }
            }

            TextComposables.LargeTextPreview(text = "Trending")

            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier
                    .height(250.dp)
            ) {
                items(items = FeaturedContent.getFeaturedContent()) {
                    HorizontalFeaturedContentItem(item = it)
                }
            }

        }
    }


    @Preview
    @Composable
    private fun BlogsPrev() {
        MaterialTheme {
            BlogScreenContentImpl(modifier = Modifier.fillMaxSize())
        }
    }
}