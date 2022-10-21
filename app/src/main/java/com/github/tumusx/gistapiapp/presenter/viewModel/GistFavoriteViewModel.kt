package com.github.tumusx.gistapiapp.presenter.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.tumusx.gistapiapp.data.db.model.GistVODB

class GistFavoriteViewModel : ViewModel(){
    val removeFavoriteItem = MutableLiveData<GistVODB>()
    val readFavoriteItem = MutableLiveData<GistVODB>()

    fun readFavoriteItem(){

    }

}