package com.sinovoice.leetcodetest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import demo.app.com.protocolbufferdemo.UserBean
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class MainActivity : BasicActivity(), CoroutineScope by MainScope() {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val liveData =MutableLiveData<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG="TAG:MainActivity"
        setContentView(R.layout.activity_main)
        liveData.observe(this, Observer {
//            Log.d(TAG, "onchange: $it")
        })
        liveData.value="onCreate"
        button.setOnClickListener {
            GlobalScope.launch (Dispatchers.Main){
                coroutineTest()
            }
        }
        btn_start_new.setOnClickListener {
            startActivity(Intent(this,ActivityB::class.java))
        }
        Log.d(TAG, "onCreate: tashId=$taskId")
    }

    suspend fun coroutineTest(){
        val job=GlobalScope.async(Dispatchers.IO) {

            delay(2000)
            return@async "like"
        }
        val result=job.await()
        tv1.text=result
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
        cancel()
        job.cancel()
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
