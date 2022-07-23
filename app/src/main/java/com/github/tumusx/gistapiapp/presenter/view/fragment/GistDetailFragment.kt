package com.github.tumusx.gistapiapp.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.databinding.FragmentDetailGistsBinding
import com.github.tumusx.gistapiapp.presenter.viewModel.GistDetailViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

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
    }

    private fun getDetailGistUser(gistDetail: GistDetailDTO) {
        binding.txtNameUserGist.text = gistDetail.id
        binding.txtUpdateAt.text = gistDetail.updatedAt
        binding.txtCreateAt.text = gistDetail.createdAt
        binding.txtDescriptionGist.text = gistDetail.description
    }

}