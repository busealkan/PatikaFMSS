package com.busealkan.marsapp

import android.widget.ImageView
import com.bumptech.glide.Glide

/*
    Her yerden erişilebilen dönüş değeri olmayan loadFromUrl adında bir fonksiyon
    oluşturulmuştur. ImageView için kullanılan genişletilmiş bir fonksiyondur.
 */

fun ImageView.loadFromUrl(url: String?) {
    url?.let {
        Glide.with(this.context) //Hangi contexte gösterileceği
            .load(url) //Hangi urlnin kullanılacağı
            .error(R.drawable.interneticon) //Error verdiğinde hangi resmin kullanılacağı
            .centerCrop() //Resmi ortalayarak keser
            .into(this) //Yüklenilen resmin nerede gösterileceği
    }
}

