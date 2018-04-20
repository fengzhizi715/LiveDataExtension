package com.safframework.livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import io.reactivex.Observable

/**
 *
 * @FileName:
 *          com.safframework.livedata.LiveDatas.java
 * @author: Tony Shen
 * @date: 2018-04-20 11:04
 * @version V1.0 <描述当前版本功能>
 */
fun <T> LiveData<T>.toObservable(owner: LifecycleOwner? = null): Observable<T> = LiveDataObservable(owner, this)