package org.sopt24.dshyun0226.androidseminar.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_end_product_main.*
import org.sopt24.dshyun0226.androidseminar.Adapter.ProductOverviewRecyclerViewAdapter
import org.sopt24.dshyun0226.androidseminar.Data.ProductOverviewData
import org.sopt24.dshyun0226.androidseminar.Network.ApplicationController
import org.sopt24.dshyun0226.androidseminar.Network.Get.GetMainProductListResponse
import org.sopt24.dshyun0226.androidseminar.Network.NetworkService

import org.sopt24.dshyun0226.androidseminar.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EndProductMainFragment : Fragment() {

    lateinit var productOverviewRecyclerViewAdapter: ProductOverviewRecyclerViewAdapter

    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end_product_main, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /* 추후 서버와의 통신으로 대체할 부분입니다 */
        var dataList: ArrayList<ProductOverviewData> = ArrayList()


        productOverviewRecyclerViewAdapter = ProductOverviewRecyclerViewAdapter(context!!, dataList)
        rv_product_overview_end.adapter = productOverviewRecyclerViewAdapter
        rv_product_overview_end.layoutManager = GridLayoutManager(context!!, 3)

        getMainProductListResponse()


    }

    private fun getMainProductListResponse() {
        var getMainProductListResponse = networkService.getMainProductResponse("application/json",2)
        getMainProductListResponse.enqueue(object : Callback<GetMainProductListResponse> {
            override fun onFailure(call: Call<GetMainProductListResponse>, t: Throwable) {
                Log.e("AllMainProductList Fail",t.toString())
            }

            override fun onResponse(call: Call<GetMainProductListResponse>, response: Response<GetMainProductListResponse>) {
                if (response.body()!!.status==200){
                    val tmp : ArrayList<ProductOverviewData> = response.body()!!.data!!
                    productOverviewRecyclerViewAdapter.dataList = tmp
                    productOverviewRecyclerViewAdapter.notifyDataSetChanged()
                }

            }
        })
    }


}
