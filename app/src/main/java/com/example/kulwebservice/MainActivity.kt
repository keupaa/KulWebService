package com.example.kulwebservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kulwebservice.api.ApiConfig
import com.example.kulwebservice.api.response.StatusResponse
import com.example.kulwebservice.api.response.WebinarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
        insertData(
            "5123",
            "taufik",
            "laki-laki",
            "informatika"
        )
    }

    private fun getData(){
        val client = ApiConfig.getService().getWebinar()
        client.enqueue(object : Callback<WebinarResponse>{
            override fun onResponse(
                call: Call<WebinarResponse>,
                response: Response<WebinarResponse>
            ) {
                Log.e(TAG, response.body().toString())
            }

            override fun onFailure(call: Call<WebinarResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private fun insertData(
        nim: String,
        nama: String,
        jenisKelamin: String,
        prodi: String
    ){
        val client = ApiConfig.getService().insertWebinar(nim, nama, jenisKelamin, prodi)
        client.enqueue(object : Callback<StatusResponse>{
            override fun onResponse(
                call: Call<StatusResponse>,
                response: Response<StatusResponse>
            ) {
                Log.e(TAG, response.body().toString())
            }

            override fun onFailure(call: Call<StatusResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}