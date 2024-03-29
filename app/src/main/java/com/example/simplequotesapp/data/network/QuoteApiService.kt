package com.example.simplequotesapp.data.network

import com.example.simplequotesapp.data.model.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiService {


    @GET("random")
    suspend fun getRandomQuotes() : Quotes

}