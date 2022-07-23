package com.github.tumusx.gistapiapp.data.local.dao

import androidx.room.*
import com.github.tumusx.gistapiapp.data.local.entity.GistInfoEntity

@Dao
interface GistInfoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGistsFavorites(gists: List<GistInfoEntity>)

    @Query("DELETE FROM gistinfoentity WHERE idGist IN(:gist)")
    suspend fun deleteGists(gist: GistInfoEntity)

    @Query("SELECT * FROM gistinfoentity WHERE idGist LIKE '%' || :gist || '%'")
    suspend fun getGistsInfo(gist: GistInfoEntity) : List<GistInfoEntity>
}