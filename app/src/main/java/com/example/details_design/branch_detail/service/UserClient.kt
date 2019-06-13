package com.example.details_design.branch_detail.service


import com.example.details_design.branch_detail.model.Token
import retrofit2.Call
import retrofit2.http.*

internal interface UserClient {

    @FormUrlEncoded
    @POST("api/oauth/requesttoken")
    fun userLogin(@Field("username") username : String,
                  @Field("password") password : String,
                  @Field("grant_type") grant_type : String): Call<Token>
}