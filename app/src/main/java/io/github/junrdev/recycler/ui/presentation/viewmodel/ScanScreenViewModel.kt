package io.github.junrdev.recycler.ui.presentation.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import io.github.junrdev.recycler.domain.model.WasteData
import io.github.junrdev.recycler.domain.remote.GeminiRepo
import io.github.junrdev.recycler.util.Constants


private const val TAG = "ScanScreenViewModel"

class ScanScreenViewModel(
    private val geminiRepo: GeminiRepo
) : ViewModel() {


    suspend fun generateContentFromImage(image: Bitmap): WasteData {
        val response = geminiRepo.generateFromTextAndImage(Constants.IMAGE_PROMPT, image)
        val decoded =
        return response
    }


    suspend fun generateTextContent(prompt : String) {
        val response = geminiRepo.generateFromTextOnly()
    }

}