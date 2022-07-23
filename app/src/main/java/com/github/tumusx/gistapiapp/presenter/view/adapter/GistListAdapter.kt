package com.github.tumusx.gistapiapp.presenter.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.databinding.ContainerItemGistListBinding
import com.github.tumusx.gistapiapp.utils.CommonDiffUtil

class GistListAdapter(private val getId: (String)-> Unit) : RecyclerView.Adapter<GistListAdapter.GistListViewHolder>() {
    private var lastedGist = emptyList<GistsListDTOItem>()

    class GistListViewHolder(val binding: ContainerItemGistListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun configUIList(gistsItem: GistsListDTOItem) {
            Glide.with(binding.imgAvatarUserGist).load(gistsItem.owner.avatar_url).into(binding.imgAvatarUserGist)
            binding.txtNameUserGist.text  = gistsItem.owner.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistListViewHolder {
        val viewLayout = LayoutInflater.from(parent.context)
        val binding = ContainerItemGistListBinding.inflate(viewLayout, parent, false)
        return GistListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GistListViewHolder, position: Int) {
        holder.configUIList(lastedGist[position])
        favoriteGist(holder, position)
        detailGistUser(holder, position)
    }

    private fun detailGistUser(holder: GistListViewHolder, position: Int){
        holder.binding.llcontainer.setOnClickListener {
            getId.invoke(lastedGist[position].id)
        }
    }

    private fun favoriteGist(holder: GistListViewHolder, position: Int){
        holder.binding.favoriteItem.setOnClickListener {
            getId.invoke(lastedGist[position].id)
        }
    }

    override fun getItemCount() = lastedGist.size

    fun updateGistList(gists: List<GistsListDTOItem>) {
        val myDiffUtilCommon = CommonDiffUtil(lastedGist, gists)
        val diffUtilResultDispatcher = DiffUtil.calculateDiff(myDiffUtilCommon)
        lastedGist = gists
        diffUtilResultDispatcher.dispatchUpdatesTo(this)
    }

}