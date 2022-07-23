package com.github.tumusx.gistapiapp.presenter.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.GistsStateList
import com.github.tumusx.gistapiapp.domain.useCase.GistListUseCaseImpl
import com.github.tumusx.gistapiapp.utils.ResultAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GistListViewModel @Inject constructor(private val listUseCase: GistListUseCaseImpl) :
    ViewModel() {
    private val _listGist = MutableStateFlow(GistsStateList())
    val getStats = MutableLiveData<List<GistsListDTOItem>>()
    init {
        configGistList()
    }

    fun configGistList() {
        listUseCase.getListGist().onEach { resultAPI ->
            when (resultAPI) {

                is ResultAPI.SuccessRequest -> {
                    _listGist.value.gists = resultAPI.dataResult
                    getStats.postValue(resultAPI.dataResult)
                    Log.d("ok", resultAPI.dataResult.toString())
                }

                is ResultAPI.FailureRequest -> {
                    Log.d("ERROR", resultAPI.messageError.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}