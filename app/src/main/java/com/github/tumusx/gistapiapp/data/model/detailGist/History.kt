package com.github.tumusx.gistapiapp.data.model.detailGist

data class History(
    val change_status: ChangeStatus,
    val committed_at: String,
    val url: String,
    val user: User,
    val version: String
)