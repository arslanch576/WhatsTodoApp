package com.coderobust.whatstodoapp

import android.graphics.Paint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.coderobust.whatstodoapp.databinding.ItemTodoBinding

class RecyclerViewAdapter(val items: List<ToDoItem>) : RecyclerView.Adapter<ToDoItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoItemViewHolder {
        return ToDoItemViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ToDoItemViewHolder, position: Int) {
        val item = items.get(position)

        fun refresh() {
            holder.binding.title.text = item.title
            holder.binding.description.text = item.details
            if (item.isDone) {
                holder.binding.isDone.isChecked = true
                holder.binding.title.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                holder.binding.description.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                holder.binding.title.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.light_grey
                    )
                )
                holder.binding.description.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.light_grey
                    )
                )
            } else {
                holder.binding.isDone.isChecked = false
                holder.binding.title.paintFlags = 0
                holder.binding.description.paintFlags = 0
                holder.binding.title.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.black
                    )
                )
                holder.binding.description.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.dark_grey
                    )
                )
            }
        }

        holder.binding.isDone.setOnCheckedChangeListener(null)
        refresh()
        holder.binding.isDone.setOnCheckedChangeListener { buttonView, isChecked ->
            item.isDone = isChecked
            //TODO: 3 - write code to update item in database
            refresh()
        }

    }

}