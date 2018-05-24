# LiveDataExtension

[![@Tony沈哲 on weibo](https://img.shields.io/badge/weibo-%40Tony%E6%B2%88%E5%93%B2-blue.svg)](http://www.weibo.com/fengzhizi715)
[![License](https://img.shields.io/badge/license-Apache%202-lightgrey.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)


## 主要功能：

* 支持LiveData转换成Observable、Flowable。通过LiveData增加的扩展函数toObservable()、toFlowable()实现。

* 支持RxJava的Observable、Flowbale、Completable、Single、Maybe转换成LiveData。通过它们的扩展函数toLiveData()实现。

* 支持RxJava的Observable、Flowbale、Completable、Single、Maybe绑定Lifecycle。通过它们的扩展函数bindLifecycle()实现。