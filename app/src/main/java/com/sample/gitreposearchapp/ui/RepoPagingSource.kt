package com.sample.gitreposearchapp.ui

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.network.APIService
import com.sample.gitreposearchapp.util.AppConstants.REPO_STARTING_PAGE_NUMBER
import retrofit2.HttpException
import java.io.IOException

class RepoPagingSource(val apiService: APIService, val searchStr: String) :
    PagingSource<Int, Items>() {
    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        return state.anchorPosition?.let {
            state.closestItemToPosition(it)?.id
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        val position = params.key ?: REPO_STARTING_PAGE_NUMBER
        return try {
            val response = apiService.getSearchResult(searchStr, params.loadSize,position)
            Log.e("data",response.items.toString())
            val items:List<Items> = response.items?:listOf()
            Log.e("data",items.toString())
            LoadResult.Page(
                data = items,
                prevKey = if (position == REPO_STARTING_PAGE_NUMBER) null else position - 1,
                nextKey = if (items.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            exception.printStackTrace()
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            exception.printStackTrace()
            LoadResult.Error(exception)
        }
    }
}