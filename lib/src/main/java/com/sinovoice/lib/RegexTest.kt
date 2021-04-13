package com.sinovoice.lib

/**
 *Created by  on 2021/4/12.
 **/
class RegexTest {
    fun doSth(){
//        val regex= "[^aeiou]" //匹配除了 [...] 中字符的所有字符，例如 [^aeiou] 匹配字符串 "google runoob taobao" 中除了 e o u a 字母的所有字母。
//        val regex= "[a-z]" //[A-Z] 表示一个区间，匹配所有大写字母，[a-z] 表示所有小写字母。
//        val regex= "."//匹配除换行符（\n、\r）之外的任何单个字符，相等于 [^\n\r]。
//        val regex= "[\\s]"//匹配所有。\s 是匹配所有空白符，包括换行，\S 非空白符，不包括换行。
//        val regex= "\\w"//匹配字母、数字、下划线。等价于 [A-Za-z0-9_]

        //以下列出 ?=、?<=、?!、?<! 的使用区别
        //exp1(?=exp2)：查找 exp2 前面的 exp1。

//        val regex= "leon(?=[\\d]+)"//匹配数字前面的leon
//        val regex= "leon(?![\\d]+)"//匹配后面不是数字的leon
//        val regex= "(?<=[\\d])leon"//匹配数字后面的leon
//        val regex= "(?<![\\d])leon"//匹配前面不是数字的leon
//        val result="leon_1234leon6leon leon"

        //多行匹配
//        val regex= "^runoob"
//        val result="runoobgoogle\n" +
//                "runoobleon\n" +
//                "runomax"
//        val r=regex.toRegex(RegexOption.MULTILINE)
//        val regex= "[,.?，。？、！!]+"
//        val result="10:11"
//        val result="你好，今,天.天。气!怎！么？样?"
        //忽略大小写
//        val regex= "runoob"
//        val result="runoobgoogle" +
//                "runoobleon" +
//                "RUNOOB"
//        val r=regex.toRegex(RegexOption.IGNORE_CASE)


        //单词边界 'er\B'
        // \b
        //匹配一个单词边界，也就是指单词和空格间的位置。例如， 'er\b' 可以匹配"never" 中的 'er'，但不能匹配 "verb" 中的 'er'。
        //\B
        //匹配非单词边界。'er\B' 能匹配 "verb" 中的 'er'，但不能匹配 "never" 中的 'er'。
//        val regex= "er\\B"
//        val result="never stop" //false  never yes

        //邮箱匹配

//        val regex= "[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}"
//        val result="liqustb@ustb.edu.com.cn"

        val regex= "[\\w]+\\.pdf"
        val result="123word.pdf"

        val r=regex.toRegex()
        val finds=r.findAll(result)
        for (matchResult in finds){
            println(matchResult.range)
        }
        println("result="+result.replace(r,"#"))
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val regexTest=RegexTest()
            regexTest.doSth()
        }
    }
}