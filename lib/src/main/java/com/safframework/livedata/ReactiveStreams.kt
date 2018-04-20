package com.safframework.livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import io.reactivex.*

/**
 *
 * @FileName:
 *          com.safframework.livedata.ReactiveStreams.java
 * @author: Tony Shen
 * @date: 2018-04-20 16:41
 * @version V1.0 <描述当前版本功能>
 */
fun <T> Observable<T>.toLiveData(strategy: BackpressureStrategy = BackpressureStrategy.LATEST): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable(strategy))

fun <T> Flowable<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this)

fun <T> Completable.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable<T>())

fun <T> Single<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable())

fun <T> Maybe<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable())