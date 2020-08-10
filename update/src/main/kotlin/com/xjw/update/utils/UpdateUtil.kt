package com.xjw.update.utils

import android.content.Intent
import com.xjw.update.App
import com.xjw.update.constant.Param
import com.xjw.update.dataobject.Version
import com.xjw.update.view.UpdateActivity
import java.util.*

/**
 * Created by xjw on 2020/8/10 11:33
 */
object UpdateUtil {

    /**
     * 检查更新
     * @param version 服务器提供最新的版本号
     */
    fun checkUpdate(version: Version) {
        checkTimestamp(version.timestamp)
        if (version.currentVersionCode < version.newestVersionCode) {
            // 需要更新
            var todayShowTotal =
                KeyValueCacheUtil.read(Param.Key.KEY_LOCAL_TODAY_SHOW_UPDATE_TOTAL, 0)
            if (todayShowTotal < version.maximumShow) {
                // 需要提醒用户更新
                App.get().startActivity(Intent(App.get(), UpdateActivity::class.java))
            }
        }
    }

    /**
     * 检查是否为今天
     * @param timestamp 服务器时间戳
     */
    private fun checkTimestamp(timestamp: Long) {
        val zero =
            System.currentTimeMillis() / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().rawOffset
        val twelve = zero + 24 * 60 * 60 * 1000 - 1
        if (timestamp !in zero..twelve) {
            // 新的一天
            KeyValueCacheUtil.save(Param.Key.KEY_LOCAL_TODAY_SHOW_UPDATE_TOTAL, 0)
        }
        KeyValueCacheUtil.save(Param.Key.KEY_LOCAL_TODAY_TIMESTAMP, timestamp)
    }

}