package com.github.tumusx.gistapiapp.data.local

import androidx.room.TypeConverter
import com.github.tumusx.gistapiapp.data.local.model.DetailGistVODB
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GistTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun gistToString(detailGistVODB: List<DetailGistVODB>) : String{
        return gson.toJson(detailGistVODB)
    }

    @TypeConverter
    fun stringToGist(detailGistVODB: String) : List<DetailGistVODB>{
        val objecType = object : TypeToken<List<DetailGistVODB>>() {}.type
        return gson.fromJson(detailGistVODB, objecType)
    }
}