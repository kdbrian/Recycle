package io.github.junrdev.recycler.features.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.junrdev.recycler.features.auth.onboarding.OnBoardingPagerAdapter
import io.github.junrdev.recycler.features.home.HomeSummary
import io.github.junrdev.recycler.features.recycle.RecycleOverview
import io.github.junrdev.recycler.features.recycle.ScanScreen

internal class HomePagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val screens = listOf(
        HomeSummary(),
        RecycleOverview()
//        ScanScreen()
    )

    override fun getItemCount(): Int = screens.size

    override fun createFragment(position: Int): Fragment = when (position < screens.size) {
        true -> screens[position]
        else -> throw IllegalArgumentException("Failed to parse screen on $position, for ${OnBoardingPagerAdapter::class.qualifiedName}")
    }

}