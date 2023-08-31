package com.example.booksappmvvm.data.model

data class GetBookDetailResponse(
    val book: BookDetail?,
    val message: String?,
    val success: Int?
)
