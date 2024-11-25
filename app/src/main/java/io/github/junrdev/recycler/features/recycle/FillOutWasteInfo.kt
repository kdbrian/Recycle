package io.github.junrdev.recycler.features.recycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.junrdev.recycler.databinding.FragmentFillOutWasteInfoBinding


class FillOutWasteInfo : Fragment() {
    private lateinit var binding: FragmentFillOutWasteInfoBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFillOutWasteInfoBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {


        }
    }
}