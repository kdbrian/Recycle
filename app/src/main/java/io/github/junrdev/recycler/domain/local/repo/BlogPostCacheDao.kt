package io.github.junrdev.recycler.domain.local.repo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.junrdev.recycler.domain.model.BlogPostItem

@Dao
interface BlogPostCacheDao {

    @Query("SELECT * FROM blogpostitem")
    suspend fun getBlogs(): List<BlogPostItem>

    @Insert
    suspend fun addBlog(blogPostItem: BlogPostItem)

    @Delete
    suspend fun deleteBlog(blogPostItem: BlogPostItem)

    @Query("DELETE FROM blogpostitem")
    suspend fun clearCache()

}

interface BlogPostCacheRepository {

    suspend fun getBlogs(): List<BlogPostItem>

    suspend fun addBlog(blogPostItem: BlogPostItem)

    suspend fun deleteBlog(blogPostItem: BlogPostItem)

    suspend fun clearCache()

}