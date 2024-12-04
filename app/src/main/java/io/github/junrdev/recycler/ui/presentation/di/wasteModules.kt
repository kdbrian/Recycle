package io.github.junrdev.recycler.ui.presentation.di

import io.github.junrdev.recycler.data.remote.repoimpl.WasteRepoImpl
import io.github.junrdev.recycler.domain.remote.GeminiRepo
import io.github.junrdev.recycler.domain.remote.WasteRepo
import io.github.junrdev.recycler.ui.presentation.viewmodel.ScanScreenViewModel
import io.github.junrdev.recycler.ui.presentation.viewmodel.WasteInfoViewModel
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val wasteModules = module {

    single<WasteRepo> {
        WasteRepoImpl()
    }

    viewModel {
        WasteInfoViewModel(get())
    }

    viewModel {
        ScanScreenViewModel(
            get<GeminiRepo>(),
            get<Json>()
        )
    }
}