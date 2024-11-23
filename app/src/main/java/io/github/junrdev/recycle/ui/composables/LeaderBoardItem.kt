package io.github.junrdev.recycle.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.junrdev.recycle.R


@Preview
@Composable
private fun LeaderBoardPrev() {
    MaterialTheme {
        LeaderBoardItem()
    }
}

@Composable
fun LeaderBoardItem(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "1.", style = MaterialTheme.typography.labelLarge)

            Spacer(modifier = Modifier.width(12.dp))

            Image(
                painter = painterResource(R.drawable.image_1),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        }

        Column {
            Text(text = "Hello world", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Hello world, Hello world", color = Color.LightGray, style = MaterialTheme.typography.bodyLarge)
        }

        Text(
            text = "230 points",
            style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
            color = Color.Green,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

    }
}