package com.example.coffee.service

import com.example.coffee.models.Coffee
import com.example.coffee.models.CoffeeItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CoffeeService {
    @GET("coffee/hot")
    suspend fun getResults(): Response<ArrayList<CoffeeItem>>


   companion object {
       var retrofit: Retrofit? = null
      private const val BASE_URL = "http://api.sampleapis.com/"
        fun getRetrofit(): CoffeeService {
            if(retrofit==null){

           retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            }
       return retrofit!!.create(CoffeeService::class.java)
        }
    }

}