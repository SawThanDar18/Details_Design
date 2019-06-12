package com.example.details_design.branch_detail.service

import com.example.details_design.branch_detail.model.Branch
import com.example.details_design.branch_detail.response.BranchDetailResponse
import com.example.details_design.branch_detail.response.BranchResponse
import com.example.details_design.branch_detail.response.ServicesResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

internal interface JsonHolderApi {

    /*@POST("api/branchDetail/")
    fun getBranchDetail() : Call<BranchDetailResponse>*/

    @POST("https://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com:3520/ConnectApp/api/branchDetail")
    fun getServices() : Call<ServicesResponse>

    @POST("api/branchDetail/")
    fun getToken(@Header("Authorization") authToken: String): Call<ResponseBody>

    @POST("api/branchDetail/")
    fun getBranchBody(@Body branch: Branch) : Call<BranchResponse>
}