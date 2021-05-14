package com.sinovoice.leetcodetest

import android.os.Bundle
import android.os.Handler
import android.os.Handler.Callback
import android.os.Message
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_leak_canary.*

class LeakCanaryActivity : BasicActivity() {
    private  var  handler:Handler?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak_canary)
        handler=Handler(Callback {

            when(it.what){
                1 -> Log.d(TAG, "onCreate: 1")
                2-> Log.d(TAG, "onCreate: 2")
                else->{
                    Log.d(TAG, "onCreate: else")
                }
            }
            return@Callback false
        })
        val msg=Message.obtain(handler) {  Toast.makeText(applicationContext,"leak test",Toast.LENGTH_LONG).show() }
        btn_start_leack.setOnClickListener {
            handler?.sendEmptyMessageDelayed(1,30*1000)
        }
    }
}