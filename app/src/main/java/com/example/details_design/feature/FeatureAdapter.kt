package com.example.details_design.feature

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.details_design.R

class FeatureAdapter (val featureList : ArrayList<Feature>) : RecyclerView.Adapter<FeatureAdapter.ViewHolder>(){

    override fun onCreateViewHolder(view: ViewGroup, position: Int): ViewHolder {
        val layout = LayoutInflater.from(view.context).inflate(R.layout.feature_list, view, false)
        return ViewHolder(layout)

    }

    override fun getItemCount(): Int {
        return featureList.size
    }

    override fun onBindViewHolder(view: ViewHolder, position: Int) {
        val feature : Feature = featureList[position]
        view.feature_title.text = feature.feature_title
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val feature_title = itemView.findViewById(R.id.name) as TextView
    }
}