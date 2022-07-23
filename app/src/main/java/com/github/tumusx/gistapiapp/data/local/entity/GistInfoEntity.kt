package com.github.tumusx.gistapiapp.data.local.entity

import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GistInfoEntity(
    @PrimaryKey val idGist: String,
    val nameUserGist: String,
    val fileUser: Drawable,
)
