package com.sample.gitreposearchapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.gitreposearchapp.model.Items

@Dao
interface RepoDAO {
    @Query("SELECT * FROM Items WHERE name =:queryStr")
    fun getSearchResult(queryStr:String):List<Items>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSearchResult(searchResult:List<Items>)
}