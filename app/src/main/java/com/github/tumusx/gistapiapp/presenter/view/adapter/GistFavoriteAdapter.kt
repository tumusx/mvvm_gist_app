/*
package com.github.tumusx.gistapiapp.presenter.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.tumusx.gistapiapp.R
import com.github.tumusx.gistapiapp.data.local.model.DetailGistVODB
import com.github.tumusx.gistapiapp.databinding.ContainerItemFavoriteListBinding
import com.github.tumusx.gistapiapp.utils.CommonDiffUtil

class GistFavoriteAdapter(private val removeFavorite: (DetailGistVODB)-> Unit) : RecyclerView.Adapter<GistFavoriteAdapter.GistFavoriteViewHolder>() {
    private var itemsSave = emptyList<DetailGistVODB>()

    class GistFavoriteViewHolder(val binding: ContainerItemFavoriteListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun configUIList(gistsItem: DetailGistVODB) {
            Glide.with(binding.imgAvatarUserGist).load(gistsItem.imageDrawable).into(binding.imgAvatarUserGist)
            binding.txtNameUserGist.text = gistsItem.nameUserGist
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistFavoriteViewHolder {
        val viewLayout = LayoutInflater.from(parent.context)
        val binding = ContainerItemFavoriteListBinding.inflate(viewLayout, parent, false)
        return GistFavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GistFavoriteViewHolder, position: Int) {
        holder.configUIList(itemsSave[position])
        favoriteGist(holder, itemsSave[position])
    }

    private fun favoriteGist(holder: GistFavoriteViewHolder, gistItemDTOItem: DetailGistVODB) {
        holder.binding.favoriteItem.setOnClickListener {
            holder.binding.favoriteItem.setImageResource(R.drawable.ic_set_favorite_item_gist)
            removeFavorite.invoke(gistItemDTOItem)
        }
    }

    override fun getItemCount() = itemsSave.size

    fun updateGistList(gists: List<DetailGistVODB>) {
        val myDiffUtilCommon = CommonDiffUtil(itemsSave, gists)
        val diffUtilResultDispatcher = DiffUtil.calculateDiff(myDiffUtilCommon)
        itemsSave = gists
        diffUtilResultDispatcher.dispatchUpdatesTo(this)
    }
}*/
