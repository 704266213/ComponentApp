package com.component.base.base

import android.util.Log
import com.component.base.api.ApiService
import com.component.base.http.response.listener.OnResponseListener
import com.component.base.model.BaseModel
import retrofit2.Call

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/13 16:50
 * 修改人：admin
 * 修改时间：2018/12/13 16:50
 * 修改备注：
 * @version
 */
//class LoginPresenter : OnResponseListener<UserInfoModel>, ICallPresenter<ApiService, UserInfoModel> {
//
//
//    override fun buildCall(apiService: ApiService): Call<BaseModel<UserInfoModel>>? {
//        return apiService.getUserInfo("userinfo.json")
//    }
//
//
//    fun login() {
//
//        val cacheOkHttpClient = CacheOkHttpClient()
//        val cacheRetrofit = CacheRetrofit(cacheOkHttpClient)
//        val httpService = HttpService(cacheRetrofit)
//
//        val basePresenter = BasePresenter(httpService, this)
//
//        basePresenter.startRequest(this)
//
//    }
//
//
//    override fun onSuccess(entity: UserInfoModel?) {
//        if (entity != null) {
//            Log.e("XLog", "{  userName：${entity.userName},  sex : ${entity.sex},  headUrl: ${entity.headUrl} }")
//        }
//    }
//
//    override fun onFailure(errorInfo: String?) {
//
//    }
//
//    override fun onDestroy() {
//
//    }
//
//}