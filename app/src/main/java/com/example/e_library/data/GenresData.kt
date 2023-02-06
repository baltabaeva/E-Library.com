package com.example.e_library.data


import com.example.e_library.R
import com.example.e_library.model.Genres


object GenresData{
    fun getGenresData(): ArrayList<Genres> {
        return arrayListOf(
            Genres(
                id = 1,
                titleResourceId = R.string.adventure,
                imageResourceId = R.drawable.adventure,
                titleBook = R.string.book9,
                genresImageBanner = R.drawable.img9
            ),
            Genres(
                id = 2,
                titleResourceId = R.string.Children,
                imageResourceId = R.drawable.children,
                titleBook = R.string.book15,
                genresImageBanner = R.drawable.img15
            ),
            Genres(
                id = 3,
                titleResourceId = R.string.Detective,
                imageResourceId = R.drawable.detective,
                titleBook = R.string.book13,
                genresImageBanner = R.drawable.img13
            ),
            Genres(
                id = 4,
                titleResourceId = R.string.Fantasy,
                imageResourceId = R.drawable.fantasy,
                titleBook = R.string.book8,
                genresImageBanner = R.drawable.img8
            ),
            Genres(
                id = 5,
                titleResourceId = R.string.Horror,
                imageResourceId = R.drawable.horror,
                titleBook = R.string.book11,
                genresImageBanner = R.drawable.img11
            ),
            Genres(
                id = 6,
                titleResourceId = R.string.Psychology,
                imageResourceId = R.drawable.psychology,
                titleBook = R.string.book14,
                genresImageBanner = R.drawable.img14
            ),
            Genres(
                id = 7,
                titleResourceId = R.string.Romance,
                imageResourceId = R.drawable.novel,
                titleBook = R.string.book10,
                genresImageBanner = R.drawable.img10
            ),

        )
    }
}
