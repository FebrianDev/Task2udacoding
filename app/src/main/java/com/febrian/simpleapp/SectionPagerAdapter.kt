package com.febrian.simpleapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val TAB_TITLES = arrayListOf<String>("Luas", "Volume")

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment? = null

        when(position){
            0 -> fragment = LuasFragment()
            1 -> fragment = VolumeFragment()
        }

        return fragment as Fragment
    }

}