package com.example.details_design.branch_detail.response

import com.example.details_design.branch_detail.model.Details
import com.google.gson.annotations.SerializedName

class BranchDetailResponse {

    @SerializedName("BRANCH_INFO")
    val details : ArrayList<Details>? = null
}