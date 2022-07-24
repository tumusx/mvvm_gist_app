package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.databinding.FragmentLastedGistBinding
import com.github.tumusx.gistapiapp.presenter.view.adapter.GistListAdapter
import com.github.tumusx.gistapiapp.presenter.viewModel.GistListViewModel
import com.github.tumusx.gistapiapp.utils.ConstUtils
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GistListFragment : Fragment() {
    private lateinit var binding: FragmentLastedGistBinding
    private lateinit var gistsListAdapter: RecyclerView.Adapter<*>
    private lateinit var gistsViewModel: GistListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLastedGistBinding.inflate(layoutInflater)
        gistsViewModel = ViewModelProvider(this)[GistListViewModel::class.java]
        configAdapter()
        configObservables()
        return binding.root
    }

    private fun configObservables() {
        gistsViewModel.getStats.observe(viewLifecycleOwner, this::configUpdateListAdapter)
        gistsViewModel.messageErrorRequest.observe(viewLifecycleOwner, this::showMessageError)
    }

    private fun showMessageError(messageError: String) {
        Snackbar.make(binding.root, messageError, Snackbar.LENGTH_SHORT).show()
    }

    private fun configAdapter() {
        gistsListAdapter = GistListAdapter { gistItemSelect ->
            configEventClickAdapter((gistsListAdapter as GistListAdapter), gistItemSelect)
        }

        binding.rvLastedGist.adapter = gistsListAdapter
    }

    private fun configEventClickAdapter(
        gistListAdapter: GistListAdapter,
        gistSelectItem: GistsListDTOItem
    ) {
        when (gistListAdapter.selectFavoriteItem) {
            1 -> {
                GistDetailFragment(gistSelectItem.id).show(
                    childFragmentManager,
                    ConstUtils.GISTDETAILFRAGMENT
                )
            }

            2 -> {
                gistsViewModel.favoriteGistItem(gistSelectItem)
            }

            else -> {
                return
            }
        }
    }


    private fun configUpdateListAdapter(gistItems: List<GistsListDTOItem>) {
        (gistsListAdapter as GistListAdapter).updateGistList(gistItems.distinctBy { it.owner.id })
    }

}
