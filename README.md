# LiveDataExtension

## 主要功能：

* 支持LiveData转换成Observable、Flowable。通过LiveData增加的扩展函数toObservable()、toFlowable()实现。

* 支持RxJava的Observable、Flowbale、Completable、Single、Maybe转换成LiveData。通过它们的扩展函数toLiveData()实现。

* 支持RxJava的Observable、Flowbale、Completable、Single、Maybe绑定Lifecycle。通过它们的扩展函数bindLifecycle()实现。