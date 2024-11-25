package io.github.junrdev.recycler.features.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentBookMarksBinding
import io.github.junrdev.recycler.ui.presentation.viewmodel.BookMarkScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class BookMarks : Fragment(){

    private lateinit var binding : FragmentBookMarksBinding
    private val bookMarkScreenViewModel by viewModel<BookMarkScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentBookMarksBinding.inflate(inflater, container, false)
            .also {
                binding=it
            }.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            bookMarkScreenViewModel.cachedBlogs.observe(viewLifecycleOwner) {
                it?.let { blogs ->
                    recyclerView.adapter = BlogPostRecyclerAdapter(
                        context = requireContext(),
                        layout = R.layout.horizontal_blogpost_item,
                        blogs = blogs
                    ) {
                        findNavController().navigate(
                            R.id.action_bookMarks_to_viewBlogScreen,
                            bundleOf("blog" to it)
                        )
                    }

                }
            }


            imageView18.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    bookMarkScreenViewModel.clearBookmarks()
                }
            }
        }
    }
}