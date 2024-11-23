package io.github.junrdev.recycle.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.domain.model.RecycleCategoryItem
import io.github.junrdev.recycle.ui.theme.plusjakartasans

@Preview
@Composable
private fun CardPrev() {
    CardComposables.PopularSearchItem(
        categoryItem = RecycleCategoryItem(
            categoryName = "Plastic",
            categoryImage = R.drawable.plastic
        )
    )
}


object CardComposables {

    @Composable
    fun PopularSearchItem(
        modifier: Modifier = Modifier,
        categoryItem: RecycleCategoryItem = RecycleCategoryItem.getCategories()[0]
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    color = listOf(
                        Color(0xFFFDE4E1),
                        Color(0xFFE5F2F8),
                        Color(0xFFF5F3CE),
                        Color(0xFFE8F8E5),
                        Color(0xFFF9E4F7)
                    ).random(),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
        ) {

            Row (
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    painter = painterResource(categoryItem.categoryImage), // Replace with actual icons
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    tint = colorResource(R.color.background_dark)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = categoryItem.categoryName,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    fontFamily = plusjakartasans,
                    fontSize = 20.sp
                )
            }


            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                tint = Color.Gray
            )

        }
    }

}