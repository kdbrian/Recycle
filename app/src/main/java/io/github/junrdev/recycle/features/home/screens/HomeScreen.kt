package io.github.junrdev.recycle.features.home.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.databinding.HomeScreenBinding
import io.github.junrdev.recycle.features.home.adapter.HomePagerAdapter

class HomeScreen : Fragment() {

    var binding: HomeScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return HomeScreenBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {

            viewPager2.apply {
                adapter = HomePagerAdapter(requireActivity())
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        bottomNavigationView.menu.getItem(position).isChecked = true
                    }
                })
            }

            bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> viewPager2.currentItem = 0
                    R.id.blog -> viewPager2.currentItem = 1
                    R.id.recycle -> viewPager2.currentItem = 2
                    R.id.history -> viewPager2.currentItem = 3
                    R.id.account -> viewPager2.currentItem = 4
                    else -> false
                }
                true
            }


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}