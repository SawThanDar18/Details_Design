package com.example.details_design.branch_detail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.details_design.R
import com.example.details_design.branch_detail.model.Services

class ServicesAdapter(private val services:ArrayList<Services>, private val mContext: Context) : RecyclerView.Adapter<ServicesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.branch_detail_item, parent, false)
        return ServicesHolder(view, mContext)
    }

    override fun onBindViewHolder(holder: ServicesHolder, position: Int) {

        holder?.index(services[position])
    }

    override fun getItemCount(): Int {
        return services.size
    }


}