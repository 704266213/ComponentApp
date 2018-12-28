package com.component

import com.alibaba.android.arouter.launcher.ARouter
import com.component.base.BaseApplication

/**
 * 项目名称：ComponentApp
 * 类描述：
 * 创建人：admin
 * 创建时间：2018/12/25 17:27
 * 修改人：admin
 * 修改时间：2018/12/25 17:27
 * 修改备注：
 * @version
 */
class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.ISBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//            ARouter.printStackTrace()
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化

        //内存泄漏检测
//        LeakCanary.install(this)
    }

    override fun initApplication() {

    }
}