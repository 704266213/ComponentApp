package com.component.base.http.request

import com.component.base.api.ApiService
import com.component.base.http.response.listener.OnResponseListener
import com.component.base.http.retrofit.BaseRetrofit
import com.component.base.model.BaseModel
import retrofit2.Call

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/12/13 10:59
 * 修改人：admin
 * 修改时间：2017/12/13 10:59
 * 修改备注：
 * @version
 */

//private var onResponseListener: OnResponseListener<T>?
open abstract class BaseEntityRequest<T> {

    var call: Call<BaseModel<T>>? = null

    fun createApiService(baseRetrofit: BaseRetrofit): ApiService {
        val retrofit = baseRetrofit.createRetrofit()
        return retrofit.create(ApiService::class.java)
    }

    fun onDestroy() {
        call?.cancel()
    }

}