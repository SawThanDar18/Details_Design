package com.example.details_design.branch_detail.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.GridLayout.VERTICAL
import android.widget.TextView
import android.widget.Toast
import com.example.details_design.R
import com.example.details_design.branch_detail.service.JsonHolderApi
import com.example.details_design.branch_detail.ServicesAdapter
import com.example.details_design.branch_detail.model.Branch
import com.example.details_design.branch_detail.model.Token
import com.example.details_design.branch_detail.response.BranchResponse
import com.example.details_design.branch_detail.service.UserClient
import okhttp3.OkHttpClient
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

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
        initRetrofit()
        //getBranchBody(token!!)
    }

    fun getOkHttpClient(): OkHttpClient {
        try {
            val sslContext = SSLContext.getInstance("SSL")

            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }

                @Throws(CertificateException::class)
                override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
                }
            })

            sslContext.init(null, trustAllCerts, java.security.SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { hostname, session -> true }
            builder.connectTimeout(1, TimeUnit.MINUTES)
            builder.readTimeout(1, TimeUnit.MINUTES)
            builder.writeTimeout(1, TimeUnit.MINUTES)

            return builder.build()

        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }


    private fun initRetrofit(){
        val client = getOkHttpClient()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com:3520/ConnectApp/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        jsonHolderApi = retrofit.create(JsonHolderApi::class.java)

    }

    private fun authRetrofit(){
        val client = getOkHttpClient()
        val retrofit2 = Retrofit.Builder()
            .baseUrl("https://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com:3501/oauthserver/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        userClient = retrofit2.create(UserClient::class.java)
    }

    private fun userLogin(){

            userClient.userLogin("KCA","KCA","password").enqueue(object : Callback<Token> {
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    Log.i("user login","completed")
                    if (response.isSuccessful) {
                        Log.i("user login","completed")
                        token = response.body()!!.access_token!!
                        getBranchBody("Bearer ${token!!}")

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

    private fun getBranchBody(token : String){

        val branch = Branch("101","5.01")
        jsonHolderApi.getBranchBody(token,branch).enqueue(object : Callback<BranchResponse>{
            override fun onFailure(call: Call<BranchResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t?.localizedMessage, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<BranchResponse>, response: Response<BranchResponse>) {
              if(response != null){
                  Toast.makeText(applicationContext, "", Toast.LENGTH_LONG).show()
                  bindData(response.body()!!)
              }
            }
        })
    }

    private fun bindData(body: BranchResponse) {

        val branch_title = findViewById<TextView>(R.id.branch_title)
        val branch_address = findViewById<TextView>(R.id.branch_address)
        val branch_phone = findViewById<TextView>(R.id.branch_phone)

        //service_title.text = services.title
        branch_title.text = body.details!!.branch_name
        branch_address.text = body.details!!.branch_address
        branch_phone.text = body.details!!.branch_phone

        recyclerview = findViewById(R.id.recyclerview)
        servicesAdapter = ServicesAdapter(body.services!!, this)
        recyclerview.adapter = servicesAdapter
        var layoutManager = GridLayoutManager(this, 1, VERTICAL, false)
        recyclerview.setLayoutManager(layoutManager)
    }
}