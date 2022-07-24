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
import com.github.tumusx.gistapiapp.databinding.FragmentFavoriteItemBinding
import com.github.tumusx.gistapiapp.presenter.view.adapter.GistFavoriteAdapter
import com.github.tumusx.gistapiapp.presenter.viewModel.GistActionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GistFavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteItemBinding
    private lateinit var viewModel: GistActionViewModel
    private lateinit var favoriteAdapter: RecyclerView.Adapter<*>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteItemBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[GistActionViewModel::class.java]
        configViewModel()
        return binding.root
    }

    private fun configUIAdapter(favoriteItemGist: List<DetailGistVODB>) {
        favoriteAdapter = GistFavoriteAdapter() {}
        binding.rvLastedGist.adapter = favoriteAdapter as GistFavoriteAdapter
        (favoriteAdapter as GistFavoriteAdapter).updateGistList(favoriteItemGist)
    }

    private fun configViewModel() {
        val favoriteListItems = mutableListOf<DetailGistVODB>()
        favoriteListItems.add(DetailGistVODB("joao", "jose", "mariaJose"))
        configUIAdapter(favoriteListItems)
    }
}