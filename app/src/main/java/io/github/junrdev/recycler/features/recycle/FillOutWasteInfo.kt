package io.github.junrdev.recycler.features.recycle

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.FragmentFillOutWasteInfoBinding
import io.github.junrdev.recycler.domain.model.AppUser
import io.github.junrdev.recycler.domain.model.WasteData
import io.github.junrdev.recycler.domain.model.WasteDto
import io.github.junrdev.recycler.ui.presentation.viewmodel.WasteInfoViewModel
import io.github.junrdev.recycler.util.Constants
import io.github.junrdev.recycler.util.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.ext.android.viewModel


class FillOutWasteInfo : Fragment() {

    private lateinit var binding: FragmentFillOutWasteInfoBinding
    private lateinit var quantityType: String
    private val wasteInfoViewModel by viewModel<WasteInfoViewModel>()

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

            button6.setOnClickListener {
                if (checkFields()) {

                    val wasteItem = WasteDto(
                        category = editTextText.text.toString(),
                        wasteData = WasteData(
                            quantity = editTextText2.text.toString(),
                            contents = listOf(editTextTextMultiLine.text.toString()),
                            majorContent = editTextText.text.toString(),
                        )
                    )

                    CoroutineScope(Dispatchers.Main).launch {

                        requireContext().run {

                            val userInfo = Json.decodeFromString<AppUser>(
                                getSharedPreferences(Constants.appPrefs, Context.MODE_PRIVATE)
                                    .getString(Constants.userInfo, null).orEmpty()
                            )

                            val result = wasteInfoViewModel.addToDb(
                                recyclerId = userInfo.recyclerId,
                                wasteItem
                            )

                            result.onFailure {
                                toast(it.message.toString())
                            }

                            result.onSuccess {
                                toast("Saved record")
                                findNavController().popBackStack()
                            }
                        }
                    }

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