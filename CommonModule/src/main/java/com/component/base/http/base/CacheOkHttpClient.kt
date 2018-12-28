package com.component.base.base

import com.component.base.BuildConfig
import com.component.base.http.interceptor.HttpLoggingInterceptor
import com.component.base.http.interceptor.NativeCacheInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/13 16:52
 * 修改人：admin
 * 修改时间：2018/12/13 16:52
 * 修改备注：
 * @version
 */
class CacheOkHttpClient : IOkHttpClient {

    //请求超时时间
    private val timeOut: Long = 30
    private val interceptor = HttpLoggingInterceptor()

    init {
        val level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        interceptor.setLevel(level)
    }


    override fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(NativeCacheInterceptor(30))
            .retryOnConnectionFailure(true)
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .build()
}