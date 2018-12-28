package com.component.base.base

import com.component.base.api.ApiService

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/13 16:28
 * 修改人：admin
 * 修改时间：2018/12/13 16:28
 * 修改备注：
 * @version
 */
class HttpService(private val retrofit: IRetrofit) : IHttpService<ApiService> {

    override fun createHttpService(): com.component.base.api.ApiService {
        val retrofit = retrofit.createRetrofit()
        return retrofit.create(ApiService::class.java)
    }
}