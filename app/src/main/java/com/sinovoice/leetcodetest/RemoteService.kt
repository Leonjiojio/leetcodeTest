package com.sinovoice.leetcodetest

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 *Created by  on 2021/3/5.
 **/
class RemoteService : Service() {
    private  var binder=MyBinder()
    override fun onBind(intent: Intent?): IBinder? {
        return  binder
    }
}