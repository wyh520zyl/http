package com.wang.myapplication.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HiRetrofit {
    var url:String=""
    private val client = OkHttpClient.Builder() //builder构造者设计模式
        .connectTimeout(10, TimeUnit.SECONDS) //连接超时时间
        .readTimeout(10,TimeUnit.SECONDS)//读取超时
        .writeTimeout(10,TimeUnit.SECONDS)//写超时
        .addInterceptor(LoggingInterceptor())
        .build()
    private val retrofit:Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(url)//此的域名处必须以'/'结尾，不然会报ExceptionInInitializerError
        .addConverterFactory(GsonConverterFactory.create())//数据转换适配器
        .build()

    /**
     * java 方法不能直接使用，需要改写未kotlin格式的方法
     */

    fun <T>create(clazz: Class<T>):T{
        return retrofit.create(clazz)
    }

    fun getHiRetrofit():HiRetrofit {
        return this
    }
}