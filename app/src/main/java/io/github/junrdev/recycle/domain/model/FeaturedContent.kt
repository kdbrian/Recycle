package io.github.junrdev.recycle.domain.model

import androidx.annotation.DrawableRes
import io.github.junrdev.recycle.R

data class FeaturedContent(
    val title: String,
    @DrawableRes val preview: Int,
    val category: String
) : BlogFeature() {

    companion object {

        fun getFeaturedContent() =
            listOf(
                FeaturedContent(
                    "Breathtaking Views of Mountain Peaks",
                    R.drawable.image_1,
                    "Nature"
                ),
                FeaturedContent(
                    "Revolutionary Advances in AI Technology",
                    R.drawable.image_2,
                    "Technology"
                ),
                FeaturedContent(
                    "Delicious Recipes from Around the World",
                    R.drawable.image_3,
                    "Food"
                ),
                FeaturedContent(
                    "Exploring Ancient Wonders and Landmarks",
                    R.drawable.image_4,
                    "History"
                ),
                FeaturedContent(
                    "Transformative Home Fitness Workouts",
                    R.drawable.image_5,
                    "Health"
                ),
                FeaturedContent("Masterpieces from Renowned Artists", R.drawable.image_6, "Art")
            )
    }

}