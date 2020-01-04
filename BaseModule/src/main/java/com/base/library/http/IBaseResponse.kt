package com.base.library.http

interface IBaseResponse<in T> {

    fun onSuccess(entity: T?)

    fun onFailure(errorCode: Int, errorInfo: String?)

}