package io.github.junrdev.recycler.features.auth.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentOnBoardingScreenBinding

class OnBoardingScreen : Fragment() {

    private lateinit var binding: FragmentOnBoardingScreenBinding
    private val auth = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentOnBoardingScreenBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            if (auth.currentUser != null)
                findNavController().navigate(R.id.action_onBoardingScreen_to_homeScreen)

            viewPager2.adapter = OnBoardingPagerAdapter(requireActivity())

            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == 1)
                        buttonText.text = "Get started"
                    else if (position == 0)
                        buttonText.text = "Continue.."
                }
            })

            button2.setOnClickListener {
                if (viewPager2.currentItem == 0)
                    viewPager2.setCurrentItem(1, true)
                else
                    findNavController().navigate(R.id.action_onBoardingScreen_to_promptAuthScreen)
            }

        }
    }

}