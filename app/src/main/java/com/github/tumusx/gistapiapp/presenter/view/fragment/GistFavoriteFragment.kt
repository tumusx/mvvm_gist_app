package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.gistapiapp.databinding.FragmentFavoriteItemBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GistFavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteItemBinding
    private lateinit var favoriteAdapter: RecyclerView.Adapter<*>
    private lateinit var databaseFirebase: DatabaseReference
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteItemBinding.inflate(layoutInflater)
        return binding.root
    }

/*    private fun configUIAdapter(favoriteItemGist: List<String>) {
        favoriteAdapter = GistFavoriteAdapter() {}
        binding.rvLastedGist.adapter = favoriteAdapter as GistFavoriteAdapter
        (favoriteAdapter as GistFavoriteAdapter).updateGistList(favoriteItemGist)
    }*/
}