package org.sopt24.dshyun0226.androidseminar.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity
import org.sopt24.dshyun0226.androidseminar.DB.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.adapter.ProductMainPagerAdapter

// import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY= 24


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureMainTab()
        configureTitleBar()
        txt_toolbar_main_action.setOnClickListener {
            if(SharedPreferenceController.getUserID(this).isEmpty()){

                startActivity<LoginActivity>()
            }
            else{
                SharedPreferenceController.clearUserID(this)
                configureTitleBar()
            }
        }

//        btnMainToast.setOnClickListener {
//            // 기본
//
//            /*
//            val intent: Intent = Intent(this, LoginActivity::class.java)
//            intent.putExtra("id", 1)
//            startActivity(intent)
//            */
//            // anko
//            /*
//            startActivity<LoginActivity>()
//            */
//        }
    }

    override fun onResume(){
        super.onResume()
        configureTitleBar()
    }

    private fun configureTitleBar() {
       if(SharedPreferenceController.getUserID(this).isEmpty()){
           txt_toolbar_main_action.text = "로그인"
       }
        else{
           txt_toolbar_main_action.text = "로그아웃"
       }
    }


    private fun configureMainTab(){
        vp_main_product.adapter= ProductMainPagerAdapter(supportFragmentManager, 3 )
        vp_main_product.offscreenPageLimit=2
        tl_main_category.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout : View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_category_main,null,false)
        tl_main_category.getTabAt(0)!!.customView= navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_category.getTabAt(1)!!.customView= navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_category.getTabAt(2)!!.customView= navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_end) as RelativeLayout



    }


}

