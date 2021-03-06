package org.sopt24.dshyun0226.androidseminar.Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast
import org.sopt24.dshyun0226.androidseminar.R
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val s_time = intent.getStringExtra("start_time")

        /*
        // without Anko
        Toast.makeText(this, "Current time: ${c_time}", Toast.LENGTH_SHORT).show()
        */
        // with Anko
        toast("Current time: ${s_time}")

        val edtOnFocusChangeListener: View.OnFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        edtSignupName.setOnFocusChangeListener(edtOnFocusChangeListener)
        edtSignupID.setOnFocusChangeListener(edtOnFocusChangeListener)
        edtSignupPW.setOnFocusChangeListener(edtOnFocusChangeListener)

        btnSignupSubmit.setOnClickListener {
            val signup_u_name: String = edtSignupName.text.toString()
            val signup_u_id = edtSignupID.text.toString()
            val signup_u_pw: String = edtSignupPW.text.toString()

            if(isValid(signup_u_id, signup_u_pw, signup_u_name)){
                postSignupResponse(signup_u_id, signup_u_pw, signup_u_name)
            }
        }
    }

    fun isValid(u_id: String, u_pw: String, u_name: String): Boolean{
        if(u_name == "") edtSignupName.requestFocus()
        else if(u_id == "") edtSignupID.requestFocus()
        else if(u_pw == "") edtSignupPW.requestFocus()
        else return true
        return false
    }

    fun postSignupResponse(u_id: String, u_pw: String, u_name: String){
        // Request Signup
        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val e_time = simpleDateFormat.format(Date())

        val intent: Intent = Intent()
        intent.putExtra("end_time", e_time)
        setResult(Activity.RESULT_OK, intent)



        finish()
    }
}

