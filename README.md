# SlideShowView
ViewPager实现的轮播图广告自定义视图； 既支持自动轮播页面也支持手势滑动切换页面,可以动态设置图片的张数
本地缓存目录为SD卡应用缓存目录下的 CacheDir文件夹

##PagerAdapter用法简介

首先，如果继承pageradapter，至少必须重写下面的四个方法 
> `instantiateItem(ViewGroup, int)`
> `destroyItem(ViewGroup, int, Object)`
>
> `getCount()`
>
> `isViewFromObject(View, Object)` 
>

下面我们以代码的形式，说明这四个方法的含义以及如何使用


```java

private class ViewPagerAdapter extends PagerAdapter {

		// 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
		@Override
		public int getCount() {
			return images.size();
		}

		// 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		// PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			view.removeView(images.get(position));
		}

		// 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			view.addView(images.get(position));
			return images.get(position);
		}
	}

```