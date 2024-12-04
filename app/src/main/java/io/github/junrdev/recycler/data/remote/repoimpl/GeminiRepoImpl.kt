package io.github.junrdev.recycler.data.remote.repoimpl

import android.graphics.Bitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import io.github.junrdev.recycler.domain.remote.GeminiRepo

class GeminiRepoImpl(
    private val generativeModel: GenerativeModel
) : GeminiRepo {

    override suspend fun generateFromTextOnly(prompt: String): String {
        return try {
            val response = generativeModel.generateContent(prompt).text
            response ?: "Something unexpected happened"
        } catch (e: Exception) {
            "Failed due to ${e.message}"
        }
    }

    override suspend fun generateFromTextAndImage(prompt: String, image: Bitmap): String {
        return try {
            val response = generativeModel.generateContent(
                content {
                    image(image)
                    text(prompt)
                }
            ).text

            response ?: "Something unexpected happened"
        } catch (e: Exception) {
            "Failed due to ${e.message}"
        }
    }
}