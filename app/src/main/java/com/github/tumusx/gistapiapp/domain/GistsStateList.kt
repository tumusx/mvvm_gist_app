package com.github.tumusx.gistapiapp.domain

import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem

data class GistsStateList(
    val error: String = "",
    var gists: List<GistsListDTOItem>? = emptyList()
)