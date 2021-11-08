package com.sample.gitreposearchapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.gitreposearchapp.databinding.RepoItemLayoutBinding
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.ui.HomeFragmentDirections

class SearchResultAdapter :
    PagingDataAdapter<Items, SearchResultAdapter.RepoViewHolder>(REPO_COMPARATOR) {
    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }

        }
    }

    class RepoViewHolder(private val binding: RepoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun showItem(items: Items) {
            binding.searchResult = items
            binding.root.setOnClickListener {
                it.findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToRepoDetailsFragment(items))
            }
        }
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        getItem(position)?.let { holder.showItem(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val repoItemLayoutBinding: RepoItemLayoutBinding =
            RepoItemLayoutBinding.inflate(layoutInflater, parent, false)
        return RepoViewHolder(repoItemLayoutBinding)
    }

}