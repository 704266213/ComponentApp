package com.component.base.base

import okhttp3.OkHttpClient

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/13 16:12
 * 修改人：admin
 * 修改时间：2018/12/13 16:12
 * 修改备注：
 * @version
 */
interface IOkHttpClient {

    fun createOkHttpClient(): OkHttpClient

}