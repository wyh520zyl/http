package com.wang.myapplication.util

class HttpUtil private constructor() {
    companion object {
        private var instance: HttpUtil? = null
        //使用同步锁注解
        @Synchronized
        fun get(): HttpUtil{
            if (instance == null) {
                instance = HttpUtil()
            }
            return instance!!
        }
    }
    fun method(){}
}
