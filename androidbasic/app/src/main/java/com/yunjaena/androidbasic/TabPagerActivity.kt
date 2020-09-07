package com.yunjaena.androidbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)
        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))
    }
}


class PagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Fragment1()
            }
            1 -> {
                return Fragment2()
            }
            2 -> {
                return Fragment3()
            }
            else -> {
                return Fragment1()
            }
        }
    }


    override fun getCount(): Int {
        return tabCount
    }

}