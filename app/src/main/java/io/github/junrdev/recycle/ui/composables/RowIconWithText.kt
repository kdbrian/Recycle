package io.github.junrdev.recycle.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Recycling
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


data class IconWithText(
    val title: String = "Tea pot",
    val icon: ImageVector = Icons.Rounded.Recycling
)

@Composable
fun RowIconWithText(modifier: Modifier = Modifier, iconWithText: IconWithText = IconWithText()) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)
    ) {
        Icon(imageVector = iconWithText.icon, contentDescription = iconWithText.title)
        Spacer(Modifier.width(6.dp))
        Text(text = iconWithText.title, style = MaterialTheme.typography.labelMedium)
    }
}