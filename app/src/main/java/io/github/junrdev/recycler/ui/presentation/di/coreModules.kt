package io.github.junrdev.recycler.ui.presentation.di

import kotlinx.serialization.json.Json
import org.koin.dsl.module

val coreModules = module {
    single {
        Json { ignoreUnknownKeys = true }
    }
}