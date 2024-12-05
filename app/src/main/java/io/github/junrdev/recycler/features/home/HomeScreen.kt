package io.github.junrdev.recycler.features.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentHomeScreenBinding
import io.github.junrdev.recycler.domain.model.AppUser
import io.github.junrdev.recycler.features.blog.BlogPostRecyclerAdapter
import io.github.junrdev.recycler.features.home.adapter.HomePagerAdapter
import io.github.junrdev.recycler.util.Constants
import kotlinx.serialization.json.Json

class HomeScreen : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding
    private lateinit var backDispatcher: OnBackPressedCallback
    private val auth = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        backDispatcher = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (auth.currentUser != null)
                    requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backDispatcher)

        return FragmentHomeScreenBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            val info = requireContext().getSharedPreferences(Constants.appPrefs, Context.MODE_PRIVATE)
                .getString(Constants.userInfo, null)
            info?.let {
                val userInfo = Json.decodeFromString<AppUser>(it)
                user = userInfo
            }

            homeBlogsPreview.adapter = BlogPostRecyclerAdapter(
                context = requireContext(),
                layout = R.layout.blogpost_item
            ){
                findNavController().navigate(R.id.action_homeScreen_to_viewBlogScreen, bundleOf("blog" to  it))
            }

            textView19.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_homeScreen_to_allBlogsScreen)
            }

        }
    }

}