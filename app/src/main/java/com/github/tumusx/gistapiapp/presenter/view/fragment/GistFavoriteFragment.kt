package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.tumusx.gistapiapp.databinding.FragmentFavoriteItemBinding

class GistFavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteItemBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        binding = FragmentFavoriteItemBinding.inflate(layoutInflater)
        return binding.root
    }
}