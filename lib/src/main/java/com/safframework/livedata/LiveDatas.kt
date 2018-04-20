package com.safframework.livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.MainThreadDisposable

/**
 *
 * @FileName:
 *          com.safframework.livedata.LiveDatas.java
 * @author: Tony Shen
 * @date: 2018-04-20 11:04
 * @version V1.0 <描述当前版本功能>
 */
fun <T> LiveData<T>.toObservable(owner: LifecycleOwner? = null): Observable<T> = LiveDataObservable(owner, this)

fun <T> LiveData<T>.toFlowable(owner: LifecycleOwner? = null, strategy: BackpressureStrategy = BackpressureStrategy.LATEST): Flowable<T> =
        Flowable.create({ emitter ->
            val observer = Observer<T> {
                it?.let { emitter.onNext(it) }
            }

            if (owner == null) {
                observeForever(observer)
            } else {
                observe(owner, observer)
            }

            emitter.setCancellable {
                object : MainThreadDisposable() {

                    override fun onDispose() = removeObserver(observer)
                }
            }
        }, strategy)