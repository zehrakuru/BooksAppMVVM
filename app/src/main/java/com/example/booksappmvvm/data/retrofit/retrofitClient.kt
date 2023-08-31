package com.example.booksappmvvm.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.booksappmvvm.common.Constants.BASE_URL
import com.example.booksappmvvm.data.source.BookService

class retrofitClient {
    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookService::class.java)
    }
}