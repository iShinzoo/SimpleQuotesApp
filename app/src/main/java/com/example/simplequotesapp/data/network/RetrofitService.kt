package com.example.simplequotesapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {

    companion object {

        fun getRetrofitInterface(): QuoteApiService {
            val BASE_URL = "https://api.quotable.io/"
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(QuoteApiService::class.java)
        }
    }
}

