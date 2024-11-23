package io.github.junrdev.recycle.features.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.junrdev.recycle.features.home.screens.AccountOverview
import io.github.junrdev.recycle.features.home.screens.BlogScreenContent
import io.github.junrdev.recycle.features.home.screens.HomeScreenContent
import io.github.junrdev.recycle.features.home.screens.MyTimeLine
import io.github.junrdev.recycle.features.home.screens.RecyclerContent

class HomePagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val screens = listOf(
        HomeScreenContent(),
        BlogScreenContent(),
        RecyclerContent(),
        MyTimeLine(),
        AccountOverview()
    )

    override fun getItemCount(): Int = screens.size

    override fun createFragment(position: Int): Fragment {
        return when (position < itemCount) {
            true -> screens[position]
            else -> throw IllegalArgumentException("No screen passed for $position at ${HomePagerAdapter::class.simpleName}")
        }
    }


}