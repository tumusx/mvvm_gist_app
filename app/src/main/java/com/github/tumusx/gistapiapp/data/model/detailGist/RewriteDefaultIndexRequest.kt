package com.github.tumusx.gistapiapp.data.model.detailGist

data class RewriteDefaultIndexRequest(
    val content: String,
    val filename: String,
    val language: Any,
    val raw_url: String,
    val size: Int,
    val truncated: Boolean,
    val type: String
)