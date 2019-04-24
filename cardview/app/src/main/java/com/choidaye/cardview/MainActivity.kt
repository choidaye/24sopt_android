package com.choidaye.cardview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.choidaye.cardview.Fragment.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var adapter:ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ViewPagerAdapter(supportFragmentManager)
        
    }






}
