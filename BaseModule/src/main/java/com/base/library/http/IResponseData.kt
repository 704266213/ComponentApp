package com.base.library.http

interface IResponseData<T> {

    fun getResponseDataState(): Boolean

    fun getResponseData(entity : T)

}