package com.sinovoice.leetcodetest

import android.os.Bundle
import android.util.Log

class ActivityB : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        TAG="TAG:ActivityB"
        Log.d(TAG, "onCreate: ")
    }
}