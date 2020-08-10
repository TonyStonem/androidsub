package com.xjw.update.utils

import com.tencent.mmkv.MMKV
import com.xjw.update.App

/**
 * Created by xjw on 2020/8/10 13:36
 */
object KeyValueCacheUtil {

    private val kv: MMKV by lazy {
        MMKV.initialize(App.get())
        MMKV.defaultMMKV()
    }

    fun read(key: String, defValue: String = ""): String = kv.decodeString(key, defValue)

    fun read(key: String, defValue: Boolean = false): Boolean = kv.decodeBool(key, defValue)

    fun read(key: String, defValue: Int = -1): Int = kv.decodeInt(key, defValue)

    fun read(key: String, defValue: Long = -1L): Long = kv.decodeLong(key, defValue)

    fun save(key: String, value: String) {
        kv.encode(key, value)
    }

    fun save(key: String, value: Boolean) {
        kv.encode(key, value)
    }

    fun save(key: String, value: Int) {
        kv.encode(key, value)
    }

    fun save(key: String, value: Long) {
        kv.encode(key, value)
    }

    fun remove(key: String) {
        kv.removeValueForKey(key)
    }

}