package com.example.kulwebservice.api

//sesuaikan dengan folder atau class yang kalian buat
import com.example.kulwebservice.api.response.StatusResponse
import com.example.kulwebservice.api.response.WebinarResponse

//import dari library retrofit
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("read.php")
    fun getWebinar(): Call<WebinarResponse>

    @FormUrlEncoded
    @POST("create.php")
    fun insertWebinar(
        @Field("nim") nim: String,
        @Field("nama") nama: String,
        @Field("jenis_kelamin") jenisKelamin: String,
        @Field("prodi") prodi: String,
    ): Call<StatusResponse>
}