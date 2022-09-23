package com.busealkan.marsapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo;

/*
    Her yerden erişilebilen NetworkUtil adında bir obje oluşturulmuştur.
    İnternet kontrolü yapar. Eğer internet var ise true yok ise false döner.
*/
object NetworkUtil {
    fun isThereInternet(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return if (networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected) {
            true
        } else {
            false
        }
    }
}