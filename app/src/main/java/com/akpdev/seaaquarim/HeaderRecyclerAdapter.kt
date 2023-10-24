package com.akpdev.seaaquarim

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akpdev.seaaquarim.data.MyDummyData
import com.akpdev.seaaquarim.databinding.ItemHeaderRecyclerBinding

class HeaderRecyclerAdapter :
    ListAdapter<MyDummyData, HeaderRecyclerAdapter.HeaderViewHolder>(HeaderViewDiffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder(
            ItemHeaderRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HeaderViewHolder(private val binding: ItemHeaderRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MyDummyData) {
            binding.ivHeader.setImageResource(data.image)
        }
    }
}

object HeaderViewDiffUtil : DiffUtil.ItemCallback<MyDummyData>() {
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