package com.safframework.livedata

import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.SingleSource
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.Exceptions
import io.reactivex.functions.Predicate
import io.reactivex.internal.disposables.DisposableHelper
import io.reactivex.plugins.RxJavaPlugins

/**
 *
 * @FileName:
 *          com.safframework.livedata.SingleFilter.java
 * @author: Tony Shen
 * @date: 2018-04-29 16:12
 * @version V1.0 <描述当前版本功能>
 */
fun <T> Single<T>.filterOrNever(predicate: Predicate<in T>): Single<T> {
    return RxJavaPlugins.onAssembly(SingleFilterSingle<T>(this, predicate))
}

class SingleFilterSingle<T>(
        private val source: SingleSource<T>,
        private val predicate: Predicate<in T>
) : Single<T>() {

    override fun subscribeActual(observer: SingleObserver<in T>) {
        source.subscribe(FilterSingleObserver(observer, predicate))
    }

    private class FilterSingleObserver<T>(
            val actual: SingleObserver<in T>,
            val predicate: Predicate<in T>
    ) : SingleObserver<T>, Disposable {

        var d: Disposable? = null

        override fun dispose() {
            val d = this.d
            this.d = DisposableHelper.DISPOSED
            d?.dispose()
        }

        override fun isDisposed(): Boolean {
            return d?.isDisposed != false
        }

        override fun onSubscribe(d: Disposable) {
            if (DisposableHelper.validate(this.d, d)) {
                this.d = d
                actual.onSubscribe(this)
            }
        }

        override fun onSuccess(value: T) {
            val b: Boolean

            try {
                b = predicate.test(value)
            } catch (ex: Throwable) {
                Exceptions.throwIfFatal(ex)
                actual.onError(ex)
                return
            }

            if (b) {
                actual.onSuccess(value)
            }
            //else will be Single.never()
        }

        override fun onError(e: Throwable) {
            actual.onError(e)
        }
    }
}