package io.github.junrdev.recycler.ui.presentation.di

import com.google.ai.client.generativeai.GenerativeModel
import io.github.junrdev.recycler.BuildConfig
import io.github.junrdev.recycler.data.remote.repoimpl.GeminiRepoImpl
import io.github.junrdev.recycler.domain.remote.GeminiRepo
import org.koin.dsl.module


const val apiKey = BuildConfig.geminiApiKey

val generativeAiModule = module {

    single {
        GenerativeModel(
            modelName = "gemin-1.5-pro",
            apiKey = apiKey
        )
    }

    single<GeminiRepo> {
        GeminiRepoImpl(get())
    }

}