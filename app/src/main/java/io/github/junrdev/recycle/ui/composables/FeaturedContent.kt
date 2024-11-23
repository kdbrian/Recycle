package io.github.junrdev.recycle.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.junrdev.recycle.domain.model.FeaturedContent


@Preview
@Composable
private fun FeaturedContentPrev() {
    MaterialTheme {
//        FeaturedContentHorizontalList()
//        HorizontalFeaturedContentItem()
        FeaturedContentHorizontalGrid()
    }
}


@Composable
fun FeaturedContentItem(
    modifier: Modifier = Modifier
        .width(200.dp)
        .wrapContentHeight()
        .padding(6.dp),
    item: FeaturedContent = FeaturedContent.getFeaturedContent()[0]
) {

    Column(modifier = modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(item.preview),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Text(
            text = item.category,
            color = Color.LightGray,
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = item.title,
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

    }

}


@Preview
@Composable
fun HorizontalFeaturedContentItem(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp),
    item: FeaturedContent = FeaturedContent.getFeaturedContent()[0]
) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.preview),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = item.category,
                color = Color.LightGray,
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = item.title,
                style = MaterialTheme.typography.labelLarge,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Composable
fun FeaturedContentHorizontalList(
    modifier: Modifier = Modifier.fillMaxWidth(),
    items: List<FeaturedContent> = FeaturedContent.getFeaturedContent()
) {
    LazyRow(modifier = modifier) {
        itemsIndexed(items = items) { _, item ->
            FeaturedContentItem(item = item)
        }
    }
}

@Preview
@Composable
fun FeaturedContentHorizontalGrid(
    modifier: Modifier = Modifier,
    items: List<FeaturedContent> = FeaturedContent.getFeaturedContent()
) {
    LazyHorizontalGrid(modifier = modifier.wrapContentHeight(), rows = GridCells.Fixed(2)) {
        items(items = items) {
            HorizontalFeaturedContentItem(item = it)
        }
    }
}