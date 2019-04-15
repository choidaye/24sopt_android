package org.sopt24.dshyun0226.androidseminar.Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import org.sopt24.dshyun0226.androidseminar.DB.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.R
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY= 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtLoginID.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        edtLoginPW.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        btnLoginSubmit.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()

            if(login_u_id == "") edtLoginID.requestFocus()
            else if(login_u_pw == "") edtLoginPW.requestFocus()
            else postLoginResponse(login_u_id, login_u_pw)
        }

        txtLoginSignup.setOnClickListener{


            val simpleDateFormat= SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val s_time = simpleDateFormat.format(Date())

            //Anko
            startActivityForResult<SignupActivity>(REQUEST_CODE_LOGIN_ACTIVITY,"start_time" to s_time)


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_CODE_LOGIN_ACTIVITY){

            if(resultCode== Activity.RESULT_OK){

            val e_time = data!!.getStringExtra("end_time")

            //anko
            toast("End Time:${e_time}")
            }
        }
    }

    fun postLoginResponse(u_id: String, u_pw: String){
        // Request Login

        SharedPreferenceController.setUserID(this,u_id)


        finish()
    }
}























