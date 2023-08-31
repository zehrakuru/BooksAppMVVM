package com.example.booksappmvvm.ui.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booksappmvvm.data.model.Book
import com.example.booksappmvvm.data.repository.BooksRepository

class HomeViewModel : ViewModel() {

    private val booksRepository = BooksRepository()

    private var _booksLiveData = MutableLiveData<List<Book>?>()
    val booksLiveData: LiveData<List<Book>?>
        get() = _booksLiveData

    private var _errorMessageLiveData = MutableLiveData<String>()
    val errorMessageLiveData: LiveData<String>
        get() = _errorMessageLiveData

    init {
        _booksLiveData = booksRepository.booksLiveData
        _errorMessageLiveData = booksRepository.errorMessageLiveData
    }

    fun getBooks() {
        booksRepository.getBooks()
    }
}