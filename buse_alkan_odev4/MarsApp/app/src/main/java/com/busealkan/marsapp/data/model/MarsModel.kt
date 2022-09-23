package com.busealkan.marsapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*
    https://mars.udacity.com/realestate adresinde bulunan verileri kullanabilmemiz için gerekli sınıfların
    oluşturulduğu sınıftır.
 */

@Parcelize
data class MarsModelItem(
    val price: Int,
    val id: String,
    val type: String,
    val img_src: String
) : Parcelable