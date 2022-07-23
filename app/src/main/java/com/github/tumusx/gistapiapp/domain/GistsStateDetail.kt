package com.github.tumusx.gistapiapp.domain

import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO

data class GistsStateDetail(
    val errorState: String = "",
    val dataDetail: GistDetailDTO? = null
)