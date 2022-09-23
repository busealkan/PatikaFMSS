package com.busealkan.marsapp.util

//Farklı türde objeleri tutabilen bir sınıftır.
sealed class Resource<T>(

    //Constructor 3 tane nesne alıyor.
    val data: T?,
    val throwable: Throwable?,
    val status: ResourceStatus
) {
    class Loading<T> : Resource<T>(null, null, ResourceStatus.LOADING)
    class Success<T>(data: T?) : Resource<T>(data, null, ResourceStatus.SUCCESS)
    class Error<T>(exception: Exception) : Resource<T>(null, exception, ResourceStatus.ERROR)
}

//Durumların numaralandırılmasında kullanılması için oluşturulmuştur.
enum class ResourceStatus {
    LOADING,
    SUCCESS,
    ERROR
}
