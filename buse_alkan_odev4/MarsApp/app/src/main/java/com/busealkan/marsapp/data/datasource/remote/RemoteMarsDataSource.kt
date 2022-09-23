package com.busealkan.marsapp.data.datasource.remote

import com.busealkan.marsapp.data.MarsModelItem
import com.busealkan.marsapp.data.datasource.MarsDataSource
import com.busealkan.marsapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//MarsDataSource’dan türetilmiştir.
class RemoteMarsDataSource : MarsDataSource {

    /*
        MarsDataSource’da bulunan getMars fonksiyonu ezilmiştir.
        Remote ile ilgili dataları verecek olanın içerisinde MarsDataSource’un
        metodu olan getMars bulunmaktadır.
     */

    override fun getMars(): Flow<Resource<List<MarsModelItem>>> = flow {
        try {

            //Önce loadingi başlat
            emit(Resource.Loading())

            //MarsService git, build et, tüm verileri çek
            val response = MarsService.build().getMars()

            //Response doğru ise(doğru isteği attı ve hatasız geldi ise)
            if (response.isSuccessful) {

                //Body boş değil ise
                response.body()?.let {
                    //Git ve onu successe gönder
                    emit(Resource.Success(it))
                }
            }
        }
        //Hata var ise
        catch (e: Exception) {
            //Hatayı gönder
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }

}