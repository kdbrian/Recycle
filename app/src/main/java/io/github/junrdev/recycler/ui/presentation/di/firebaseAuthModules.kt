package io.github.junrdev.recycler.ui.presentation.di

import io.github.junrdev.recycler.data.remote.repoimpl.FirebaseUserRepoImpl
import io.github.junrdev.recycler.domain.remote.FirebaseUserRepo
import io.github.junrdev.recycler.ui.presentation.viewmodel.AuthScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val firebaseAuthModules  = module {

    single<FirebaseUserRepo> {
        FirebaseUserRepoImpl()
    }

    viewModel<AuthScreenViewModel> {
        AuthScreenViewModel(get<FirebaseUserRepo>())
    }
}