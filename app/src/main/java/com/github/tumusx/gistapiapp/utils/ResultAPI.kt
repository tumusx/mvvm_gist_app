package com.github.tumusx.gistapiapp.utils

sealed class ResultAPI<T> (val dataResult: T? = null, val messageError: String? = null){
    class SuccessRequest<T>(dataResult: T) : ResultAPI<T>(dataResult)
    class FailureRequest<T>(dataResult: T? = null, messageError: String?) : ResultAPI<T>(dataResult, messageError)
}