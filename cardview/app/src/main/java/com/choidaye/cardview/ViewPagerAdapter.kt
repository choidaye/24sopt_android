package com.choidaye.cardview


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.choidaye.cardview.Fragment.MyFragment
import com.choidaye.cardview.Fragment.MyItemFragment
import com.choidaye.cardview.Fragment.MyPointFragment


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){


    override fun getItem(position: Int): Fragment {

        if (position ==0){
            return MyFragment()
        }
        else if( position == 1){
            return MyPointFragment()
        }

        else if(position == 2){
            return MyItemFragment()
        }

        else{
            return MyFragment()
        }
    }

    override fun getCount(): Int {

        return 3
    }


}