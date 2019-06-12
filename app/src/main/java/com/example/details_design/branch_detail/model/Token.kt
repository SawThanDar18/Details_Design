package com.example.details_design.branch_detail.model

import com.google.gson.annotations.SerializedName

class Token {

    @SerializedName("access_token")
    val access_token : String? = null

    @SerializedName("token_type")
    val token_type : String? = null

    @SerializedName("expires_in")
    val expires_in : String? = null
}