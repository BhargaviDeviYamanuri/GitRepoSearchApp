package com.sample.gitreposearchapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.gitreposearchapp.R
import com.sample.gitreposearchapp.adapter.ContributorsAdapter
import com.sample.gitreposearchapp.databinding.FragmentRepoDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_repo_details.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class RepoDetailsFragment : Fragment() {
    val args: RepoDetailsFragmentArgs by navArgs()
    val repoDetailsVIewModel by viewModels<RepoDetailsVIewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentRepoDetailsBinding: FragmentRepoDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_repo_details, container, false)
        repoDetailsVIewModel.getContributeDetails(args.repoDetails.contents_url)
        repoDetailsVIewModel.contributeData.observe(viewLifecycleOwner, {
            fragmentRepoDetailsBinding.repoDetails = args.repoDetails
            if (it.contributors.isNotEmpty()) {
                rvContributors.visibility = View.VISIBLE
                tvContribute.visibility = View.GONE
                rvContributors.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                rvContributors.adapter = ContributorsAdapter(it.contributors)
            } else {
                rvContributors.visibility = View.GONE
                tvContribute.visibility = View.VISIBLE
            }
        })
        return fragmentRepoDetailsBinding.root
    }

}