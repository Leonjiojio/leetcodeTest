package com.sinovoice.leetcodetest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import demo.app.com.protocolbufferdemo.UserBean
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    val TAG="liveDate"
    private val liveData =MutableLiveData<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        liveData.observe(this, Observer {
            Log.d(TAG, "onchange: $it")
        })
        liveData.value="onCreate"
    }

    override fun onStart() {
        super.onStart()
        liveData.value="onStart"
    }

    override fun onRestart() {
        super.onRestart()
        liveData.value="onRestart"
    }
    override fun onResume() {
        super.onResume()
        liveData.value="onResume"
    }
    override fun onPause() {
        super.onPause()
        liveData.value="onPause"
    }

    override fun onStop() {
        super.onStop()
        liveData.value="onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        liveData.value="onDestroy"
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
