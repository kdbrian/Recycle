package io.github.junrdev.recycler.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.util.UUID


@Entity
@Parcelize
open class BlogPostItem(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    val topic: String = "",
    val content: String = "",
    val imageLink: String = "https://firebasestorage.googleapis.com/v0/b/apptales-6c0f3.appspot.com/o/draft%2Fpolution.jpg?alt=media&token=9834dc39-9123-4c47-a8f7-957c157e5b53",
    val author: String = "",
    val datePublished: String = LocalDateTime.now().toString(),
) : Parcelable

