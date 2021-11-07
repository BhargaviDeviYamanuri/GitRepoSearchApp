package com.sample.gitreposearchapp.util

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.model.SearchResultResponse
import java.io.IOException

fun getCountryCode(context: Context): List<Items> {

    lateinit var jsonString: String
    try {
        jsonString = context.assets.open("testData")
            .bufferedReader()
            .use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
    }
    val listCountryType = object : TypeToken<List<Items>>() {}.type
    return Gson().fromJson(jsonString, listCountryType)
}