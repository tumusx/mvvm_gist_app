package com.github.tumusx.gistapiapp.domain.useCase

import com.github.tumusx.gistapiapp.domain.model.listGist.GistListVO
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import com.github.tumusx.gistapiapp.utils.ResultAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GistListUseCaseImpl @Inject constructor(private val gistRepository: GistRepository) : GistListUseCase{
    override fun getListGist(): Flow<ResultAPI<List<GistListVO>>> = flow {
        try {
            val listGistVO = gistRepository.getListGists().map { GistListVO(it.owner.login, it.owner.avatar_url) }
            emit(ResultAPI.SuccessRequest<List<GistListVO>>(listGistVO))
        }catch (exception: Exception){
            emit(ResultAPI.FailureRequest<List<GistListVO>>(messageError = exception.message))
        }
    }
}