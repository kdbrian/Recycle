package io.github.junrdev.recycler.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.junrdev.recycler.domain.local.repo.BlogPostCacheDao
import io.github.junrdev.recycler.domain.model.BlogPostItem

@Database(
    version = 1,
    exportSchema = false,
    entities = [BlogPostItem::class]
)
abstract class BlogPostDB : RoomDatabase() {

    abstract fun blogPostCacheDao() : BlogPostCacheDao

    companion object {

        @Volatile
        private var DB_INSTANCE: BlogPostDB? = null

        fun getDB(context: Context): BlogPostDB {
            return DB_INSTANCE ?: synchronized(this) {
                buildDatabase(context).also {
                    DB_INSTANCE = it
                    DB_INSTANCE!!
                }
            }
        }

        private fun buildDatabase(context: Context): BlogPostDB {
            return Room.databaseBuilder(
                context,
                BlogPostDB::class.java,
                "blogpost_db"
            )
                /*add migrations*/
                .build()
        }


    }

}