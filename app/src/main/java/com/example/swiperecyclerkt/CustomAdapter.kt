package com.example.swiperecyclerkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataList: MutableList<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val deleteIcon: ImageView = itemView.findViewById(R.id.deleteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataList[position]
        holder.deleteIcon.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun removeItem(position: Int) {
        if (position in 0 until dataList.size) {
            dataList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun moveItem(fromPosition: Int, toPosition: Int) {
        if (fromPosition in 0 until dataList.size && toPosition in 0 until dataList.size) {
            val item = dataList.removeAt(fromPosition)
            dataList.add(toPosition, item)
            notifyItemMoved(fromPosition, toPosition)
        }
    }
}