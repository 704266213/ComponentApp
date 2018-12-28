package com.component.base.base

import com.component.base.http.loading.OnLoadingViewListener
import com.component.base.http.response.BaseResponseCallBack
import com.component.base.http.response.listener.OnResponseListener

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/13 13:48
 * 修改人：admin
 * 修改时间：2018/12/13 13:48
 * 修改备注：
 * @version
 */
class BasePresenter<out S, T>(private val httpService: IHttpService<S>, private val onResponseListener: OnResponseListener<T>) {

//    var call: Call<BaseModel<T>>? = null
//    var onLoadingViewListener: OnLoadingViewListener? = null
//    var retrofit: IRetrofit? = null

    fun startRequest(callPresenter: ICallPresenter<S, T>) {
        startRequest(callPresenter, null)
    }


    private fun startRequest(callPresenter: ICallPresenter<S, T>, onLoadingViewListener: OnLoadingViewListener?) {

        val apiService = httpService.createHttpService()
        val call = callPresenter.buildCall(apiService)
        val callBack = BaseResponseCallBack(onLoadingViewListener, onResponseListener)
        call?.enqueue(callBack)

    }


}