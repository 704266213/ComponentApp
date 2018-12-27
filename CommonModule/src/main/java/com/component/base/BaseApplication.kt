package com.component.base

import android.app.Application

/**
 * 项目名称：ComponentApp
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/25 16:48
 * 修改人：admin
 * 修改时间：2018/12/25 16:48
 * 修改备注：
 * @version
 */
abstract class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        initApplication()
    }

    abstract fun initApplication()
}