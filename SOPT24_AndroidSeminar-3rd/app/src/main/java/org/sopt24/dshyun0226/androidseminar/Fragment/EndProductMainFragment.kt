package org.sopt24.dshyun0226.androidseminar.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_end_product_main.*
import org.sopt24.dshyun0226.androidseminar.Data.ProductOverviewData
import org.sopt24.dshyun0226.androidseminar.Adapter.ProductOverviewRecyclerViewAdapter

import org.sopt24.dshyun0226.androidseminar.R

class EndProductMainFragment : Fragment() {


    lateinit var productOverviewRecyclerViewAdapter: ProductOverviewRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end_product_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        var dataList: ArrayList<ProductOverviewData> = ArrayList()
        dataList.add(ProductOverviewData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            0,"완결작품 1",120,"완결작가 A"))
        dataList.add(ProductOverviewData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            1, "완결작품 2", 100, "완결작가 B"))
        dataList.add(ProductOverviewData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            2, "완결작품 3", 99, "완결작가 C"))
        dataList.add(ProductOverviewData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            3, "완결작품 4", 10, "완결작가 D"))
        dataList.add(ProductOverviewData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            4, "완결작품 5", 1, "완결작가 E"))
        dataList.add(ProductOverviewData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            5, "완결작품 6", 1, "완결작가 F"))
        dataList.add(ProductOverviewData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            6, "완결작품 7", 1, "완결작가 G"))
        dataList.add(ProductOverviewData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            7, "완결작품 8", 1, "완결작가 H"))


        productOverviewRecyclerViewAdapter= ProductOverviewRecyclerViewAdapter(context!!,dataList)
        rv_product_overview_end.adapter = productOverviewRecyclerViewAdapter
        rv_product_overview_end.layoutManager= GridLayoutManager(context!!,3)

    }




}
