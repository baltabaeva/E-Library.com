/*
 * Copyright (c) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.sports.data
import com.example.e_library.R
import com.example.e_library.model.Books

/**
 * Sports data
 */
object BooksData{
    fun getSportsData(): ArrayList<Books> {
        return arrayListOf(
            Books(
                id = 1,
                titleResourceId = R.string.book1,
                subTitleResourceId = R.string.baseball_subtitle,
                imageResourceId = R.drawable.img1,
                sportsImageBanner = R.drawable.img1
            ),
            Books(
                id = 2,
                titleResourceId = R.string.book2,
                subTitleResourceId = R.string.baseball_subtitle,
                imageResourceId = R.drawable.img2,
                sportsImageBanner = R.drawable.img2
            ),
            Books(
                id = 3,
                titleResourceId = R.string.book3,
                subTitleResourceId = R.string.baseball_subtitle,
                imageResourceId = R.drawable.img3,
                sportsImageBanner = R.drawable.img3
            ),
            Books(
                id = 4,
                titleResourceId = R.string.book4,
                subTitleResourceId = R.string.baseball_subtitle,
                imageResourceId = R.drawable.img4,
                sportsImageBanner = R.drawable.img4
            ),
            Books(
                id = 5,
                titleResourceId = R.string.book5,
                subTitleResourceId = R.string.baseball_subtitle,
                imageResourceId = R.drawable.img5,
                sportsImageBanner = R.drawable.img5
            ),
            Books(
                id = 6,
                titleResourceId = R.string.book6,
                subTitleResourceId = R.string.baseball_subtitle,
                imageResourceId = R.drawable.img6,
                sportsImageBanner = R.drawable.img6
            ),
            Books(
                id = 7,
                titleResourceId = R.string.book7,
                subTitleResourceId = R.string.baseball_subtitle,
                imageResourceId = R.drawable.img7,
                sportsImageBanner = R.drawable.img7
            )
        )
    }
}
