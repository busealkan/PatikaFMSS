package com.busealkan.marsapp

//Tıklanma işlemi gerçekleştiğinde yapılacak işlem için oluşturulmuş interfacedir.
interface ItemClickListener {
    fun onItemClick(position: Int)
}