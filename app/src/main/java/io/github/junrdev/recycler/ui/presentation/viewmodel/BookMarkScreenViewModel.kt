package io.github.junrdev.recycler.ui.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.junrdev.recycler.domain.local.repo.BlogPostCacheRepository
import io.github.junrdev.recycler.domain.model.BlogPostItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class BookMarkScreenViewModel(private val cacheRepository: BlogPostCacheRepository) : ViewModel() {

    private val ioDispatcher = CoroutineScope(Dispatchers.IO)

    private val _cachedBlogs: MutableLiveData<List<BlogPostItem>> = MutableLiveData()
    val cachedBlogs: LiveData<List<BlogPostItem>>
        get() = _cachedBlogs


    init {
        viewModelScope.launch {
            _cachedBlogs.postValue(getBlogsFromCache())
        }
    }

    private suspend fun getBlogsFromCache(): List<BlogPostItem> {
        return ioDispatcher.async {
            cacheRepository.getBlogs()
        }.await()
    }

    suspend fun checkInCache(id: String) = ioDispatcher.async {
        cacheRepository.checkInCacheById(id)
    }.await()

    fun addToCache(blogPostItem: BlogPostItem) {
        ioDispatcher.launch {
            cacheRepository.addBlog(blogPostItem)
        }
    }

    fun deleteFromCache(blogPostItem: BlogPostItem) {
        ioDispatcher.launch {
            cacheRepository.deleteBlog(blogPostItem)
        }
    }

    fun clearBookmarks() {
        ioDispatcher.launch {
            cacheRepository.clearCache()
            viewModelScope.launch {
                _cachedBlogs.postValue(getBlogsFromCache())
            }
        }
    }

}