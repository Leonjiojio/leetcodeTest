package com.sinovoice.leetcodetest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        TAG="TAG:ActivityB"
        Log.d(TAG, "onCreate: tashId=$taskId")

        var intent =Intent()
        intent.action=""
        intent.addCategory("")
        intent.setDataAndType(Uri.parse("file://adb.jpg"),"image/png")
        btn_start.setOnClickListener {
            startActivity(Intent(application,ActivityC::class.java))
        }

        btn_finish.setOnClickListener {
            val  intentResult =Intent()
            val bundle=Bundle()
            bundle.putString("key","form activity B")
            intentResult.putExtras(bundle)
            setResult(10086,intentResult)
            finish()

        }
    }
}