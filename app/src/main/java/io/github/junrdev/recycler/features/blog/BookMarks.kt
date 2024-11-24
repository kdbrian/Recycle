package io.github.junrdev.recycler.features.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.junrdev.recycler.databinding.FragmentBookMarksBinding


class BookMarks : Fragment(){

    private lateinit var binding : FragmentBookMarksBinding


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


        }
    }
}