package com.example.coba_git

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class user_login(
    val username : String,
    val password: String
):Parcelable
