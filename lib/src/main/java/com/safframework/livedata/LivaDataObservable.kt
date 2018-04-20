package com.safframework.livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

/**
 *
 * @FileName:
 *          com.safframework.livedata.LivaDataObservable.java
 * @author: Tony Shen
 * @date: 2018-04-20 12:49
 * @version V1.0 <描述当前版本功能>
 */
class LiveDataObservable<T>(private val owner: LifecycleOwner? = null, private val data: LiveData<T>) : Observable<T>() {

    override fun subscribeActual(observer: Observer<in T>) {
        val liveDataObserver = LiveDataObserver(data, observer)
        observer.onSubscribe(liveDataObserver)
        if (owner == null) {
            data.observeForever(liveDataObserver)
        } else {
            data.observe(owner, liveDataObserver)
        }
    }

    class LiveDataObserver<T>(private val data: LiveData<T>, private val observer: Observer<in T>) : MainThreadDisposable(), android.arch.lifecycle.Observer<T> {

        override fun onDispose() {
            data.removeObserver(this)
        }

        override fun onChanged(t: T?) {

            if (t!=null) {
                observer.onNext(t)
            }
        }
    }
}