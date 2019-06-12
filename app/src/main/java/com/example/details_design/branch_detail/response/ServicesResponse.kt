package com.example.details_design.branch_detail.response

import com.example.details_design.branch_detail.model.Services
import com.google.gson.annotations.SerializedName

class ServicesResponse {

    @SerializedName("Services")
    val services : ArrayList<Services>? = null
}