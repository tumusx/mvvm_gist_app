package com.github.tumusx.gistapiapp.presenter.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.databinding.ContainerItemGistListBinding
import com.github.tumusx.gistapiapp.utils.CommonDiffUtil

class GistListAdapter(private val itemGist: (GistsListDTOItem) -> Unit) :
    RecyclerView.Adapter<GistListAdapter.GistListViewHolder>() {
    private var lastedGist = emptyList<GistsListDTOItem>()
    var selectFavoriteItem: Int? = null

    class GistListViewHolder(val binding: ContainerItemGistListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun configUIList(gistsItem: GistsListDTOItem) {
            Glide.with(binding.imgAvatarUserGist).load(gistsItem.owner?.avatar_url)
                .into(binding.imgAvatarUserGist)
            binding.txtNameUserGist.text = gistsItem.owner?.login ?: "not user"
            binding.txtFileGist.text = gistsItem.typeFile()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistListViewHolder {
        val viewLayout = LayoutInflater.from(parent.context)
        val binding = ContainerItemGistListBinding.inflate(viewLayout, parent, false)
        return GistListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GistListViewHolder, position: Int) {
        holder.configUIList(lastedGist[position])
        favoriteGist(holder, lastedGist[position])
        detailGistUser(holder, lastedGist[position])
    }

    override fun getItemCount() = lastedGist.size

    private fun detailGistUser(holder: GistListViewHolder, gistItemDTOItem: GistsListDTOItem) {
        holder.binding.btnOpenDetail.setOnClickListener {
            selectFavoriteItem = 1
            itemGist.invoke(gistItemDTOItem)
        }
    }

    private fun favoriteGist(holder: GistListViewHolder, gistItemDTOItem: GistsListDTOItem) {
        holder.binding.favoriteItem.setOnClickListener {
            selectFavoriteItem = 2
            itemGist.invoke(gistItemDTOItem)
        }
    }


    fun updateGistList(gists: List<GistsListDTOItem>) {
        val myDiffUtilCommon = CommonDiffUtil(lastedGist, gists)
        val diffUtilResultDispatcher = DiffUtil.calculateDiff(myDiffUtilCommon)
        lastedGist = gists
        diffUtilResultDispatcher.dispatchUpdatesTo(this)
    }

}