package com.component.hotmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.component.base.BaseFragment

/**
 * 项目名称：ComponentApp
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/27 11:43
 * 修改人：admin
 * 修改时间：2018/12/27 11:43
 * 修改备注：
 * @version
 */
@Route(path = "/hot/fragment")
class HotFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hot, container, false)
    }


}