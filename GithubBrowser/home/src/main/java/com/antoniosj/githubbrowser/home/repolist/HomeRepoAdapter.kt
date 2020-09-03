package com.antoniosj.githubbrowser.home.repolist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoniosj.githubbrowser.home.databinding.RepoItemBinding

class HomeRepoAdapter(
    private val onRepoSelected: (repoOwner: String, repoName: String) -> Unit
): RecyclerView.Adapter<HomeRepoAdapter.RepoItemViewHolder>() {

    private val dataList: MutableList<RepoItem> = mutableListOf()

    fun setRepoItems(repoItems: List<RepoItem>) {
        dataList.clear()
        dataList.addAll(repoItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        val binding = RepoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoItemViewHolder(binding, onRepoSelected)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    class RepoItemViewHolder(private val binding: RepoItemBinding,
                             onRepoSelected: (repoOwner: String, repoName: String) -> Unit
    )
        : RecyclerView.ViewHolder(binding.root) {

        private var repoItem: RepoItem? = null

        init {
            itemView.setOnClickListener {
                repoItem?.let {
                    repo -> onRepoSelected(repo.ownerName, repo.name)
                }
            }
        }

        fun bind(repoItem: RepoItem) {
            this.repoItem = repoItem
            binding.tvRepoName.text = repoItem.name
            binding.tvRepoDescription.text = repoItem.description
            binding.tvStarsCount.text = "${repoItem.starsCount}"
            binding.tvForkCount.text = "${repoItem.forkCount}"
        }
    }
}