package com.sinovoice.lib.kotlin

/**
 *Created by liqiang on 2020/9/23.
 **/
class People(name:String,age:Int) {

    var name=name
    var age=age
    fun showInfo(){
        println("name=$name,age=$age")
    }
    fun study(){
        println("study")
    }
    fun shopping(){
        println("shopping")
    }
    fun eat(sth:String){
        println("$name eat $sth")
    }
}
