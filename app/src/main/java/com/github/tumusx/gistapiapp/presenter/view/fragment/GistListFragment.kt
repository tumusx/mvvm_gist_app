package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.gistapiapp.data.local.entity.GistInfoEntity
import com.github.tumusx.gistapiapp.data.local.model.DetailGistVODB
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.databinding.FragmentLastedGistBinding
import com.github.tumusx.gistapiapp.presenter.view.adapter.GistListAdapter
import com.github.tumusx.gistapiapp.presenter.viewModel.GistListViewModel
import com.github.tumusx.gistapiapp.utils.ConstUtils
import dagger.hilt.android.AndroidEntryPoint

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
        gistsListAdapter = GistListAdapter{gistItemSelect->
            configSaveItemGist(gistItemSelect)
            GistDetailFragment(gistItemSelect.id).show(childFragmentManager, ConstUtils.GISTDETAILFRAGMENT)
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

    private fun configSaveItemGist(gistFavorite: GistsListDTOItem){
        val gistList = mutableListOf<DetailGistVODB>()
        gistList.add(DetailGistVODB(gistFavorite.id, gistFavorite.owner.login, gistFavorite.owner.avatar_url))
        gistsViewModel.insertGists(GistInfoEntity(gistList))
    }

}
