package com.component.base.base

import com.component.base.model.BaseModel
import retrofit2.Call

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/13 15:49
 * 修改人：admin
 * 修改时间：2018/12/13 15:49
 * 修改备注：
 * @version
 */
interface ICallPresenter<in S, T> {

    fun buildCall(apiService: S): Call<BaseModel<T>>?


}