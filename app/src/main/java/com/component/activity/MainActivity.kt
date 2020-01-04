package com.component.activity

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.RadioButton
import com.component.R
import com.component.base.tools.ScreenTool
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.component.BuildConfig
import com.component.base.BaseFragment
import com.alibaba.android.arouter.launcher.ARouter
import com.component.base.config.RouteConfig


class MainActivity : AppCompatActivity() {

    private var mExitTime: Long = 0

    private var currentIndex = 0
    private lateinit var radioButtons: List<RadioButton>
    private var routePaths = mutableListOf(
        RouteConfig.HomeFragment,
        RouteConfig.HotFragment,
        RouteConfig.SearchFragment,
        RouteConfig.UserFragment
    )

    private var baseFragments = mutableListOf<BaseFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()
        ScreenTool.getScreenInfo(this)
    }

    private fun initView() {
        radioButtons = mutableListOf(home, hot, search, user)
        var position = 0
        radioButtons.forEachIndexed { index, radioButton ->
            val baseFragment = ARouter.getInstance().build(routePaths[index]).navigation()
            if (baseFragment != null) {
                baseFragments.add(baseFragment as BaseFragment)
                radioButton.setOnClickListener(OnTabClickListener(position++))
            } else {
                radioButton.visibility = View.GONE
            }
        }
        addTabFragment()
    }

    private fun addTabFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        baseFragments.forEachIndexed { index, baseFragment ->
            transaction.add(R.id.container, baseFragment)
            if (index == currentIndex) {
                transaction.show(baseFragment)
            } else {
                transaction.hide(baseFragment)
            }
        }
        transaction.commit()
    }

    fun switchFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.hide(baseFragments[currentIndex])
        currentIndex = index
        transaction.show(baseFragments[currentIndex])
        transaction.commit()
    }


    inner class OnTabClickListener(private val position: Int) : View.OnClickListener {

        override fun onClick(v: View) {
            switchFragment(position)
        }
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
