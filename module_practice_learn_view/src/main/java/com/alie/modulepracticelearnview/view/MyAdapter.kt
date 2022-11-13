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
        holder.itemBinding.tv1.text = person.name+person.count
        println("===update onBindViewHolder name:${person.name} count:${person.count}")
    }
}

class MyViewHolder(val itemBinding: ItemMyAdapterBinding) : ViewHolder(itemBinding.root)
class MyAdapterDiffUtilCallback : DiffUtil.ItemCallback<Person>() {

    /**
     * 刷新时 item是否相同可用id进行判断
     * @param oldItem
     * @param newItem
     * @return true->进入areContentsTheSame（）
     *         false->直接更新ui
     */
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        println("===update areItemsTheSame oldname:${oldItem.name} newname:${newItem.name} newcount:${newItem.count}")
        return oldItem.name == newItem.name
    }

    /**
     * 刷新时 相同item下，内容是否相同
     *
     * @param oldItem
     * @param newItem
     * @return true-> 内容相同 不会更新item（即不会调用onBindViewHolder（））
     *         false-> 内容不同，调用getChangePayload（） 进行更新
     */
    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        println("===update areContentsTheSame oldname:${oldItem.name} newnamw:${newItem.name} newcount:${newItem.count}")
        return oldItem.count == newItem.count
    }

    /**
     * 处理最终的差量更新
     *
     * @param oldItem
     * @param newItem
     * @return
     */
    override fun getChangePayload(oldItem: Person, newItem: Person): Any? {
        println("===update getChangePayload oldname:${oldItem.name} newnamw:${newItem.name} newcount:${newItem.count}")
        return newItem
    }

}