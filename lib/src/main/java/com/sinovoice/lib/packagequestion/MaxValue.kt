package com.sinovoice.lib.packagequestion

import kotlin.math.max

/**
 *Created by  on 2021/4/7.
 **/
class MaxValue {

    fun test(){

        val packageWight=4
        val goodsNum =4
        val valueArray = arrayOf(1500, 3000, 2000,2000)
        val weightArray = arrayOf(1, 4, 3,1)
        getMaxValue(goodsNum,packageWight,valueArray ,weightArray)


    }

    fun getMaxValue(goodsNum:Int,packageWight:Int,valueArray:Array<Int>,weightArray:Array<Int>){
//        val maxValue =Array(goodsNum) { IntArray(packageWight) }
        val maxValue = Array(size = goodsNum, init = { IntArray(packageWight) })
        for (i in 0 until goodsNum){
            for (j in 1 .. packageWight){
                if (i==0){
                    maxValue[i][j-1]=if(weightArray[i]<=j) valueArray[i] else 0
                }else{
                    var topValue=maxValue[i-1][j-1] // 上一个网格的值
                    var thisValue= if(weightArray[i]<=j)
                        (if (j-weightArray[i]>0) valueArray[i]+maxValue[i-1][j-weightArray[i]] else valueArray[i] )
                    else topValue  // 当前商品的价值 + 剩余空间的价值
                    // 返回 topValue和thisValue中较大的一个
                    maxValue[i][j-1]= max(topValue,thisValue)
                }

            }
        }


        // 打印结果二维数组maxValue
        for (i in 0 until  goodsNum){
            for (j in 0 until  packageWight){
                System.out.printf("%6d", maxValue[i][j])
            }
            println()
        }
    }

    companion object{
        @JvmStatic
        fun main(args:Array<String>){
            MaxValue().test()
        }
    }

}