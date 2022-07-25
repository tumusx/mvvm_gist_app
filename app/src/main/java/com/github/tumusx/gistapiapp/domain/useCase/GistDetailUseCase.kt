package com.github.tumusx.gistapiapp.domain.useCase

import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.utils.ResultAPI
import kotlinx.coroutines.flow.Flow

interface GistDetailUseCase {

    fun getDetailGist(idGist: String) : Flow<ResultAPI<DetailGistDTO>>

}