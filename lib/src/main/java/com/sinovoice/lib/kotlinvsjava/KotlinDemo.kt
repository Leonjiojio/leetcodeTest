package com.sinovoice.lib.kotlinvsjava

/**
 *Created by liqiang on 2020/9/27.
 **/
class KotlinDemo {
    fun nullCheck(str:String){
//        str?.plus("like")
        println("string is null="+str?: 0)

    }
    fun printClassName(){
//        print(KotlinDemo::class.simpleName)
        println(JavaUtils::class.java.simpleName)
    }

    fun doSth(text: String) {
        val f: String = JavaUtils.format(text)?:"d"       // compiles but assignment can throw NPE at runtime
        println ("$f.len : " + f.length)
    }
    fun mapteset(){
        val map= hashMapOf(1 to "",2 to "like")
    }

    fun inc(num : Int) {
        val num = 2
        if (num > 0) {
            val num = 3
        }
        println ("num: " + num) //2
    }
}