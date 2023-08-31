package com.example.booksappmvvm.data.source

import retrofit2.Call
import retrofit2.http.GET
import com.example.booksappmvvm.common.Constants.Endpoint.GET_ALL_BOOKS
import com.example.booksappmvvm.common.Constants.Endpoint.GET_BOOKS_DETAIL
import com.example.booksappmvvm.data.model.GetBookDetailResponse
import com.example.booksappmvvm.data.model.GetBookResponse
import retrofit2.http.Query


interface BookService {
    @GET(GET_ALL_BOOKS)
    fun getAllBooks(): Call<GetBookResponse>

    @GET(GET_BOOKS_DETAIL)
    fun getBookDetail(
        @Query("id") id: Int
    ): Call<GetBookDetailResponse>
}