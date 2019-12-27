package net.adrote.toolboxtest.api

import android.util.Log
import net.adrote.toolboxtest.ui.model.Authorization
import net.adrote.toolboxtest.ui.model.Data
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface ApiClient {
    companion object {
        private const val BASE_URL = "https://echo-serv.tbxnet.com"

        fun create(): ApiClient {

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()


            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiClient::class.java)
        }
    }

    @POST("/v1/mobile/auth")
    suspend fun signIn(@Body auth:AuthRequest): Response<Authorization>

    @GET("/v1/mobile/data")
    suspend fun getData(@Header("Authorization") auth:String): Response<List<Data>>
}