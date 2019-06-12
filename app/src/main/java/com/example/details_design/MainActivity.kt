package com.example.details_design

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout.VERTICAL


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerview : RecyclerView
    private lateinit var recyclerAdapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.branch_detail)

        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = GridLayoutManager(this, 1, VERTICAL, false)

        /*val details = ArrayList<Details>()
        details.add(Details("KBZ Pay"))
        details.add(Details("Internet Banking"))
        details.add(Details("KBZ Quick Pay"))
        details.add(Details("Western Union(Inward/Outward Remittance)"))
        details.add(Details("Home Loan"))
        details.add(Details("Hire Purchase"))
        details.add(Details("Saving Deposit Account"))
        details.add(Details("Explore Debit Card_MPU Card"))
        details.add(Details("FuturePlus Deposit Account"))
        details.add(Details("Call Deposit Account"))
        details.add(Details("Current Account"))
        details.add(Details("Overdraft"))
        details.add(Details("Local Remittance"))
        details.add(Details("Gift Cheque"))
        details.add(Details("Fixed Deposit Account"))
        details.add(Details("Payroll Services"))
        details.add(Details("Teens Card"))
        details.add(Details("Payment Order"))
        details.add(Details("Children's Saving Account"))
        details.add(Details("Bank Certificate"))

        recyclerAdapter = RecyclerAdapter(details)
        recyclerview.adapter = recyclerAdapter*/



        /*val detail = arrayOf(
            "KBZ Pay",
            "Internet Banking",
            "KBZ Quick Pay",
            "Western Union(Inward/Outward Remittance",
            "Home Loan",
            "Hire Purchase",
            "Saving Deposit Account",
            "Explore Debit Card_MPU Card",
            "FuturePlus Deposit Account",
            "Call Deposit Account",
            "Current Account",
            "Overdraft",
            "Local Remittance",
            "Gift Cheque",
            "Fixed Deposit Account",
            "Payroll Services",
            "Teens Card",
            "Payment Order",
            "Children's Saving Account",
            "Bank Certificate"
        )
*/

    }
}
