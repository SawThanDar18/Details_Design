package com.example.details_design.branch_detail.response

import com.example.details_design.branch_detail.model.Branch
import com.google.gson.annotations.SerializedName

class BranchResponse {

    @SerializedName("Request")
    val branch : ArrayList<Branch>? = null
}