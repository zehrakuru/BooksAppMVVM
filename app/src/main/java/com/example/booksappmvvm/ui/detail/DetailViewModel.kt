package com.example.booksappmvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booksappmvvm.data.model.BookDetail
import com.example.booksappmvvm.data.repository.BooksRepository

class DetailViewModel : ViewModel() {

    private val booksRepository = BooksRepository()

    private var _bookDetailLiveData = MutableLiveData<BookDetail?>()
    val bookDetailLiveData: LiveData<BookDetail?>
        get() = _bookDetailLiveData

    private var _errorMessageLiveData = MutableLiveData<String>()
    val errorMessageLiveData: LiveData<String>
        get() = _errorMessageLiveData

    init {
        _bookDetailLiveData = booksRepository.bookDetailLiveData
        _errorMessageLiveData = booksRepository.errorMessageLiveData
    }

    fun getBookDetail(id : Int) {
        booksRepository.getBookDetail(id)
    }
}