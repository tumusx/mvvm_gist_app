package com.github.tumusx.gistapiapp.data.model.listGist

data class Files(
    val filename: String?,
    val language: String,
    val raw_url: String,
    val size: Int,
    val type: String
)