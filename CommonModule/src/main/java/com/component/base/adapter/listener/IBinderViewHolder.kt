package com.component.base.adapter.listener

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * 项目名称：MVP
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/11/27 16:52
 * 修改人：admin
 * 修改时间：2018/11/27 16:52
 * 修改备注：
 * @version
 */
interface IBinderViewHolder<T : RecyclerView.ViewHolder> {

    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): T

    fun onBindViewHolder(holder: T?, position: Int)
}