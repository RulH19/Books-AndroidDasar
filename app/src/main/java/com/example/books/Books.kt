package com.example.books

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


//data class buat ngirim data pake parcelable
@Parcelize
data class Books(
    val name: String,
    val description: String,
    val photo: Int
):Parcelable
