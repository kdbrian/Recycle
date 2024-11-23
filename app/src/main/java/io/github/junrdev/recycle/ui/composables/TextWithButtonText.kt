package io.github.junrdev.recycle.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.junrdev.recycle.ui.theme.cardo
import io.github.junrdev.recycle.ui.theme.plusjakartasans


@Composable
fun TextWithButtonText(
    text: String = "Featured",
    buttonText: String = "See ALL",
    buttonOnClick:() -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            fontFamily = plusjakartasans,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )


        Button(
            onClick = buttonOnClick, colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(
                text = buttonText.uppercase(),
                fontFamily = cardo,
                fontWeight = FontWeight.Bold
            )
        }

    }
}