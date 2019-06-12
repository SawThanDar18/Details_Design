package com.example.details_design.branch_detail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.details_design.R
import com.example.details_design.branch_detail.model.Services

class ServicesHolder(itemView: View, private val mContext: Context) : RecyclerView.ViewHolder(itemView) {

    private val service_title : TextView

    init {
        service_title = itemView.findViewById<View>(R.id.branch_detail_tv) as TextView
    }

    fun index(services: Services){
        service_title.text = services.title
    }
}
