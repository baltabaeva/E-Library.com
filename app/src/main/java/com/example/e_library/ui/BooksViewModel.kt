package com.example.e_library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.sports.data.BooksData
import com.example.e_library.model.Books

class BooksViewModel : ViewModel() {

    private var _currentSport: MutableLiveData<Books> = MutableLiveData<Books>()
    val currentSport: LiveData<Books>
        get() = _currentSport

    private var _sportsData: ArrayList<Books> = ArrayList()
    val sportsData: ArrayList<Books>
        get() = _sportsData

    init {
        // Initialize the sports data.
        _sportsData = BooksData.getSportsData()
        _currentSport.value = _sportsData[0]
    }

    fun updateCurrentSport(sport: Books) {
        _currentSport.value = sport
    }
}