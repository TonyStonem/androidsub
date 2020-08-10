package com.xjw.androidsub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xjw.library.base.App
import com.xjw.update.dataobject.Version
import com.xjw.update.utils.UpdateUtil
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * 2020/8/9 17:41
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @Record:
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        text_app_name.text = BuildConfig.APPLICATION_ID
        UpdateUtil.checkUpdate(Version())
    }

}