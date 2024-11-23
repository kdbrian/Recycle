package io.github.junrdev.recycle.domain.model

import java.util.UUID

open class BlogFeature {
    val id : String = UUID.randomUUID().toString()
}