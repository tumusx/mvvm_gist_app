package com.github.tumusx.gistapiapp.data.db

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class GistVODB(
    val userGists: String,
    val idUserGists: String,
    val creatAt: String
)