package com.example.wisata_malang.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Vacation(
    @SerializedName("caption")
    val caption: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null
): Parcelable