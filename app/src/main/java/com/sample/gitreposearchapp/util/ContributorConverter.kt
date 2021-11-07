package com.sample.gitreposearchapp.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sample.gitreposearchapp.model.Contributor

class ContributorConverter {
    @TypeConverter
    fun fromString(modelStr:String):Contributor{
        return Gson().fromJson(modelStr,Contributor::class.java)
    }

    @TypeConverter
    fun fromModel(contributor: Contributor):String{
        return Gson().toJson(contributor)
    }
}