package com.sinovoice.leetcodetest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.util.SparseArray
import android.widget.Toast
import androidx.core.util.keyIterator
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sinovoice.leetcodetest.utils.FileUtils
import demo.app.com.protocolbufferdemo.UserBean
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.io.File
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
            val intent=Intent(this,ActivityB::class.java)
            startActivity(intent)
        }
        btn_start_test_activity.setOnClickListener {
            startActivity(Intent(this,ActivityViewTest::class.java))
        }
        btn_start_leakcanry_activity.setOnClickListener {
            startActivity(Intent(this,LeakCanaryActivity::class.java))
        }
        Log.d(TAG, "onCreate: tashId=$taskId")
        btn_protobuf_test.setOnClickListener {
            val id=etId.text.toString().toLong()
            val name=etname.text.toString()
            protoBufTest(id,name)
        }
        btn_array_test.setOnClickListener { arrayTest() }
        btn_test_activity.setOnClickListener {
            startActivity(Intent(this, HttpActivity::class.java))
        }
    }
    private fun arrayTest(){
        val sparseArray= SparseArray<String>()
        sparseArray.put(8,"8")
        sparseArray.put(1,"8")
        val keyit=sparseArray.keyIterator()
        Log.d(TAG, "arrayTest: sparseArray.size="+sparseArray.size())
        while (keyit.hasNext()){
            Log.d(TAG, "arrayTest: key="+keyit.nextInt())
        }

    }

    suspend fun coroutineTest(){
        GlobalScope.launch {
//            val token = getToken()
//            val userInfo = getUserInfo(token)
//            setUserInfo(userInfo)
        }
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


    private fun protoBufTest(id:Long,name:String){

        var builder=UserBean.TestBean.newBuilder()
        builder.setId(id)
            .name =name

        val file=File(Environment.getExternalStorageDirectory().absolutePath,"userbin.proto")


        val byte=builder.build().toByteArray()
        FileUtils.saveFile(byte,file)
        try {
            val testBean= UserBean.TestBean.parseFrom(byte)
            Toast.makeText(application,"name${testBean.name},id=${testBean.id}",Toast.LENGTH_SHORT).show()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    inline fun <reified T : Activity> Activity.startActivity() {
        startActivity(Intent(this, T::class.java))
    }
}
