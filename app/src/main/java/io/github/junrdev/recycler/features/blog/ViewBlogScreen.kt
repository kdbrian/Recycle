package io.github.junrdev.recycler.features.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import io.github.junrdev.recycler.databinding.FragmentViewBlogScreenBinding
import io.github.junrdev.recycler.domain.model.BlogPostItem


class ViewBlogScreen : Fragment(){

    private lateinit var binding : FragmentViewBlogScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentViewBlogScreenBinding.inflate(inflater, container, false)
            .also { binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            arguments?.getSerializable("blog")

            Glide.with(requireContext())
                .load()

        }
    }
}