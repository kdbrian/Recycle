package io.github.junrdev.recycler.domain.remote

import android.graphics.Bitmap
import android.net.Uri

interface GeminiRepo {
    suspend fun generateFromTextOnly(prompt: String) : Result<String>
    suspend fun generateFromTextAndImage(prompt: String, image: Bitmap) : Result<String>
}