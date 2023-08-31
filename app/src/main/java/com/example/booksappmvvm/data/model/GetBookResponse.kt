package com.example.booksappmvvm.data.model

data class GetBookResponse(
    val success:Int?,
    val message:String?,
    val books:List<Book>?
)
