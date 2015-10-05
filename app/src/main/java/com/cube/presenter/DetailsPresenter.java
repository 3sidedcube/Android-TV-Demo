package com.cube.presenter;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.cube.model.RowItem;

/**
 * // TODO Add class description
 *
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class DetailsPresenter extends AbstractDetailsDescriptionPresenter
{
	@Override
	protected void onBindDescription(ViewHolder vh, Object item)
	{
		vh.getTitle().setText(((RowItem)item).getName());
		vh.getSubtitle().setText(((RowItem)item).getSubtitle());
		vh.getBody().setText(((RowItem)item).getDescription());
	}
}
