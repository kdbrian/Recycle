package io.github.junrdev.recycler.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import io.github.junrdev.recycler.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class WasteCategory(
    @DrawableRes val image : Int?=null,
    @DrawableRes val backgroundTint : Int?=null,
    val imageUrl : String?=null,
    val category : String
) : Parcelable{
    companion object{
        fun getCategories() = listOf(
            WasteCategory(image = R.drawable.plastic_waste, backgroundTint = R.color.plasticWasteColor, category = "Plastic"),
            WasteCategory(image = R.drawable.metal_waste, category = "Metal", backgroundTint = R.color.metallicWasteColor),
            WasteCategory(image = R.drawable.glass_waste, category = "Glass", backgroundTint = R.color.glassWasteColor),
        )
    }
}
