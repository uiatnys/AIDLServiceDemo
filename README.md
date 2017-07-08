本文参考：http://blog.csdn.net/fwt336/article/details/52587133
# 服务端编码步骤
## aidl描述：
> AIDL (Android Interface Definition Language) 是一种IDL 语言，用于生成可以在Android设备上两个进程之间进行进程间通信(interprocess communication, IPC)的代码。如果在一个进程中（例如Activity）要调用另一个进程中（例如Service）对象的操作，就可以使用AIDL生成可序列化的参数。

## 操作步骤
#### 1.首先新建一个android项目
#### 2.main文件夹右键选择aidl，新建一个aidl文件，本项目中文件名为IRemoteService，IRemoteService.aidl中可以任意写几个方法，这步操作之后main文件夹下回多一个aidl目录，目录中包名与java目录中的包名一致。
#### 3.点击Build - Make Project，等待执行完成，查看app - build - generated - source - aidl - debug下是否生成IRemoteService.java文件，IRemoteService中有一个静态抽象类 Stub，Stub实现了IRemoteService接口，实现了IRemoteService.aidl中的所有方法，需要注意的是Stub中声明了一个asInterface方法，这个方法接受一个Binder对象，并将其转化成Stub对应的接口对象（也就是这里的IRemoteService）并返回。
#### 4.java目录下新建一个javabean，项目中命名为HelloMsg并实现Parcelable接口。
#### 5.aidl与IRemoteService.aidl同目录下新建HelloMsg.aidl文件，文件中只需要写入`package 包名`，`parcelable HelloMsg`，注意:`parcelable` 的`p`是小写。
#### 6.再次Make Project。
#### 7.java目录下新建一个service继承Service，本项目中命名为RemoteService，声明IRemoteService.Stub对象，重写onBind方法，用于向客户端返回Binder对象，至此服务端代码已经编写完成，不要忘记在AndroidManifest加上service标签。
## 项目结构如下所示

![src](/screenshots/src.png "src")
![build_generated_source.png](/screenshots/build_generated_source.png "build_generated_source")
![hellomsg](/screenshots/hellomsg.png "hellomsg
![hellomsg_java](/screenshots/hellomsg_java.png "hellomsg_java")
![iremoteservice](/screenshots/iremoteservice.png "iremoteservice")
![iremoteservice_java](/screenshots/iremoteservice_java.png "iremoteservice_java")
![remoteservice](/screenshots/remoteservice.png "remoteservice")