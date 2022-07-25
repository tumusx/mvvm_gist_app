package com.github.tumusx.gistapiapp.presenter.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.tumusx.gistapiapp.data.db.model.GistVODB
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class GistFavoriteViewModel : ViewModel(){
    val removeFavoriteItem = MutableLiveData<GistVODB>()
    val readFavoriteItem = MutableLiveData<GistVODB>()
    private var databaseFirebase: DatabaseReference = Firebase.database.reference.child("gists")

    fun readFavoriteItem(){
        databaseFirebase.get().addOnSuccessListener {
            Log.e("db result", readFavoriteItem.value.toString())
        }.addOnFailureListener {
            Log.e("error", it.message.toString())
        }
    }

}