package com.safframework.livedata

import android.arch.lifecycle.LifecycleOwner
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
fun <T> Observable<T>.toLiveData(strategy: BackpressureStrategy = BackpressureStrategy.BUFFER): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable(strategy))

fun <T> Flowable<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this)

fun <T> Completable.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable<T>())

fun <T> Single<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable())

fun <T> Maybe<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this.toFlowable())

fun <T> Observable<T>.bindLifecycle(owner: LifecycleOwner): Observable<T> = LifecycleConvert.bindLifecycle(this, owner)

fun <T> Flowable<T>.bindLifecycle(owner: LifecycleOwner): Flowable<T> = LifecycleConvert.bindLifecycle(this, owner)

fun Completable.bindLifecycle(owner: LifecycleOwner): Completable = LifecycleConvert.bindLifecycle(this, owner)

fun Completable.bindLifecycleWithError(owner: LifecycleOwner): Completable = LifecycleConvert.bindLifecycleWithError(this, owner)

fun <T> Single<T>.bindLifecycle(owner: LifecycleOwner): Maybe<T> = LifecycleConvert.bindLifecycle(this, owner)

fun <T> Single<T>.bindLifecycleWithError(owner: LifecycleOwner): Single<T> = LifecycleConvert.bindLifecycleWithError(this, owner)

fun <T> Maybe<T>.bindLifecycle(owner: LifecycleOwner): Maybe<T> = LifecycleConvert.bindLifecycle(this, owner)
