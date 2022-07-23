package com.github.tumusx.gistapiapp.domain.useCase

import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import com.github.tumusx.gistapiapp.utils.ResultAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GistDetailUseCaseImpl @Inject constructor(private val gistRepository: GistRepository) : GistDetailUseCase {
    override fun getDetailGist(idGist: String): Flow<ResultAPI<GistDetailDTO>> = flow{
        try {
            val resultDataDetail = gistRepository.getDetailGist(idGist)
            emit(ResultAPI.SuccessRequest<GistDetailDTO>(resultDataDetail))
        }catch (exception: Exception){
            emit(ResultAPI.FailureRequest<GistDetailDTO>(messageError = exception.message.toString()))
            exception.printStackTrace()
        }
    }
}