package com.ylbf.slideshowview.testactivity;

import android.app.Activity;
import android.os.Bundle;

import com.ylbf.slideshowview.R;

import java.util.ArrayList;
import java.util.List;

import io.github.ylbfdev.slideshowview.SlideShowView;

/**
 * 声明：由于此案例仅是一个Demo，故在此就没有使用UIL进行处理图片，本案例重点不在于防止OOM，重点在于轮播图片 仅限用于学习交流。
 * 
 * @author YLBF
 *
 */
public class MainActivity extends Activity {

	private SlideShowView mSlideShowView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * 设置图片主要是传入图片路径，可以是int类型的，也 可以像博客中的一样，传入String类型的
		 */
		List<String> imageUris = new ArrayList<String>();
		imageUris.add("http://imglf2.nosdn.127.net/img/UnpBWE5OekhRQ3BhbVhvWDBXZmVDVWpKdVM5WStLUE8.jpg?imageView&thumbnail=720x0&quality=100");
		imageUris.add("http://imglf0.nosdn.127.net/img/RG9mOEw1SFFmalhRTDFjQ3BvK0xFbjBXamJPZnBVdS8.jpg?imageView&thumbnail=720x0&quality=100");
		imageUris.add("http://imglf.nosdn.127.net/img/RjJFQlhYK3RnaTR0RmE1bE1XSjBjVlhZM0NFbDNRcW0.jpg?imageView&thumbnail=720x0&quality=100");
		imageUris.add("http://imglf2.nosdn.127.net/img/UnpBWE5OekhRQ3BhbVhvWDBXZmVDVlRsYkJHSHJLbFc.jpg?imageView&thumbnail=720x0&quality=100");
		imageUris.add("http://imglf2.nosdn.127.net/img/ZkU1aE1BZzdpaVdibXgvalZ3ZHpHVFFkWmtMTENZeVE.jpg?imageView&thumbnail=720x0&quality=100");
		imageUris.add("http://imglf0.ph.126.net/-zQKAxLa9vuhCUu4lHbGbA==/2879489011768067718.jpg?imageView&thumbnail=720x0&quality=100");
		/**
		 * 获取控件
		 */
		mSlideShowView = (SlideShowView) findViewById(R.id.slideshowView);
		/**
		 * 为控件设置图片
		 */
		mSlideShowView.setImageUris(imageUris);

	}
}
