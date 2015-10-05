package com.cube.androidtvdemo;

import android.app.Activity;
import android.os.Bundle;

import com.cube.androidtvdemo.fragment.MyBrowseFragment;

/**
 * // TODO Add class description
 *
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_holder);
		getFragmentManager()
				.beginTransaction()
				.replace(R.id.fragment_holder, new MyBrowseFragment())
				.commit();
	}
}
