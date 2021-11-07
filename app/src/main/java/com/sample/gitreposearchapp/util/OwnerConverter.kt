package com.sample.gitreposearchapp.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sample.gitreposearchapp.model.Owner

class OwnerConverter {
    @TypeConverter
    fun fromString(modelStr:String): Owner {
        return Gson().fromJson(modelStr, Owner::class.java)
    }

    @TypeConverter
    fun fromModel(owner: Owner):String{
        return Gson().toJson(owner)
    }
}