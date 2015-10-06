package com.cube.androidtvdemo.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.DetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.view.View;

import com.cube.androidtvdemo.R;
import com.cube.lib.FakeDataManager;
import com.cube.model.RowItem;
import com.cube.presenter.DetailsPresenter;
import com.cube.presenter.ItemPresenter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * // TODO Add class description
 *
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class MyDetailsFragment extends DetailsFragment
{
	private ArrayObjectAdapter mRowsAdapter;
	private RowItem selectedRowItem;

	public static MyDetailsFragment instantiate(RowItem rowItem)
	{
		MyDetailsFragment frag = new MyDetailsFragment();
		frag.setSelectedRowItem(rowItem);
		return frag;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		ClassPresenterSelector selector = new ClassPresenterSelector();
		// Attach your media item details presenter to the row presenter:
		DetailsOverviewRowPresenter rowPresenter = new DetailsOverviewRowPresenter(new DetailsPresenter());

		selector.addClassPresenter(DetailsOverviewRow.class, rowPresenter);
		selector.addClassPresenter(ListRow.class, new ListRowPresenter());
		mRowsAdapter = new ArrayObjectAdapter(selector);

		Resources res = getActivity().getResources();
		final DetailsOverviewRow detailsOverview = new DetailsOverviewRow(selectedRowItem);

		// Add images and action buttons to the details view
		ImageLoader.getInstance().loadImage(selectedRowItem.getImageUrl(), new ImageLoadingListener()
		{
			@Override
			public void onLoadingStarted(String imageUri, View view)
			{

			}

			@Override
			public void onLoadingFailed(String imageUri, View view, FailReason failReason)
			{

			}

			@Override
			public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)
			{
				detailsOverview.setImageBitmap(getActivity(), loadedImage);
			}

			@Override
			public void onLoadingCancelled(String imageUri, View view)
			{

			}
		});
		detailsOverview.addAction(new Action(1, getActivity().getString(R.string.detail_action_first)));
		detailsOverview.addAction(new Action(2, getActivity().getString(R.string.detail_action_second)));
		mRowsAdapter.add(detailsOverview);

		// Add a Related items row
		ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new ItemPresenter());
		listRowAdapter.add(FakeDataManager.getInstance().getRow1().get(0));
		listRowAdapter.add(FakeDataManager.getInstance().getRow1().get(1));
		listRowAdapter.add(FakeDataManager.getInstance().getRow1().get(2));
		HeaderItem header = new HeaderItem(0, getActivity().getString(R.string.detail_header_first));
		mRowsAdapter.add(new ListRow(header, listRowAdapter));

		setAdapter(mRowsAdapter);
	}

	public void setSelectedRowItem(RowItem selectedRowItem)
	{
		this.selectedRowItem = selectedRowItem;
	}
}
