# LazyPeas
快速开发框架，包括ui的各种状态，另外希望将网络层也封装进去，争取做个懒惰的开发员
现阶段，写了一个一键切换页面状态的框架。

1，快速在自己的界面中使用
``` java
StatusView statusView = StatusView.wrap(this)；
```
2，更换自己的各个状态布局，在application中
``` java
StatusViewConfig.CONFIG
	.setConfigErrorResId(R.layout.state_view_error)
	.setConfigEmptyResId(R.layout.state_view_empty)
	.setConfigLoadingResId(R.layout.state_view_loading)
	.setConfigNetWorkErrorResId(R.layout.state_view_network_error);
```

3，只有某个页面的布局文件不一样，但其他页面仍旧保留原有文件
``` java
StatusView statusView = StatusView.wrap(this)
       .setEmptyResId(R.layout.my_empty_layout)
       .setErrorResId(R.layout.my_empty_layout)
       .setLoadingResId(R.layout.my_empty_layout)
       .setNetWorkErrorResId(R.layout.my_empty_layout)
       .setStateViewReloadListener(this);
```
 4.setStateViewReloadListener是点击错误界面的重新加载按钮触发的回调


```
statusView.wrap(this)
	.setStateViewReloadListener(new StatusView.StateViewReloadListener() {
		@Override
		public void onStateViewReloadClicked() {
			//当点击重新加载
		}
	});
```

5.举例，自定义的error_layout与network_error_layout 重新加载的按钮id设置为`@id/reload`

```
 <View
    android:id="@id/reload"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```

### 如何一键切换
|api|功能|
|---|---|
|showLoading()| 加载界面
|showEmpty() | 无数据界面
|showError() | 错误界面
|showNetWorkError() | 网络错误界面
|showContent() | 内容界面 
>statusView.showLoading()就可以了

### 最后
我参考的资源，万分感谢
- [XFrame](https://github.com/youth5201314/XFrame)
- [工匠若水](http://blog.csdn.net/yanbober/article/details/45970721)

其实代码跟XFrame的差不多，但是我想把网络模块也集成在这个框架里，所以我自己写了一个轮子出来，还会再更新。另外，每一行代码干了什么，我都摸透了，这得感谢[若水大大](http://blog.csdn.net/yanbober)
