package io.github.junrdev.recycler.features.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentAllBlogsScreenBinding


class AllBlogsScreen : Fragment() {


    private lateinit var binding: FragmentAllBlogsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentAllBlogsScreenBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            imageView16.setOnClickListener {
                findNavController().popBackStack()
            }

            imageView15.setOnClickListener {
                findNavController().navigate(R.id.action_allBlogsScreen_to_bookMarks)
            }


            blogList.adapter = BlogPostRecyclerAdapter(
                context = requireContext(),
                layout = R.layout.horizontal_blogpost_item
            )

        }
    }
}