package com.akpdev.seaaquarim

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akpdev.seaaquarim.data.MyDummyData
import com.akpdev.seaaquarim.databinding.ItemUpcomingShowBinding

class UpcomingShowsRecyclerAdapter(private val navigateDetail:()->Unit) :
    ListAdapter<MyDummyData, UpcomingShowsRecyclerAdapter.UpcomingShowViewHolder>(UpcomingShowDiffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingShowViewHolder {
        return UpcomingShowViewHolder(
            ItemUpcomingShowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), navigateDetail
        )
    }

    override fun onBindViewHolder(holder: UpcomingShowViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UpcomingShowViewHolder(private val binding: ItemUpcomingShowBinding,navigateDetail: () -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MyDummyData) {
            binding.ivUpcomingShow.setImageResource(data.image)
            binding.tvTime.text = data.time
            binding.mcvUpcomingShow.setOnClickListener { navigateDetail() }
        }
    }
}

object UpcomingShowDiffUtil : DiffUtil.ItemCallback<MyDummyData>() {
    override fun areItemsTheSame(oldItem: MyDummyData, newItem: MyDummyData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MyDummyData,
        newItem: MyDummyData
    ): Boolean {
        return oldItem == newItem
    }

}