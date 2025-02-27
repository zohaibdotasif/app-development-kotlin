package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList: ArrayList<DataClass>, private val listener: (DataClass) -> Unit): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle
        holder.itemView.setOnClickListener { listener(currentItem) }
    }

    // attach all the elements with their respective variables
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage = itemView.findViewById<ImageView>(R.id.image)
        val rvTitle = itemView.findViewById<TextView>(R.id.title)
    }
}