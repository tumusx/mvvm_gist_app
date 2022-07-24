package com.github.tumusx.gistapiapp.data.model.detailGist

import com.github.tumusx.gistapiapp.domain.model.detailGist.GistDetailVO
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//mapeamento para receber o que vem do servico//

data class GistDetailDTO(
    @SerializedName ("comments")
    val comments: Int,

    @SerializedName ("comments_url")
    val commentsUrl: String,

    @SerializedName ("commits_url")
    val commitsUrl: String,

    @SerializedName ("created_at")
    val createdAt: String,

    @SerializedName ("description")
    val description: String,

    @SerializedName ("forks_url")
    val forksUrl: String,

    @SerializedName ("git_pull_url")
    val gitPullUrl: String,

    @SerializedName ("git_push_url")
    val gitPushUrl: String,

    @SerializedName ("html_url")
    val htmlUrl: String,

    @SerializedName ("id")
    val id: String,

    @SerializedName ("node_id")
    val nodeId: String,

    @SerializedName ("updated_at")
    val updatedAt: String,

    @SerializedName ("url")
    val url: String
)