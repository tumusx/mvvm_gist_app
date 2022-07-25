package com.github.tumusx.gistapiapp.presenter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.gistapiapp.data.db.model.GistVODB
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.useCase.GistListUseCaseImpl
import com.github.tumusx.gistapiapp.utils.ResultAPI
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GistListViewModel @Inject constructor(
    private val listUseCase: GistListUseCaseImpl
) : ViewModel() {
    val getStats = MutableLiveData<List<GistsListDTOItem>>()
    val messageErrorRequest = MutableLiveData<String>()
    val isResultLoading = MutableLiveData<Boolean>()
    private var databaseFirebase: DatabaseReference = Firebase.database.reference.child("gists")

    init {
        configGistList()
    }

    private fun configGistList() {
        isResultLoading.postValue(true)
        listUseCase.getListGist().onEach { resultAPI ->
            when (resultAPI) {


                is ResultAPI.SuccessRequest -> {
                    getStats.postValue(resultAPI.dataResult)
                    isResultLoading.postValue(false)
                }

                is ResultAPI.FailureRequest -> {
                    isResultLoading.postValue(false)
                    messageErrorRequest.postValue(resultAPI.messageError.toString())
                }
            }
        }.launchIn(viewModelScope)
    }


    fun favoriteGistItem(gistItem: GistsListDTOItem) {
        try {
            val gistItems =
                gistItem.owner?.login?.let { GistVODB(it, gistItem.id, gistItem.createdAt) }
            databaseFirebase.child(gistItem.id).setValue(gistItems)
        } catch (exception: Exception) {
            exception.printStackTrace()
            messageErrorRequest.postValue(exception.message.toString())
        }
    }
}