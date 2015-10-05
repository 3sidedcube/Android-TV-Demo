package com.cube.presenter;

import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cube.androidtvdemo.R;
import com.cube.model.RowItem;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * // TODO Add class description
 *
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class ItemPresenter extends Presenter
{
	public ViewHolder onCreateViewHolder(ViewGroup parent)
	{
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_item, parent, false);
		view.setFocusable(true);
		view.setFocusableInTouchMode(true);
		return new ViewHolder(view);
	}

	public void onBindViewHolder(ViewHolder viewHolder, Object item)
	{
		((TextView)viewHolder.view.findViewById(R.id.title)).setText(((RowItem)item).getName());
		ImageLoader.getInstance().displayImage(((RowItem)item).getImageUrl(), ((ImageView)viewHolder.view.findViewById(R.id.image)));
	}

	public void onUnbindViewHolder(Presenter.ViewHolder viewHolder)
	{
		// Not used
	}
}
