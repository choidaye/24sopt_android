package org.sopt24.dshyun0226.androidseminar.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import org.sopt24.dshyun0226.androidseminar.Fragment.AllProductMainFragment
import org.sopt24.dshyun0226.androidseminar.Fragment.EndProductMainFragment
import org.sopt24.dshyun0226.androidseminar.Fragment.NewProductMainFragment

class ProductMainPagerAdapter(fm: FragmentManager, private val num_fragment:Int): FragmentStatePagerAdapter(fm) {


    override fun getItem(p0: Int): Fragment? {
        return when(p0){

            0 ->AllProductMainFragment()
            1->NewProductMainFragment()
            2->EndProductMainFragment()

            else ->null


        }



    }

    override fun getCount(): Int {

        return num_fragment
    }


}