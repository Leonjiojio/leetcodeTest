package com.sinovoice.lib

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
        exChange()
    }
    fun testPlus(){
        var a=10
        var c=a++
        println("a=$a,c=$c")
    }
    fun exChange(){

        var a=10
        var b=6
        println("before change a=$a,b=$b")
//        a = a xor b //a=a^b=0011 0001
//
//        b = a xor b //b=a^b=0011 1100
//
//        a = a xor b //a=a^b=0000 1101

        a=a+b
        b=a-b
        a=a-b
        println("after change a=$a,b=$b")

    }
    fun inc(num : Int) {
        val num = 2
        if (num > 0) {
            val num = 3
        }
        println ("num: " + num)
    }
}