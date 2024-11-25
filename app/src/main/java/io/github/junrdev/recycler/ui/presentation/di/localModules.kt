package io.github.junrdev.recycler.ui.presentation.di

import io.github.junrdev.recycler.data.local.BlogPostDB
import io.github.junrdev.recycler.domain.local.repo.BlogPostCacheDao
import io.github.junrdev.recycler.domain.local.repo.BlogPostCacheRepository
import io.github.junrdev.recycler.domain.local.repo.BlogPostRepositoryImpl
import io.github.junrdev.recycler.ui.presentation.viewmodel.BookMarkScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val localModules = module {

    single<BlogPostDB> {
        BlogPostDB.getDB(get())
    }

    single<BlogPostCacheDao> {
        get<BlogPostDB>().blogPostCacheDao()
    }


    single<BlogPostCacheRepository> {
        BlogPostRepositoryImpl(get<BlogPostCacheDao>())
    }


    viewModel<BookMarkScreenViewModel> {
        BookMarkScreenViewModel(
            get<BlogPostCacheRepository>()
        )
    }

}
