package com.gm.carassistance.adapter

import OilFragment
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gm.carassistance.fragment.HazardLightFragment
import com.gm.carassistance.fragment.TrunkFragment

//import com.gm.googleassist.fragment.OilFragment

class ViewPagerAdapter(manager: FragmentManager, context: Context) : FragmentPagerAdapter(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        val args = Bundle()
        when (position) {
            0 -> {
                fragment = OilFragment()
                fragment.arguments = args
            }
            1 -> {
                fragment = HazardLightFragment()
                fragment.arguments = args
            }
            2 -> {
                fragment = TrunkFragment()
                fragment.arguments = args
            }

        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 3
    }
}