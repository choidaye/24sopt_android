package com.choidaye.cardview.Fragment


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){


    override fun getItem(position: Int): Fragment {

        if (position ==0){
            return MyFragment()
        }
        else if( position == 1){
            return MyPointFragment()
        }

        else{
            return MyFragment()
        }
    }

    override fun getCount(): Int {

        return 3
    }


}