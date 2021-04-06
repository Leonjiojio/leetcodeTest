package com.sinovoice.lib

/**
 *Created by  on 2021/3/31.
 **/
object FishMan {

    @JvmStatic
    fun main(args:Array<String>){

        var sum=5
        var a=0
        var b=0
        var c=0
        var d=0
        var e=0
        while (!(a%5==1&&b%5==1&&c%5==1&&d%5==1&&e%5==1)){

            a=sum
            b=(a-1)*4/5
            c=(b-1)*4/5
            d=(c-1)*4/5
            e=(d-1)*4/5
            sum++
        }
        println("至少合伙捕鱼：$sum 条\n")
        println("分别见到鱼的条数：a=$sum ,b=$b ,c=$c ,d=$d ,e=$e")

    }
}