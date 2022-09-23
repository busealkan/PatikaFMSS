package com.busealkan.marsapp.data.datasource.remote

import com.busealkan.marsapp.data.MarsModelItem
import com.busealkan.marsapp.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MarsService {

    //Get isteği ile https://mars.udacity.com/realestate adresine istek atacaktır.
    @GET(Constants.JSON_REALESTATE)

    //Sonucunda MarsModelItem dönüyor. Response türünde metod ismi getMars istendiği söyleniliyor.
    suspend fun getMars(): Response<List<MarsModelItem>>

    companion object {

        fun build(): MarsService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            //Clienti okHttp tanımlandı, interceptorına ‘interceptor’ set edildi.
            val okHtppClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            //okHttp ile retrofiti kurup set ettik.
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHtppClient) //clienti okHttp’den
                .build()

            //Retrofiti oluşturduk, service kendisi dendi ve onu döndürdü.
            return retrofit.create(MarsService::class.java)

            //Build dediğimizde bu service de istediğimiz service atanılabilir.
        }
    }
}