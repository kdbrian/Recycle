package io.github.junrdev.recycler.features.recycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentFillOutWasteInfoBinding
import io.github.junrdev.recycler.domain.model.WasteDto
import io.github.junrdev.recycler.util.toast


class FillOutWasteInfo : Fragment() {

    private lateinit var binding: FragmentFillOutWasteInfoBinding
    private lateinit var quantityType: String

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

            arguments?.getString("category")?.let { cat ->
                editTextText.apply {
                    setText(cat)
                    isEnabled = false
                }

            }

            quantitySpinner.adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.quantityType,
                android.R.layout.simple_spinner_item
            )

            quantitySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    quantityType = p0?.getItemAtPosition(p2).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

            button6.setOnClickListener {
                if (checkFields()) {
                    val wasteItem = WasteDto(
                        quantityUnit = quantityType,
                        quantity = editTextText2.text.toString().toDouble(),
                        category = editTextText.text.toString(),
                        contents = editTextTextMultiLine.text.toString()
                    )

                } else
                    requireContext().toast("Fill all fields.")
            }

        }
    }

    private fun FragmentFillOutWasteInfoBinding.checkFields(): Boolean {
        return editTextText.text.isNotEmpty() &&
                editTextText2.text.isNotEmpty() &&
                editTextTextMultiLine.text.isNotEmpty() &&
                quantityType != "-- select --"
    }
}