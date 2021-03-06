package com.component.base.widget.loadmore

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.component.base.http.listener.OnStartRequestListener

import com.component.base.http.loading.OnLoadingViewListener


class LinearLoadMoreListener(onLoadingViewListener: OnLoadingViewListener, onStartRequestListener: OnStartRequestListener) : OnLoadMoreScrollListener(onLoadingViewListener,onStartRequestListener) {

    override fun getLastVisibleItemPosition(recyclerView: RecyclerView?): Int {
        val layoutManager = recyclerView!!.layoutManager
        var lastVisibleItemPosition = -1
        if (layoutManager != null) {
            lastVisibleItemPosition = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        }
        return lastVisibleItemPosition
    }

}
