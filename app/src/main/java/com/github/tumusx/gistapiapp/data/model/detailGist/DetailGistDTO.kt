package com.github.tumusx.gistapiapp.data.model.detailGist

import com.github.tumusx.gistapiapp.data.model.listGist.Files
import java.io.Serializable

data class DetailGistDTO(
    val comments: Int,
    val comments_url: String,
    val commits_url: String,
    val created_at: String,
    val description: String,
    val files: Map<String, Files>,
    val forks: List<Any>,
    val forks_url: String,
    val git_pull_url: String,
    val git_push_url: String,
    val history: List<History>,
    val html_url: String,
    val id: String,
    val node_id: String,
    val owner: Owner,
    val `public`: Boolean,
    val truncated: Boolean,
    val updated_at: String,
    val url: String,
    val user: Any
) : Serializable{

    fun typeRawFileURL() : String {
        var typeFileGistUser: String? = null
        for (mapFiles in files.entries) {
            typeFileGistUser = mapFiles.value.raw_url
        }
        return typeFileGistUser.toString()
    }

    fun typeFile() : String {
        var typeFileGistUser: String? = null
        for (mapFiles in files.entries) {
            typeFileGistUser = mapFiles.value.type
        }
        return typeFileGistUser.toString()
    }
}