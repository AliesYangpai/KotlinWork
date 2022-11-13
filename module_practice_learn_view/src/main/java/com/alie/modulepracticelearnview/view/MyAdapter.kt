package com.alie.modulepracticelearnview.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alie.modulepracticelearnview.databinding.ItemMyAdapterBinding

class MyAdapter : ListAdapter<Person, MyViewHolder>(MyAdapterDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMyAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = getItem(position)
        holder.itemBinding.iv1.setImageResource(person.drawableId)
        holder.itemBinding.tv1.text = person.name
    }
}

class MyViewHolder(val itemBinding: ItemMyAdapterBinding) : ViewHolder(itemBinding.root)
class MyAdapterDiffUtilCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return false
    }

}