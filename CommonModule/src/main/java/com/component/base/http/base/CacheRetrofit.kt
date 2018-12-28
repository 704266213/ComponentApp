package com.component.base.base

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/13 16:32
 * 修改人：admin
 * 修改时间：2018/12/13 16:32
 * 修改备注：
 * @version
 */
class CacheRetrofit(private var okHttpClient: IOkHttpClient) : IRetrofit {

    override fun createRetrofit(): Retrofit = Retrofit.Builder()
            //设置OKHttpClient,如果不设置会提供一个默认的
            .client(okHttpClient.createOkHttpClient())
            //设置baseUrl
            .baseUrl("https://raw.githubusercontent.com/704266213/")
            //添加fastJson转换器
            .addConverterFactory(GsonConverterFactory.create())
            .build()


}