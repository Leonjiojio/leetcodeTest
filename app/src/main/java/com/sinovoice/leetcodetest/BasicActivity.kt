package com.sinovoice.leetcodetest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 *Created by  on 2021/4/21.
 **/
open class BasicActivity : AppCompatActivity() {
    protected var TAG="TAG:"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        TAG="TAG:"+this::class.java.simpleName
        Log.d(TAG, "onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent: "+intent.toString())
    }
}