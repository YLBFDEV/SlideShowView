package io.github.ylbfdev.slideshowview.utils;

import android.content.Context;

import java.io.File;

/**
 * @author YLBF
 * 
 * @category 类说明 文件缓存工具类
 * @version 修改时间 2015年7月17日下午1:48:55
 * @version 版本号 1.0.0.0
 */
public class FileCache {
	private File cacheDir;

	public FileCache(Context context) {
		// 判断外存SD卡挂载状态，如果挂载正常，创建SD卡缓存文件夹
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			cacheDir = new File(
					android.os.Environment.getExternalStorageDirectory(),
					"CacheDir");
		} else {
			// SD卡挂载不正常，获取本地缓存文件夹（应用包所在目录）
			cacheDir = context.getCacheDir();
		}
		creatDir();
	}

	/**
	 * 创建文件夹
	 * 
	 * @return
	 */
	public boolean creatDir() {
		if (!cacheDir.exists()) {
			cacheDir.mkdirs();
			System.out.println("文件夹不存在创建目录");
			return true;
		} else {
			return false;
		}
	}

	public File getFile(String url) {
		String fileName = String.valueOf(url.hashCode());
		creatDir();
		File file = new File(cacheDir, fileName);
		return file;
	}

	public void clear() {
		File[] files = cacheDir.listFiles();
		for (File f : files)
			f.delete();
	}

	public String getCacheSize() {
		long size = 0;
		if (cacheDir.exists()) {
			File[] files = cacheDir.listFiles();
			for (File f : files) {
				size += f.length();
			}
		}
		String cacheSize = String.valueOf(size / 1024 / 1024) + "M";
		return cacheSize;
	}

}
