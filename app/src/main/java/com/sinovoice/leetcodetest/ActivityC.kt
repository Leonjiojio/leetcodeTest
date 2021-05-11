package com.sinovoice.leetcodetest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_b.*

class ActivityC : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        TAG="TAG:ActivityC"
        Log.d(TAG, "onCreate: tashId=$taskId")
        btn_start.setOnClickListener {
            startActivity(Intent(application,MainActivity::class.java))
        }
    }
}