package com.example.details_design.branch_detail.response

import com.example.details_design.branch_detail.model.Branch
import com.example.details_design.branch_detail.model.Details
import com.example.details_design.branch_detail.model.Services
import com.google.gson.annotations.SerializedName

class BranchResponse {

    @SerializedName("Request")
    val branch : Branch? = null

    @SerializedName("BRANCH_INFO")
    val details : Details? = null

    @SerializedName("Services")
    val services : ArrayList<Services>? = null
}