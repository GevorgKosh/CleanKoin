package com.example.empty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.empty.R
import com.example.empty.data.GithubModelItem
import com.example.empty.databinding.ItemTaskBinding

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private var list: List<GithubModelItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    fun setList(list: List<GithubModelItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: GithubModelItem) {
            binding.item = model
            binding.executePendingBindings()
        }
    }
}