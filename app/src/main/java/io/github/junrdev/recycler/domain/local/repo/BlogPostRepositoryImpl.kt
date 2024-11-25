package io.github.junrdev.recycler.domain.local.repo

import io.github.junrdev.recycler.domain.model.BlogPostItem


class BlogPostRepositoryImpl(
    private val cacheRepoDao: BlogPostCacheDao
) : BlogPostCacheRepository {


    override suspend fun checkInCacheById(blogPostItemId: String): Boolean {
        val item = cacheRepoDao.getFromCacheById(blogPostItemId)
        println(
            "item $item"
        )
        return item != null
    }

    override suspend fun getBlogs(): List<BlogPostItem> =
        cacheRepoDao.getBlogs()

    override suspend fun addBlog(blogPostItem: BlogPostItem) {
        cacheRepoDao.addBlog(blogPostItem)
    }

    override suspend fun deleteBlog(blogPostItem: BlogPostItem) {
        cacheRepoDao.deleteBlog(blogPostItem)
    }

    override suspend fun clearCache() {
        cacheRepoDao.clearCache()
    }


}