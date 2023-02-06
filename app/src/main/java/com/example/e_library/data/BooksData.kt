package com.example.e_library.data
import com.example.e_library.R
import com.example.e_library.model.Books


object BooksData{
    fun getBooksData(): ArrayList<Books> {
        return arrayListOf(

            Books(
                id = 8,
                titleResourceId = R.string.book8,
                subTitleResourceId = R.string.b1_subtitle,
                imageResourceId = R.drawable.img8,
                booksImageBanner = R.drawable.img8
            ),
            Books(
                id = 9,
                titleResourceId = R.string.book9,
                subTitleResourceId = R.string.b2_subtitle,
                imageResourceId = R.drawable.img9,
                booksImageBanner = R.drawable.img9
            ),
            Books(
                id = 10,
                titleResourceId = R.string.book10,
                subTitleResourceId = R.string.b3_subtitle,
                imageResourceId = R.drawable.img10,
                booksImageBanner = R.drawable.img10
            ),
            Books(
                id = 11,
                titleResourceId = R.string.book11,
                subTitleResourceId = R.string.b4_subtitle,
                imageResourceId = R.drawable.img11,
                booksImageBanner = R.drawable.img11
            ),
            Books(
                id = 12,
                titleResourceId = R.string.book15,
                subTitleResourceId = R.string.b5_subtitle,
                imageResourceId = R.drawable.img15,
                booksImageBanner = R.drawable.img15
            ),
            Books(
                id = 13,
                titleResourceId = R.string.book13,
                subTitleResourceId = R.string.b6_subtitle,
                imageResourceId = R.drawable.img13,
                booksImageBanner = R.drawable.img13
            ),
            Books(
                id = 14,
                titleResourceId = R.string.book14,
                subTitleResourceId = R.string.b7_subtitle,
                imageResourceId = R.drawable.img14,
                booksImageBanner = R.drawable.img14
            )
        )
    }
}
