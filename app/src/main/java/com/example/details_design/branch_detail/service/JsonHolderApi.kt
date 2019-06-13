package com.example.details_design.branch_detail.service

import com.example.details_design.branch_detail.model.Branch
import com.example.details_design.branch_detail.response.BranchResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

internal interface JsonHolderApi {

    /*@POST("api/branchDetail/")
    fun getBranchDetail() : Call<BranchDetailResponse>*/

    @POST("api/branchDetail")
    fun getBranchBody(@Header("Authorization") authToken: String, @Body branch: Branch) : Call<BranchResponse>
}