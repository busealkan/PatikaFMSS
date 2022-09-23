package com.busealkan.marsapp.data.datasource

import com.busealkan.marsapp.data.MarsModelItem
import com.busealkan.marsapp.util.Resource
import kotlinx.coroutines.flow.Flow

//getMars fonksiyonu flow yapısında resource döndürüyor. İçerisinde ise MarsModelItem vardır.

interface MarsDataSource {
    fun getMars(): Flow<Resource<List<MarsModelItem>>>
}