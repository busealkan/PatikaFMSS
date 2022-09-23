package com.busealkan.marsapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.busealkan.marsapp.data.MarsModelItem
import com.busealkan.marsapp.data.repository.MarsRepository
import com.busealkan.marsapp.util.ResourceStatus
import kotlinx.coroutines.launch

//ListViewModel sınıfı ViewModel’den türetilmiştir.
class ListViewModel : ViewModel() {

    //MarsRepository türünde değişken oluşturulmuştur.
    private val listRepository: MarsRepository = MarsRepository()

    //Constructor fonksiyondur. ListViewModel oluşturulduğunda çalıştırılacaktır.
    init {
        getMars()
    }

    /*
        3 tane live data var. Bunlar error, loading, tüm verilerin tutulduğu veridir.
        Bunları fragment dinleyecektir.
     */
    var loading: MutableLiveData<Boolean>? = MutableLiveData()
    var marsLiveData = MutableLiveData<List<MarsModelItem>>()
    var error = MutableLiveData<Throwable>()

    //İlgili istek atılacaktır.
    fun getMars() = viewModelScope.launch {

        //listRepository’den alıp durumuna bakacak ve durumuna göre
        listRepository.getMars()

            //Coroutine ile istekleri dinliyor.
            .asLiveData(viewModelScope.coroutineContext).observeForever {

                //Durumuna göre
                when (it.status) {

                    //Durumu loading ise, loadingi post edecek.
                    ResourceStatus.LOADING -> {
                        loading?.postValue(true)
                    }

                    //Durumu success ise, tüm verilerin live datasını post edecek ve loadingi durduracaktır.
                    ResourceStatus.SUCCESS -> {
                        marsLiveData.postValue(it.data!!)
                        loading?.postValue(false)
                    }

                    //Durumu error ise, error live datasını post edecek, loadingi durduracak ve error basacaktır.
                    ResourceStatus.ERROR -> {
                        error.postValue(it.throwable!!)
                        loading?.postValue(false)
                    }
                }
            }
    }
}

