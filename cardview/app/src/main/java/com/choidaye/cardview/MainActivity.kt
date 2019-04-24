package com.choidaye.cardview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ViewPagerAdapter(supportFragmentManager)
        ac_main_vp.adapter = adapter
        ac_main_vp.setPadding(50,0,50,0)
        ac_main_vp.setPageMargin(20)

    }






}
