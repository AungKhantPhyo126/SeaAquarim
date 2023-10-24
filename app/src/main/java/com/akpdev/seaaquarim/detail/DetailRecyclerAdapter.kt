package com.akpdev.seaaquarim.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akpdev.seaaquarim.data.MyDummyData
import com.akpdev.seaaquarim.databinding.ItemDetailRecyclerBinding

class DetailRecyclerAdapter :
    ListAdapter<MyDummyData, DetailRecyclerAdapter.DetailItemViewHolder>(DetailItemsDiffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailItemViewHolder {
        return DetailItemViewHolder(
            ItemDetailRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DetailItemViewHolder(private val binding: ItemDetailRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MyDummyData) {
            binding.ivDetail.setImageResource(data.image)
        }
    }
}

object DetailItemsDiffUtil : DiffUtil.ItemCallback<MyDummyData>() {
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