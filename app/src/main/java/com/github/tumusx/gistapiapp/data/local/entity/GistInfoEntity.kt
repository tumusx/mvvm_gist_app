package com.github.tumusx.gistapiapp.data.local.entity

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.tumusx.gistapiapp.data.local.model.DetailGistVODB
import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem

@Entity(tableName = "gist_table")
data class GistInfoEntity(
    @ColumnInfo (name = "gists_favorite" ) val gistsFavorite: List<DetailGistVODB>,
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
