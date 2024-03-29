package com.example.simplequotesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplequotesapp.data.model.Quotes
import com.example.simplequotesapp.data.network.RetrofitService
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    private val apiService = RetrofitService.getRetrofitInterface()

    private val _quote = MutableLiveData<Quotes>()
    val quote : LiveData<Quotes>
        get() = _quote

    init {
        fetchRandomQuotes()
    }

    private fun fetchRandomQuotes(){
        viewModelScope.launch {
            try {
                val randomQuote = apiService.getRandomQuotes()
                _quote.value = randomQuote
            } catch (e : Exception){
                println("Error fetching quote: ${e.message}")
            }
        }
    }
}