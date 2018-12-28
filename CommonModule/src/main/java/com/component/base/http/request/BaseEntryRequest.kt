package com.component.base.http.request

import com.component.base.adapter.listener.AddDataToAdapterListener
import com.component.base.api.ApiService
import com.component.base.http.response.listener.OnResponseListener
import com.component.base.http.retrofit.BaseRetrofit

/**
 * 项目名称：MVP
 * 类描述：用于处理返回的结果为数组对象的情况
 * 创建人：admin
 * 创建时间：2017/12/14 9:12
 * 修改人：admin
 * 修改时间：2017/12/14 9:12
 * 修改备注：
 * @version
 */
class BaseEntryRequest<out E, in T : List<E>>(private var onResponseListener: OnResponseListener<T>?, private var addDataToAdapterListener: AddDataToAdapterListener<E>) : OnResponseListener<T> {

    fun createApiService(baseRetrofit: BaseRetrofit): ApiService {
        val retrofit = baseRetrofit.createRetrofit()
        return retrofit.create(ApiService::class.java)
    }

    override fun onSuccess(entity: T?) {
        onResponseListener?.onSuccess(entity)
        var list: List<E> = entity as List<E>
        addDataToAdapterListener.addDataToList(list)
    }

    override fun onFailure(errorInfo: String?) {
        onResponseListener?.onFailure(errorInfo)
    }

    override fun onDestroy() {
        onResponseListener = null
    }

}