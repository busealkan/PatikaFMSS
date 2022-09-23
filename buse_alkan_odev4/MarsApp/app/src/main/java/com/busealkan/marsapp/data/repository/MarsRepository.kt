package com.busealkan.marsapp.data.repository

import com.busealkan.marsapp.data.MarsModelItem
import com.busealkan.marsapp.data.datasource.MarsDataSource
import com.busealkan.marsapp.data.datasource.remote.RemoteMarsDataSource
import com.busealkan.marsapp.util.Resource
import kotlinx.coroutines.flow.Flow

class MarsRepository {

    //MarsDataSource’dan türetilmiş değeri null
    private var marsDataSource: MarsDataSource? = null

    init {
        /*
            Constructor’da data source ayağa kaldırılıyor.
            Ne türde olacağını belirtiliyor(Remote, Locale).
         */
        marsDataSource = RemoteMarsDataSource()
    }

    //İlgili data source(MarsDataSource) alıyor ve verileri döndürüyor.
    fun getMars(): Flow<Resource<List<MarsModelItem>>> {
        return marsDataSource!!.getMars()
    }

}
