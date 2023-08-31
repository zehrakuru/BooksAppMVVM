package com.example.booksappmvvm.data.model


import com.google.gson.annotations.SerializedName

data class BookDetail(
    val author: String?,
    val id: Int?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("is_best_seller") val isBestSeller: Boolean?,
    val name: String?,
    val price: Double?,
    val publisher: String?
)