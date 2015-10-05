package com.cube.model;

import java.io.Serializable;

/**
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class RowItem implements Serializable
{
	private String name, imageUrl, subtitle, description;

	public RowItem(String name, String imageUrl, String subtitle, String description)
	{
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.subtitle = subtitle;
	}

	public String getName()
	{
		return name;
	}

	public String getImageUrl()
	{
		return imageUrl;
	}

	public String getDescription()
	{
		return description;
	}

	public String getSubtitle()
	{
		return subtitle;
	}
}
