package io.github.junrdev.recycler.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentHomeSummaryBinding
import io.github.junrdev.recycler.features.blog.BlogPostRecyclerAdapter

class HomeSummary : Fragment() {

    private lateinit var binding: FragmentHomeSummaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentHomeSummaryBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            homeBlogsPreview.adapter = BlogPostRecyclerAdapter(
                context = requireContext(),
                layout = R.layout.blogpost_item
            )

            textView19.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_homeScreen_to_allBlogsScreen)
            }

        }
    }

}