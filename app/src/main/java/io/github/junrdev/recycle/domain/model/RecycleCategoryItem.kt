package io.github.junrdev.recycle.domain.model

import androidx.annotation.DrawableRes
import io.github.junrdev.recycle.R
import java.util.UUID

data class RecycleCategoryItem(
    val id: String = UUID.randomUUID().toString(),
    val categoryName: String = "Some name",
    @DrawableRes val categoryImage: Int
){

    companion object{
        fun getCategories() = listOf(
            RecycleCategoryItem(
                categoryName = "Plastic",
                categoryImage = R.drawable.plastic
            ),
            RecycleCategoryItem(
                categoryName = "Metal",
                categoryImage = R.drawable.metal
            ),
            RecycleCategoryItem(
                categoryName = "Paper",
                categoryImage = R.drawable.paper_waste
            ),
            RecycleCategoryItem(
                categoryName = "Glass",
                categoryImage = R.drawable.glass_waste
            ),
            RecycleCategoryItem(
                categoryName = "Electronics",
                categoryImage = R.drawable.electronic_waste

            ),
            RecycleCategoryItem(
                categoryName = "Organic Waste",
                categoryImage = R.drawable.organic_waste
            ),
            RecycleCategoryItem(
                categoryName = "Hazardous Waste",
                categoryImage = R.drawable.hazardous_waste
            ),
            RecycleCategoryItem(
                categoryName = "Textiles & Clothing",
                categoryImage = R.drawable.textile_waste
            )
        )
    }

}