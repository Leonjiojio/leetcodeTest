package com.sinovoice.leetcodetest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import demo.app.com.protocolbufferdemo.UserBean
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun teset(){

        var builder=UserBean.TestBean.newBuilder()
        builder.setId(1001)
            .setMsg(1,"toast").setName("haha")

        val byte=builder.build().toByteArray()
        try {
            val testBean= UserBean.TestBean.parseFrom(byte)
        }catch (e:Exception){
            e.printStackTrace()
        }
//        startActivity<MainActivity>()
    }

    inline fun <reified T : Activity> Activity.startActivity() {
        startActivity(Intent(this, T::class.java))
    }
}
