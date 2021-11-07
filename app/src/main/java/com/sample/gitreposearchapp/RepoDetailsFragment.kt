package com.sample.gitreposearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sample.gitreposearchapp.databinding.FragmentRepoDetailsBinding
import com.sample.gitreposearchapp.databinding.FragmentRepoDetailsBindingImpl
import com.sample.gitreposearchapp.databinding.RepoItemLayoutBinding
import com.sample.gitreposearchapp.databinding.RepoItemLayoutBindingImpl
import com.sample.gitreposearchapp.model.Items

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RepoDetailsFragment : Fragment() {
    val args:RepoDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val repoItemLayoutBinding: FragmentRepoDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_repo_details, container, false)
        repoItemLayoutBinding.repoDetails = args.repoDetails
        return repoItemLayoutBinding.root
    }

}