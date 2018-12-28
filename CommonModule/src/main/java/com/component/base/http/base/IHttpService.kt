package com.component.base.base

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/13 16:25
 * 修改人：admin
 * 修改时间：2018/12/13 16:25
 * 修改备注：
 * @version
 */
interface IHttpService<out T> {

    fun createHttpService(): T

}