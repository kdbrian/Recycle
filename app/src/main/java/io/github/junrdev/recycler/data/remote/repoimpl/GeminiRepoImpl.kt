package io.github.junrdev.recycler.data.remote.repoimpl

import android.graphics.Bitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import io.github.junrdev.recycler.domain.remote.GeminiRepo

class GeminiRepoImpl(
    private val generativeModel: GenerativeModel
) : GeminiRepo {

    override suspend fun generateFromTextOnly(prompt: String): Result<String> {
        return try {
            val response = generativeModel.generateContent(prompt).text
            response?.let {
                Result.success(response)
            } ?: Result.failure(Exception("Failed due to $response"))
        } catch (e: Exception) {
            "Failed due to ${e.message}"
            Result.failure(e)
        }
    }

    override suspend fun generateFromTextAndImage(prompt: String, image: Bitmap): Result<String> {

        return try {
            val response = generativeModel.generateContent(
                content {
                    image(image)
                    text(prompt)
                }
            ).text

            response?.let {
                Result.success(response)
            } ?: Result.failure(Exception("Failed due to $response"))
        } catch (e: Exception) {
            "Failed due to ${e.message}"
            Result.failure(e)
        }

    }
}