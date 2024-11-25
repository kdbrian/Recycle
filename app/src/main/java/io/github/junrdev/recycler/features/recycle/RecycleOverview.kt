package io.github.junrdev.recycler.features.recycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentRecycleOverviewBinding
import io.github.junrdev.recycler.domain.model.WasteCategory
import io.github.junrdev.recycler.features.recycle.adapter.WasteCategoriesAdapter


class RecycleOverview : Fragment() {

    private lateinit var binding: FragmentRecycleOverviewBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentRecycleOverviewBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            openScanner.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_homeScreen_to_scanScreen)
            }


            wasteCategories.adapter = WasteCategoriesAdapter(
                context = requireContext(),
                wasteCategories = WasteCategory.getCategories()
            )

        }
    }

}
