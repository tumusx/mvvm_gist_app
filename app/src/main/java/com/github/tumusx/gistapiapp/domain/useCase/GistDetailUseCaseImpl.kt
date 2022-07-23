package com.github.tumusx.gistapiapp.domain.useCase

import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import com.github.tumusx.gistapiapp.utils.ResultAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GistDetailUseCaseImpl @Inject constructor(private val gistRepository: GistRepository) : GistDetailUseCase {
    override fun getDetailGist(idGist: String): Flow<ResultAPI<DetailGistDTO>> = flow{
        try {
            val resultDataDetail = gistRepository.getDetailGist(idGist)
            emit(ResultAPI.SuccessRequest<DetailGistDTO>(resultDataDetail))
        }catch (exception: Exception){
            emit(ResultAPI.FailureRequest<DetailGistDTO>(messageError = exception.message.toString()))
            exception.printStackTrace()
        }
    }
}