package com.example.booksappmvvm.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.booksappmvvm.common.loadImage
import com.example.booksappmvvm.data.model.Book
import com.example.booksappmvvm.data.model.BookDetail
import com.example.booksappmvvm.data.model.GetBookDetailResponse
import com.example.booksappmvvm.data.model.GetBookResponse
import com.example.booksappmvvm.data.retrofit.retrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository {

    val booksLiveData = MutableLiveData<List<Book>?>()
    val bookDetailLiveData = MutableLiveData<BookDetail?>()
    val errorMessageLiveData = MutableLiveData<String>()

    fun getBooks() {
        retrofitClient.retrofit.getAllBooks().enqueue(object: Callback<GetBookResponse> {
            override fun onResponse(
                call: Call<GetBookResponse>,
                response: Response<GetBookResponse>
            ) {
                val getAllBooks = response.body()?.books
                if(getAllBooks.isNullOrEmpty().not()) {
                    booksLiveData.value = getAllBooks
                } else {
                    booksLiveData.value = null
                }
            }

            override fun onFailure(call: Call<GetBookResponse>, t: Throwable) {
                errorMessageLiveData.value = t.message.orEmpty()
                Log.e("getAllBooks", t.message.orEmpty())
            }

        })
    }

    fun getBookDetail(id : Int) {
        retrofitClient.retrofit.getBookDetail(id).enqueue(object : Callback<GetBookDetailResponse> {
            override fun onResponse(
                call: Call<GetBookDetailResponse>,
                response: Response<GetBookDetailResponse>
            ) {
                bookDetailLiveData.value = response.body()?.book
            }

            override fun onFailure(call: Call<GetBookDetailResponse>, t: Throwable) {
                errorMessageLiveData.value = t.message.orEmpty()
                Log.e("GetDetailBook", t.message.orEmpty())
            }

        })
    }
}