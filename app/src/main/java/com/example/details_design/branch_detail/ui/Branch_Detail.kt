package com.example.details_design.branch_detail.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.GridLayout.VERTICAL
import android.widget.Toast
import com.example.details_design.R
import com.example.details_design.branch_detail.service.JsonHolderApi
import com.example.details_design.branch_detail.ServicesAdapter
import com.example.details_design.branch_detail.model.Branch
import com.example.details_design.branch_detail.model.Token
import com.example.details_design.branch_detail.response.BranchResponse
import com.example.details_design.branch_detail.response.ServicesResponse
import com.example.details_design.branch_detail.service.UserClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class Branch_Detail : AppCompatActivity() {

    private lateinit var servicesAdapter: ServicesAdapter
    private lateinit var jsonHolderApi: JsonHolderApi
    private lateinit var userClient : UserClient
    private lateinit var recyclerview : RecyclerView
    private var token : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.branch_detail)

        authRetrofit()
        userLogin()
        /*initRetrofit()
        getToken()
        getBranchBody()
        getServices()*/
    }

    private fun initRetrofit(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com:3520/ConnectApp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        jsonHolderApi = retrofit.create(JsonHolderApi::class.java)

    }

    private fun authRetrofit(){
        val retrofit2 = Retrofit.Builder()
            .baseUrl("https://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com:3501/oauthserver/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userClient = retrofit2.create(UserClient::class.java)
    }

    private fun userLogin(){

            userClient.userLogin("KCA","KCA","password").enqueue(object : Callback<Token> {
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    Log.i("user login","completed")
                    if (response.isSuccessful) {
                        Log.i("user login","completed")
                        Toast.makeText(applicationContext, response.body()!!.access_token, Toast.LENGTH_LONG).show()
                        token = response.body()!!.access_token!!

                    } else {
                        Log.i("user login","failed")
                        Toast.makeText(applicationContext, "error", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Toast.makeText(applicationContext, "error", Toast.LENGTH_LONG).show()
                }

            })
    }

    private fun getToken(){

        jsonHolderApi.getToken(token!!).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.i("msg2","err")
                if (response.isSuccessful) {
                    try {
                        Toast.makeText(applicationContext, response.body()!!.string(), Toast.LENGTH_LONG).show()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                } else {
                    Toast.makeText(applicationContext, "error", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(applicationContext, t?.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getServices(){
        jsonHolderApi.getServices().enqueue(object : Callback<ServicesResponse>{
            override fun onFailure(call: Call<ServicesResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t?.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ServicesResponse>, response: Response<ServicesResponse>) {
                if(response != null){
                    bindData(response.body()!!)
                }
            }
        })
    }

    private fun getBranchBody(){

        val branch = Branch("101","5.01")
        jsonHolderApi.getBranchBody(branch).enqueue(object : Callback<BranchResponse>{
            override fun onFailure(call: Call<BranchResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t?.localizedMessage, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<BranchResponse>, response: Response<BranchResponse>) {
              if(response != null){
                  Toast.makeText(applicationContext, "", Toast.LENGTH_LONG).show()
              }
            }
        })
    }

    private fun bindData(body: ServicesResponse) {

        recyclerview = findViewById(R.id.recyclerview)
        servicesAdapter = ServicesAdapter(body.services!!, this)
        recyclerview.adapter = servicesAdapter
        var layoutManager = GridLayoutManager(this, 1, VERTICAL, false)
        recyclerview.setLayoutManager(layoutManager)
    }
}