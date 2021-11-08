package com.sample.gitreposearchapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.network.SearchRepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRepoViewModel @Inject constructor(val repoRepository: SearchRepoRepository) :
    ViewModel() {
    var result = MutableLiveData<PagingData<Items>>()

    fun getSearchList(searchString: String) {
        viewModelScope.launch {
            result = repoRepository.getSearchResults(
                searchString,
                10,
                1
            ) as MutableLiveData<PagingData<Items>>
        }
    }
}