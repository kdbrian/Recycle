package io.github.junrdev.recycler.features.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentViewBlogScreenBinding
import io.github.junrdev.recycler.domain.model.BlogPostItem
import io.github.junrdev.recycler.ui.presentation.viewmodel.BookMarkScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewBlogScreen : Fragment(){

    private lateinit var binding : FragmentViewBlogScreenBinding
    private val bookMarkScreenViewModel by viewModel<BookMarkScreenViewModel>()
    private var isCached: MutableLiveData<Boolean> = MutableLiveData(false)

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


            imageView3.setOnClickListener {
                findNavController().popBackStack()
            }

            arguments?.getParcelable<BlogPostItem>("blog")?.let { blogpost ->
                blog = blogpost
                Glide.with(requireContext())
                    .load(blogpost.imageLink)
                    .into(imageView10)

                imageView4.setImageDrawable(
                    if (isCached.value!!) {
                        ContextCompat.getDrawable(requireContext(), R.drawable.round_bookmark_24)
                    } else {
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.round_bookmark_border_24
                        )
                    }

                )

                CoroutineScope(Dispatchers.Main).launch {
                    val checkInCache = bookMarkScreenViewModel.checkInCache(blogpost.id)
                    println(
                        "iscached $checkInCache"
                    )
                    isCached.value = checkInCache
                }

                imageView4.setOnClickListener {
                    CoroutineScope(Dispatchers.Main).launch {
                        when (isCached.value) {
                            true -> {
                                //remove from cache
                                isCached.value = true
                                bookMarkScreenViewModel.deleteFromCache(blogpost)
                            }

                            else -> {
                                //add to cache
                                isCached.value = true
                                bookMarkScreenViewModel.addToCache(blogpost)
                            }
                        }
                    }
                }
            }

        }
    }
}