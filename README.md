# LiveDataExtension

[![@Tony沈哲 on weibo](https://img.shields.io/badge/weibo-%40Tony%E6%B2%88%E5%93%B2-blue.svg)](http://www.weibo.com/fengzhizi715)
[![License](https://img.shields.io/badge/license-Apache%202-lightgrey.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[ ![Download](https://api.bintray.com/packages/fengzhizi715/maven/livedata-ext/images/download.svg) ](https://bintray.com/fengzhizi715/maven/livedata-ext/_latestVersion)

# 下载安装

Gradle:
```groovy
implementation 'com.safframework.livedata:livedata-ext:0.2.1'
```

## 主要功能：

* 支持LiveData转换成Observable、Flowable。通过LiveData增加的扩展函数toObservable()、toFlowable()实现。

* 支持RxJava的Observable、Flowbale、Completable、Single、Maybe转换成LiveData。通过它们的扩展函数toLiveData()实现。

* 支持RxJava的Observable、Flowbale、Completable、Single、Maybe绑定Lifecycle。通过它们的扩展函数bindLifecycle()实现。

## TODO List:

* 升级 Kotlin 版本
* 支持AndroidX


# 联系方式:

Wechat：fengzhizi715

> Java与Android技术栈：每周更新推送原创技术文章，欢迎扫描下方的公众号二维码并关注，期待与您的共同成长和进步。

![](https://github.com/fengzhizi715/NetDiscovery/blob/master/images/gzh.jpeg)


License
-------

    Copyright (C) 2017 - present, Tony Shen.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
