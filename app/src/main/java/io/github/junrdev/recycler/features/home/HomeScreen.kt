package io.github.junrdev.recycler.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentHomeScreenBinding
import io.github.junrdev.recycler.features.home.adapter.HomePagerAdapter

class HomeScreen : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentHomeScreenBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            viewPager22.adapter = HomePagerAdapter(requireNotNull(activity))

            viewPager22.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    bottomNavigationBar.menu.getItem(position).isChecked = true
                }
            })


            bottomNavigationBar.setOnItemSelectedListener {
                when (it.itemId) {

                    R.id.home -> {
                        viewPager22.setCurrentItem(0, true)
                        true
                    }

                    R.id.recycle -> {
                        viewPager22.setCurrentItem(1, true)
                        true
                    }

                    else -> false
                }

            }

        }
    }

}