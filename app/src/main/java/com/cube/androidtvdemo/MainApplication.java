package com.cube.androidtvdemo;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * This class only exists to instantiate the image loader used for better managing of images
 *
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class MainApplication extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
				.defaultDisplayImageOptions(options)
				.build();
		ImageLoader.getInstance().init(config);
	}
}
