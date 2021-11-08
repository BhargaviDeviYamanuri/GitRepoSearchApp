package com.sample.gitreposearchapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.gitreposearchapp.databinding.ItemContributorsLayoutBinding
import com.sample.gitreposearchapp.model.Contributor

class ContributorsAdapter(private val result: List<Contributor>) :
    RecyclerView.Adapter<ContributorsAdapter.ContributorsViewHolder>() {
    class ContributorsViewHolder(val bindingImpl: ItemContributorsLayoutBinding) :
        RecyclerView.ViewHolder(bindingImpl.root) {
        fun showItem(items: Contributor) {
            bindingImpl.contributor = items

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemContributorsLayoutBinding: ItemContributorsLayoutBinding =
            ItemContributorsLayoutBinding.inflate(layoutInflater, parent, false)
        return ContributorsViewHolder(itemContributorsLayoutBinding)
    }

    override fun onBindViewHolder(holder: ContributorsViewHolder, position: Int) {
        holder.showItem(result[position])
    }

    override fun getItemCount(): Int = result.size

}