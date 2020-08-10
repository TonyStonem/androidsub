package com.xjw.update.dataobject

/**
 * Created by xjw on 2020/8/10 11:39
 */

data class Version(
    val currentVersionCode: Long = 0, //本地版本号
    val newestVersionCode: Long = 0, //最新版本号
    val maximumShow: Int = 1, //一天内最多提示更新次数
    val timestamp: Long = 0 //服务器时间戳
)