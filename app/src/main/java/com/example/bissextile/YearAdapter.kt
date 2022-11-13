package com.example.bissextile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class YearAdapter(private val years: List<Int>): RecyclerView.Adapter<YearAdapter.YearHolder>() {
    class YearHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        init {
            textView = itemView.findViewById(R.id.tvYear)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_element, parent, false)
        return YearHolder(view)
    }

    override fun onBindViewHolder(holder: YearHolder, position: Int) {
        holder.textView?.text = years[position].toString()
    }

    override fun getItemCount(): Int = years.size




}