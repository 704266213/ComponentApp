package com.component.base.widget.loadmore

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.component.base.http.listener.OnStartRequestListener
import com.component.base.http.loading.OnLoadingViewListener


class StaggeredLoadMoreScollerListener(onLoadingViewListener: OnLoadingViewListener, onStartRequestListener: OnStartRequestListener) : OnLoadMoreScrollListener(onLoadingViewListener,onStartRequestListener) {

    /**
     * 最后一个的位置
     */
    private var lastPositions: IntArray? = null

    override fun getLastVisibleItemPosition(recyclerView: RecyclerView?): Int {
        val layoutManager = recyclerView!!.layoutManager
        val staggeredGridLayoutManager = layoutManager as StaggeredGridLayoutManager
        if (lastPositions != null) {
            lastPositions = IntArray(staggeredGridLayoutManager.spanCount)
        }
        staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions)
        return findMax(lastPositions)
    }

    private fun findMax(lastPositions: IntArray?): Int {
        var max = lastPositions!![0]
        for (value in lastPositions) {
            if (value > max) {
                max = value
            }
        }
        return max
    }

}
