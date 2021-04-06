package com.sinovoice.lib

import java.lang.StringBuilder

/**
 *Created by  on 2021/3/31.
 **/
object JosephusLoop {
    @JvmStatic
    fun main(args:Array<String>){
        var sum=30
        var tempNode:MNode?=null
        var LastNode:MNode?=null
        for (i in 30 downTo 1){
            var newnode=MNode(tempNode,i)
            if (i==30){
                LastNode=newnode
            }
            tempNode= newnode
        }
        LastNode?.nextNode=tempNode

//        val fisrtNode=tempNode
        var preNode=tempNode
        var loop=1
        while (sum>15){
            preNode=tempNode
            tempNode=preNode?.nextNode
            loop++

            if (loop==9){
                loop=1
                println("第${tempNode?.value}个客人下船")
                preNode?.nextNode=tempNode?.nextNode
                sum--
                tempNode=tempNode?.nextNode
            }
        }
//        船上还剩下的客人为
        var sb=StringBuilder()
        sb.append("船上剩下:")
        var tag=tempNode?.value
        tempNode=tempNode?.nextNode
        while (tag!=tempNode?.value){
            sb.append("客人${tempNode?.value},")
            tempNode=tempNode?.nextNode
        }
        println(sb.toString())
    }
}
class MNode(nextNode: MNode?, value: Int){
    var nextNode=nextNode
    var value=value
}