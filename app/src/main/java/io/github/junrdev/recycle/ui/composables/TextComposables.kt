package io.github.junrdev.recycle.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.ui.theme.plusjakartasans

object TextComposables {


    @Composable
    fun LargeTextPreview(
        modifier: Modifier = Modifier,
        text: String = stringResource(R.string.am_a_teapot),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            fontFamily = plusjakartasans,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = modifier.padding(start = 8.dp)
        )

    }
}