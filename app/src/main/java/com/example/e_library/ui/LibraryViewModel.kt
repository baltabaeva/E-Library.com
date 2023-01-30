package com.example.e_library

import com.example.e_library.data.BooksData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_library.data.BooksData2
import com.example.e_library.model.Books

class LibraryViewModel : ViewModel() {

    private var _currentBook: MutableLiveData<Books> = MutableLiveData<Books>()
    val currentBook: LiveData<Books>
        get() = _currentBook

    private var _booksData: ArrayList<Books> = ArrayList()
    val booksData: ArrayList<Books>
        get() = _booksData

    init {
        _booksData = BooksData.getBooksData()
        _currentBook.value = _booksData[0]
    }

    fun updateCurrentBook(book: Books) {
        _currentBook.value = book
    }
}