package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.databinding.FragmentLastedGistBinding
import com.github.tumusx.gistapiapp.domain.GistsStateList
import com.github.tumusx.gistapiapp.presenter.view.adapter.GistListAdapter
import com.github.tumusx.gistapiapp.presenter.viewModel.GistListViewModel
import com.github.tumusx.gistapiapp.utils.ConstUtils
import com.github.tumusx.gistapiapp.utils.ResultAPI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GistListFragment : Fragment() {
    private lateinit var binding: FragmentLastedGistBinding
    private lateinit var gistsListAdapter: RecyclerView.Adapter<*>
    private lateinit var gistsViewModel: GistListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLastedGistBinding.inflate(layoutInflater)
        gistsViewModel = ViewModelProvider(this)[GistListViewModel::class.java]
        getListGists()
        gistsViewModel.getStats.observe(viewLifecycleOwner, this::configUpdateListAdapter)
        return binding.root
    }

    private fun configAdapter() {
        gistsListAdapter = GistListAdapter{myItemClick->
            Log.d("ID", myItemClick)
            GistDetailFragment(myItemClick).show(childFragmentManager, ConstUtils.GISTDETAILFRAGMENT)
        }
        binding.rvLastedGist.adapter = gistsListAdapter
    }

    private fun configUpdateListAdapter(gistItems: List<GistsListDTOItem>) {
            (gistsListAdapter as GistListAdapter).updateGistList(gistItems.distinctBy { it.owner.id })
        }

    private fun getListGists() {
        gistsViewModel.configGistList()
        configAdapter()
    }
}
