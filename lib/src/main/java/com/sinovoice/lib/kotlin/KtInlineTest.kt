package com.sinovoice.lib.kotlin

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 *Created by liqiang on 2020/9/23.
 **/
class KtInlineTest {
    fun outterFun() {
//        innerFun {
//            //return  //错误，不支持直接return
//            //只支持通过标签，返回innerFun
//            return@innerFun 1
//        }
        innerFun {
            return@innerFun 1//支持直接返回outterFun
        }

        //如果是匿名或者具名函数，则支持
        var f = fun(){
            return
        }
    }
    inline fun innerFun(crossinline  a: () -> Int) {}
/*
什么是reified,字面意思:具体化,其实就是具体化泛型;
我们都知道在java中如果是泛型,是不能直接使用泛型的类型的,但是kotlin却是可以的,这点和java就有了显著的区别.
通常java中解决的方案就是通过函数来传递类
 */
    inline fun <reified T : KtInlineTest> KtInlineTest.printReified() {
        printIntent(Intent("this, T::class.java"))
    }
    fun printIntent(intent:Intent){
        println("startActivity"+intent.msg)
    }
    inline fun <T> method(lock: Lock, noinline body: () -> T): T {
        lock.lock()
        try {
            otherMehtod(body)
            return body()
        } finally {
            lock.unlock()
        }
    }
     fun <T> otherMehtod(body: () -> T){
        println("otherMehtod call")
    }

    fun test(){
        val lock = ReentrantLock()
        val result=method(lock, {"我是body的方法体"})//lock是一个Lock对象
        println(result)
        printReified<KtInlineTest>()
    }
    companion object{
        @JvmStatic
        fun main(args :Array<String>){
            val test=KtInlineTest()
            test.test()
        }
    }

}
class Intent(msg:String){
    val msg=msg
}