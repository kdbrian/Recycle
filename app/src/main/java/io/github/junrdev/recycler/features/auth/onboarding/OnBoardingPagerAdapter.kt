package io.github.junrdev.recycler.features.auth.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.junrdev.recycler.features.auth.onboarding.screens.FeaturesScreen
import io.github.junrdev.recycler.features.auth.onboarding.screens.GoalsScreen

class OnBoardingPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val screens = listOf(
        FeaturesScreen(),
        GoalsScreen()
    )

    override fun getItemCount(): Int = screens.size

    override fun createFragment(position: Int): Fragment = when (position < screens.size) {
        true -> screens[position]
        else -> throw IllegalArgumentException("Failed to parse screen on $position, for ${OnBoardingPagerAdapter::class.qualifiedName}")
    }
}