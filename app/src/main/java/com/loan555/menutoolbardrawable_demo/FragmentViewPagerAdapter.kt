package com.loan555.menutoolbardrawable_demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.loan555.menutoolbardrawable_demo.fragment.AboutFragment
import com.loan555.menutoolbardrawable_demo.fragment.BlankFragment
import com.loan555.menutoolbardrawable_demo.fragment.MainFragment

class FragmentViewPagerAdapter(fm: FragmentManager, var behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {
    override fun getCount(): Int {
        return behavior
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment()
            1 -> AboutFragment()
            else -> BlankFragment()
        }
    }
}