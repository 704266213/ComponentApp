package com.component.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.component.R
import com.component.base.tools.ScreenTool
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import com.component.BuildConfig
import com.component.base.BaseFragment
import com.component.model.MainModel
import com.alibaba.android.arouter.launcher.ARouter
import com.component.base.RouteConfig


class MainActivity : AppCompatActivity() {

    private var mExitTime: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()
        ScreenTool.getScreenInfo(this)
    }

    private fun initView() {
        val mainModels = mutableListOf<MainModel>()
        val mainModel = MainModel()
        mainModel.isAddModule = BuildConfig.haseHomeModule
        Log.e("XLog","=======HomeFragment==============${ARouter.getInstance().build(RouteConfig.HomeFragment).navigation()}")
//        mainModel.baseFragment = ARouter.getInstance().build(RouteConfig.HomeFragment).navigation() as BaseFragment
//        mainTab.setOnC

        ARouter.getInstance().build("/user/login").navigation()
    }





    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show()
                mExitTime = System.currentTimeMillis()
            } else {
                finish()
                System.exit(0)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
