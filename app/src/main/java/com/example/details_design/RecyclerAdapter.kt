package com.example.details_design

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecyclerAdapter(val detailList : ArrayList<Details>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(view: ViewGroup, position: Int): ViewHolder {
        val layout = LayoutInflater.from(view.context).inflate(R.layout.branch_detail_item, view, false)
        return ViewHolder(layout)

    }

    override fun getItemCount(): Int {
        return detailList.size
    }

    override fun onBindViewHolder(view: ViewHolder, position: Int) {
        val detail : Details = detailList[position]
        view.name.text = detail.name
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById(R.id.branch_detail_tv) as TextView
    }
}