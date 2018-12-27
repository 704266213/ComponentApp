package com.component.base.tools

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.util.Log

/**
 * 项目名称：ComponentApp
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/27 11:10
 * 修改人：admin
 * 修改时间：2018/12/27 11:10
 * 修改备注：
 * @version
 */

object ScreenTool {

    fun getScreenInfo(activity: Activity) {
        val dm = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        val heightPixels = dm.heightPixels
        val widthPixels = dm.widthPixels
        val density = dm.density;
        val heightDP = heightPixels / density
        val widthDP = widthPixels / density

        Log.e("XLog", "========屏幕宽度=============: $widthDP")
        Log.e("XLog", "========屏幕高度=============: $heightDP")

        var smallestWidthDP = if (widthDP < heightDP) {
            widthDP
        } else {
            heightDP
        }

        Log.e("XLog", "=====================: $smallestWidthDP")
    }
}