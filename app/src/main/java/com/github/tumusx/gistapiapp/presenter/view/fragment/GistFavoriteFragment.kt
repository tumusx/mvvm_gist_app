package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.tumusx.gistapiapp.databinding.FragmentFavoriteItemBinding
import com.github.tumusx.gistapiapp.presenter.view.adapter.GistFavoriteAdapter
import com.github.tumusx.gistapiapp.presenter.view.adapter.TypeFavoriteGist
import com.github.tumusx.gistapiapp.presenter.viewModel.GistFavoriteViewModel
import com.google.firebase.database.DatabaseReference
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GistFavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteItemBinding
    private val favoriteAdapter = GistFavoriteAdapter()
    private lateinit var viewModel: GistFavoriteViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteItemBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[GistFavoriteViewModel::class.java]
        viewModel.readFavoriteItem()
        configUIAdapter()
        return binding.root
    }

    private fun configUIAdapter() {

        binding.rvLastedGist.adapter = favoriteAdapter
        favoriteAdapter.updateGistList(TypeFavoriteGist.getListMagalu())
    }
}