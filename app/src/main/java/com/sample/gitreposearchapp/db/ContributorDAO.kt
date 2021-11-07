package com.sample.gitreposearchapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.gitreposearchapp.model.LocalContributor

@Dao
interface ContributorDAO {

    @Query("SELECT * FROM LocalContributor WHERE contributorUrl=:contributorUrl")
    fun getContributorDetails(contributorUrl:String):LocalContributor

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun saveContributorDetails(localContributor: LocalContributor)
}