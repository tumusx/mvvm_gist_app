package com.github.tumusx.gistapiapp.data.model.listGist

import com.bumptech.glide.signature.ObjectKey
import com.google.gson.annotations.SerializedName

data class GistsListDTOItem(

    @SerializedName("comments")
    val comments: Int,

    @SerializedName ("comments_url")
    val commentsUrl: String,

    @SerializedName ("commits_url")
    val commitsUrl: String,

    @SerializedName ("created_at")
    val createdAt: String,

    @SerializedName ("description")
    val description: String,

    @SerializedName ("files")
    val files: Map<String, Files>?,

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

    @SerializedName ("owner")
    val owner: Owner,

    @SerializedName ("public")
    val public: Boolean,

    @SerializedName ("truncated")
    val truncated: Boolean,

    @SerializedName ("updated_at")
    val updatedAt: String,

    @SerializedName ("url")
    val url: String,

    @SerializedName ("user")
    val user: Any
)