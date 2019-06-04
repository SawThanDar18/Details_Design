package com.example.details_design.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.example.details_design.R

class Feature_Activity : AppCompatActivity(){

    //private lateinit var recyclerview : RecyclerView
    //private lateinit var featureAdapter: FeatureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_page)

        /*recyclerview = findViewById(R.id.feature_recyclerview)
        recyclerview.layoutManager = GridLayoutManager(this, 1, VERTICAL, false)

        val feaure = ArrayList<Feature>()
        feaure.add(Feature("Pay with your phone."))
        feaure.add(Feature("Pay merchant and bills in the time it takes to scan a QR code."))
        feaure.add(Feature("Send and receive money instantly."))
        feaure.add(Feature("Repay your buddies in seconds with free KBZPay to KBZPay money transfers."))
        feaure.add(Feature("Top up airtime on all major telcos."))
        feaure.add(Feature("Top up your mobile airtime on MPT, Telenor, Ooredoo and Myel anytime, anywhere."))
        feaure.add(Feature("Safe and reliable."))
        feaure.add(Feature("Secured money transfers so no third-party can cash out without your permission, ever."))

        featureAdapter = FeatureAdapter(feaure)
        recyclerview.adapter = featureAdapter*/
    }
}