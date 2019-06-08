package org.sopt24.dshyun0226.androidseminar.Network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApplicationController : Application(){


    private val baseURL = "http://hyunjkluz.ml:2424/"
    lateinit var networkService: NetworkService


    companion object {
        lateinit var  instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }


    //실제로 네트워크를 할 수 있도록 빌드시켜주는 함수

    private fun buildNetwork() {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        networkService = retrofit.create(NetworkService::class.java)
    }


}
