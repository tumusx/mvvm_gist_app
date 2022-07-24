package com.github.tumusx.gistapiapp.data.local.dao

import androidx.room.*
import com.github.tumusx.gistapiapp.data.local.entity.GistInfoEntity

@Dao
interface GistInfoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGistsFavorites(gists: GistInfoEntity)

}