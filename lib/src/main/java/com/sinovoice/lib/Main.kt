package com.sinovoice.lib

import com.sinovoice.lib.kotlin.KtInlineTest
import com.sinovoice.lib.kotlin.LetApplyTest
import com.sinovoice.lib.kotlinvsjava.KotlinDemo

/**
 *Created by liqiang on 2020/9/23.
 **/
object Main {
    @JvmStatic
    fun main(args:Array<String>){
//        println("hello kotlin")
//        val letApplyTest=LetApplyTest()
//        letApplyTest.letTest("hello")
//        letApplyTest.withTest()
//        letApplyTest.runTest()
//        letApplyTest.applytest()
        val  ktinline=KotlinDemo()
        ktinline.doSth("")
        ktinline.nullCheck("")
        ktinline.printClassName()

//        inc(1)
    }
    fun inc(num : Int) {
        val num = 2
        if (num > 0) {
            val num = 3
        }
        println ("num: " + num)
    }
}