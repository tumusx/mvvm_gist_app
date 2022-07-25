package com.github.tumusx.gistapiapp.data.db.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class GistVODB(
    val userGists: String,
    val idUserGists: String,
    val creatAt: String
)