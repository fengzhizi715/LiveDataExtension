package com.safframework.livedata

import android.os.Looper

/**
 *
 * @FileName:
 *          com.safframework.livedata.Utils.java
 * @author: Tony Shen
 * @date: 2018-04-29 15:20
 * @version V1.0 <描述当前版本功能>
 */
fun checkMainThread():Boolean= Thread.currentThread() == Looper.getMainLooper().thread