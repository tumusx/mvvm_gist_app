package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.bumptech.glide.Glide
import com.github.tumusx.gistapiapp.R
import com.github.tumusx.gistapiapp.data.local.db.GistDataBase
import com.github.tumusx.gistapiapp.data.local.entity.GistInfoEntity
import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.databinding.FragmentDetailGistsBinding
import com.github.tumusx.gistapiapp.presenter.viewModel.GistDetailViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GistDetailFragment(private val idUserGist: String?) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDetailGistsBinding
    private lateinit var detailGistViewModel: GistDetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailGistsBinding.inflate(layoutInflater)
        detailGistViewModel = ViewModelProvider(this)[GistDetailViewModel::class.java]
        BottomSheetBehavior.PEEK_HEIGHT_AUTO
        searchDetailGist()
        configObservable()
        return binding.root
    }


    private fun searchDetailGist() {
        if (idUserGist != null)
            detailGistViewModel.getDetailGists(idUserGist)

        else
            Snackbar.make(binding.root, "Não é possível encontrar o detalhe deste gist!", Snackbar.LENGTH_SHORT).show()
    }


    private fun configObservable() {
        detailGistViewModel.detailGist.observe(viewLifecycleOwner, this::getDetailGistUser)
        detailGistViewModel.messageError.observe(viewLifecycleOwner, this::showMessageErrorRequest)
    }

    private fun showMessageErrorRequest(messageError: String){
        Snackbar.make(binding.root, messageError, Snackbar.LENGTH_SHORT).show()
    }

    private fun getDetailGistUser(gistDetail: DetailGistDTO) {
        binding.txtNameUserGist.text = gistDetail.owner.login
        binding.txtUpdateAt.text = gistDetail.updated_at
        binding.txtCreateAt.text = gistDetail.created_at
        binding.txtDescriptionGist.text = gistDetail.description
        Glide.with(binding.imgAvatar).load(gistDetail.owner.avatar_url).into(binding.imgAvatar)
    }

}