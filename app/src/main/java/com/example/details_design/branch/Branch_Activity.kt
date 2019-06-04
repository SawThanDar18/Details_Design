package com.example.details_design.branch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.GridLayout.VERTICAL
import com.example.details_design.R

class Branch_Activity : AppCompatActivity() {

    private lateinit var recyclerview : RecyclerView
    private lateinit var branchAdapter: BranchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.branch_location)

        recyclerview = findViewById(R.id.branch_recyclerview)
        recyclerview.layoutManager = GridLayoutManager(this, 1, VERTICAL, false)

        val branch = ArrayList<Branch>()
        branch.add(Branch("Branch","NAMSANG", "No.3/10,National Road,3rd Quarter,NamSang Township,Shan State", "9:30 AM - 3:00 PM"))
        branch.add(Branch("Branch","YGN-111 SANCHAUNG-PHAPONE STREET", "No.49,KYUNTAW ST,PHAPONE ST CORNER,KYUNTAW SOUTH QTR,SANCHAUNG PHAPONE ST,SANCHUANG TSP", "9:30 AM - 3:00 PM"))
        branch.add(Branch("ATM","San Chaung Mini", "SANCHAUNG MINI BANK,NO.160/164 GROUND FLOOR,BAHO ROAD,SANCHAUNG.", "Open Now"))
        branch.add(Branch("ATM","Nation Mart Sat San", "SAT SAN NATION MART,NO.(315/317),UPPER PAZON TAUNG ROAD,MINGALAR TAUNG NYUNT,YANGON.", "Open Now"))

        branchAdapter = BranchAdapter(branch)
        recyclerview.adapter = branchAdapter

    }
}