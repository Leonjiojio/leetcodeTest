package com.sinovoice.leetcodetest

/**
 *Created by liqiang on 2020/9/16.
 **/
class SingleInstance {
    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingleInstance()
        }
    }
}