package com.example.e_library.data
import com.example.e_library.R
import com.example.e_library.model.Books


object BooksData{
    fun getBooksData(): ArrayList<Books> {
        return arrayListOf(
            Books(
                id = 1,
                titleResourceId = R.string.book1,
                subTitleResourceId = R.string.b1_subtitle,
                imageResourceId = R.drawable.img1,
                booksImageBanner = R.drawable.img1
            ),
            Books(
                id = 2,
                titleResourceId = R.string.book2,
                subTitleResourceId = R.string.b2_subtitle,
                imageResourceId = R.drawable.img2,
                booksImageBanner = R.drawable.img2
            ),
            Books(
                id = 3,
                titleResourceId = R.string.book3,
                subTitleResourceId = R.string.b3_subtitle,
                imageResourceId = R.drawable.img3,
                booksImageBanner = R.drawable.img3
            ),
            Books(
                id = 4,
                titleResourceId = R.string.book4,
                subTitleResourceId = R.string.b4_subtitle,
                imageResourceId = R.drawable.img4,
                booksImageBanner = R.drawable.img4
            ),
            Books(
                id = 5,
                titleResourceId = R.string.book5,
                subTitleResourceId = R.string.b5_subtitle,
                imageResourceId = R.drawable.img5,
                booksImageBanner = R.drawable.img5
            ),
            Books(
                id = 6,
                titleResourceId = R.string.book6,
                subTitleResourceId = R.string.b6_subtitle,
                imageResourceId = R.drawable.img6,
                booksImageBanner = R.drawable.img6
            ),
            Books(
                id = 7,
                titleResourceId = R.string.book7,
                subTitleResourceId = R.string.b7_subtitle,
                imageResourceId = R.drawable.img7,
                booksImageBanner = R.drawable.img7
            )
        )
    }
}
