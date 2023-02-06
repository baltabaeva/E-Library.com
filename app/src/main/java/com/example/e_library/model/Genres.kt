package com.example.e_library.model

import com.example.e_library.R

data class Genres(
    val id: Int,
    val titleResourceId: Int,
    val titleBook: Int,
    val imageResourceId: Int,
    val genresImageBanner: Int,
    val genresDetails: Int = R.string.annotation_text
)
