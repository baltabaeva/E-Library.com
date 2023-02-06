package com.example.e_library.ui.genres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_library.data.GenresData
import com.example.e_library.model.Genres

class GenresViewModel : ViewModel() {

    private var _currentGenres: MutableLiveData<Genres> = MutableLiveData<Genres>()
    val currentGenre: LiveData<Genres>
        get() = _currentGenres

    private var _sportsData: ArrayList<Genres> = ArrayList()
    val genresData: ArrayList<Genres>
        get() = _sportsData

    init {

        _sportsData = GenresData.getGenresData()
        _currentGenres.value = _sportsData[0]
    }

    fun updateCurrentGenres(genres: Genres) {
        _currentGenres.value = genres
    }
}