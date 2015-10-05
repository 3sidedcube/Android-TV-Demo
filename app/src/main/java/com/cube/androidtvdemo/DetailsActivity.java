package com.cube.androidtvdemo;

import android.app.Activity;
import android.os.Bundle;

import com.cube.androidtvdemo.fragment.MyDetailsFragment;
import com.cube.model.RowItem;

/**
 * // TODO Add class description
 *
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class DetailsActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_holder);
		RowItem item = (RowItem)getIntent().getExtras().get("selected");
		getFragmentManager()
				.beginTransaction()
				.replace(R.id.fragment_holder, MyDetailsFragment.instantiate(item))
				.commit();
	}
}
