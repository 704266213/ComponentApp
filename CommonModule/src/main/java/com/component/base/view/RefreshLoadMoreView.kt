package com.component.base.view.base

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/12/19 10:06
 * 修改人：admin
 * 修改时间：2017/12/19 10:06
 * 修改备注：
 * @version
 */
interface RefreshLoadMoreView<out E, in T : List<E>> : LoadMoreView<E, T> {

    fun isRefreshing(): Boolean

    fun refreshComplete()

    fun onRefreshSuccess()

}