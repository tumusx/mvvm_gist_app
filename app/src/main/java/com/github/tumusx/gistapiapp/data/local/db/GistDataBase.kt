package com.github.tumusx.gistapiapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.tumusx.gistapiapp.data.local.GistTypeConverter
import com.github.tumusx.gistapiapp.data.local.dao.GistInfoDAO
import com.github.tumusx.gistapiapp.data.local.entity.GistInfoEntity

@Database(entities = [GistInfoEntity::class], version = 1, exportSchema = true)
@TypeConverters(GistTypeConverter::class)
abstract class GistDataBase : RoomDatabase(){
    abstract fun gistDAO() : GistInfoDAO
}