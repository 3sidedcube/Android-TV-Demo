package com.cube.androidtvdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;

import com.cube.androidtvdemo.DetailsActivity;
import com.cube.androidtvdemo.R;
import com.cube.lib.FakeDataManager;
import com.cube.model.RowItem;
import com.cube.presenter.ItemPresenter;

/**
 * // TODO Add class description
 *
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class MyBrowseFragment extends BrowseFragment implements OnItemViewClickedListener
{
	private ArrayObjectAdapter mRowsAdapter;
	private static final int NUM_ROWS = 4;

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setTitle("Android TV Demo");
		// Set the main colour used by the app, similar to the 'primary' colour used by mobile apps
		setBrandColor(getResources().getColor(R.color.primary));
		// Set the colour of the search icon - this appears as a FAB-like icon in the top left
		setSearchAffordanceColor(getResources().getColor(R.color.accent));
		setHeadersState(HEADERS_ENABLED);
		setHeadersTransitionOnBackEnabled(true);
		setOnItemViewClickedListener(this);
		createRowsAdapter();
	}

	private void createRowsAdapter()
	{
		mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
		// Add row 1
		ArrayObjectAdapter moviesRowAdapter = new ArrayObjectAdapter(new ItemPresenter());
		for (RowItem rowItem : FakeDataManager.getInstance().getRow1())
		{
			moviesRowAdapter.add(rowItem);
		}
		mRowsAdapter.add(new ListRow(new HeaderItem(0, "Movies"), moviesRowAdapter));
		// Add row 2
		ArrayObjectAdapter tvRowAdapter = new ArrayObjectAdapter(new ItemPresenter());
		for (RowItem rowItem : FakeDataManager.getInstance().getRow2())
		{
			tvRowAdapter.add(rowItem);
		}
		mRowsAdapter.add(new ListRow(new HeaderItem(1, "TV Shows"), tvRowAdapter));
		setAdapter(mRowsAdapter);
	}

	@Override
	public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row)
	{
		Intent i = new Intent(getActivity(), DetailsActivity.class);
		i.putExtra("selected", (RowItem)item);
		startActivity(i);
	}
}
