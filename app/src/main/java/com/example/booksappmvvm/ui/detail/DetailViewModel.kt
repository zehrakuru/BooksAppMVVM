package com.example.booksappmvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booksappmvvm.data.model.BookDetail
import com.example.booksappmvvm.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val booksRepository: BooksRepository) : ViewModel() {

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