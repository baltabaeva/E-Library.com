package com.example.e_library.model

import com.example.e_library.R

data class Books(
    val id: Int,
    val titleResourceId: Int,
    val subTitleResourceId: Int,
    val imageResourceId: Int,
    val sportsImageBanner: Int,
    val newsDetails: Int = R.string.annotation_text
)
