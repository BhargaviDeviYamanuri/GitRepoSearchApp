package com.sample.gitreposearchapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.gitreposearchapp.model.Contributor
import com.sample.gitreposearchapp.model.ContributorResponse
import com.sample.gitreposearchapp.network.SearchRepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RepoDetailsVIewModel @Inject constructor(val repoRepository: SearchRepoRepository):ViewModel() {
    var contributeData:LiveData<ContributorResponse> = MutableLiveData()
    fun getContributeDetails(path:String){
        viewModelScope.launch {
            contributeData = repoRepository.getContributorDetails(path)
        }
    }
}