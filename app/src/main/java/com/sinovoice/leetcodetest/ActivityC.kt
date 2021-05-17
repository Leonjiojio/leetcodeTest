package com.sinovoice.leetcodetest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_b.*

class ActivityC : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        TAG="TAG:ActivityC"
        Log.d(TAG, "onCreate: tashId=$taskId")
        btn_start.setOnClickListener {
            startActivityForResult(Intent(application,ActivityB::class.java),10086)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==10086){

            val bundle=data?.extras
            val result=bundle?.getString("key")

            Toast.makeText(application,"获取返回值$result",Toast.LENGTH_SHORT).show()
        }
    }
}