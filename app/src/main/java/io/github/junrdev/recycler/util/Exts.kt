package io.github.junrdev.recycler.util

import android.content.Context
import android.widget.Toast
import io.github.junrdev.recycler.domain.model.AppUser
import org.json.JSONObject

fun Context.toast(message : String = "Am a tea pot."){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

