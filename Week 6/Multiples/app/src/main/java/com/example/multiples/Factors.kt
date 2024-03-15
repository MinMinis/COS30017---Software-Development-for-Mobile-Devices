package com.example.multiples

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Factors (val factor1: Int, val factor2: Int) : Parcelable