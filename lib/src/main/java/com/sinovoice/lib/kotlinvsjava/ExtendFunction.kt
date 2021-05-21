package com.sinovoice.lib.kotlinvsjava


/**
 *Created by  on 2021/5/21.
 **/
public class ExtendFunction {

    open class Animal {
        open fun shout() = println("animal is shout")//定义成员函数
    }

    class Cat: Animal() {
        override fun shout() {
            println("Cat is shout")//子类重写父类成员函数
        }
    }
    //测试
    companion object{

        //定义子类和父类扩展函数
        fun Animal.eat() = println("Animal eat something")
        fun Cat.eat()= println("Cat eat fish")
        var User.isChiniese:Boolean
            get(){
                return this.name.startsWith("#")
            }
            set(value){
                this.name.run {
                    if (value&&name.startsWith("#")){
                        name=name.substring(1,name.length)
                    }
                }

            }



        @JvmStatic
        fun main(args: Array<String>) {
           val user= User("Tom",18)
            println("${user.name} is old =${user.isOld()}")
             fun User.canRun()= this.age > 2
            println("${user.name} can run =${user.canRun()}")

            val animal: Animal = Cat()
            println("成员函数测试: ${animal.shout()}")
            println("扩展函数测试: ${animal.eat()}")
        }
    }
}
class  User(var name:String,var age:Int){

    public fun  isOld():Boolean{
        return age>60
    }
}