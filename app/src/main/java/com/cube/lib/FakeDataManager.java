package com.cube.lib;

import com.cube.model.RowItem;

import java.util.ArrayList;
import java.util.List;

/**
 * This is just convenient singleton to contain all of the fake data needed in the catalogue
 *
 * @author Matt Allen
 * @project AndroidTvDemo
 */
public class FakeDataManager
{
	private static final String DUMMY_DESCRIPTION =
	"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam et mollis velit. " +
			"Duis vehicula est eu nisl pharetra tempor. Cras a laoreet lorem, vel " +
			"tempus dui. Suspendisse potenti. Class aptent taciti sociosqu ad litora " +
			"torquent per conubia nostra, per inceptos himenaeos. Phasellus vel mi " +
			"lobortis, tempor felis vitae, euismod ante. Fusce maximus lacinia sem " +
			"at dapibus. Suspendisse potenti. Ut venenatis ligula vel metus cursus, " +
			"egestas dapibus magna auctor. Sed porta ipsum non tincidunt aliquam. " +
			"Sed ultrices sagittis consectetur. Curabitur eu arcu nisi. Aliquam " +
			"fringilla mattis ornare.\n\n"+
			"Sed lacinia faucibus ante sed pharetra. Ut non finibus erat. " +
			"Nullam eu nunc non quam malesuada dapibus. Cras accumsan et ipsum " +
			"sed mattis. In ullamcorper venenatis faucibus. Donec sollicitudin " +
			"porta dignissim. Maecenas non tellus a turpis pulvinar dignissim " +
			"quis a neque. Aliquam vulputate magna ac dolor euismod, eget condimentum " +
			"metus tincidunt. Pellentesque mollis metus vitae enim finibus, a ultrices velit fermentum.";

	private static FakeDataManager instance;

	private List<RowItem> row1, row2;

	public static FakeDataManager getInstance()
	{
		if (instance == null)
		{
			synchronized (FakeDataManager.class)
			{
				if (instance == null)
				{
					instance = new FakeDataManager();
				}
			}
		}
		return instance;
	}

	public FakeDataManager()
	{
		// Construct row one (Movies)
		row1 = new ArrayList<>();
		row1.add(new RowItem("Mad Max Fury Road", "https://cdn.amctheatres.com/Media/Default/images/maxresdefault.jpg", "2015", DUMMY_DESCRIPTION));
		row1.add(new RowItem("Terminator Genisys", "http://blogs-images.forbes.com/scottmendelson/files/2015/09/arnold_schwarzenegger_terminator_genisys-wide-1940x1212.jpg", "2015", DUMMY_DESCRIPTION));
		row1.add(new RowItem("Spectre", "http://assets1.ignimgs.com/2015/03/28/spectre1208141280jpg-398894_1280w.jpg", "2015", DUMMY_DESCRIPTION));
		row1.add(new RowItem("Tomorrowland", "http://i.kinja-img.com/gawker-media/image/upload/iiwuqsqudreabkdqln3u.jpg", "2015", DUMMY_DESCRIPTION));
		row1.add(new RowItem("The Amazing Spiderman 2", "http://www.blastr.com/sites/blastr/files/Spider2_1.jpg", "2014", DUMMY_DESCRIPTION));

		// Construct row 2 (TV)
		row2 = new ArrayList<>();
		row2.add(new RowItem("South Park", "http://2.images.southparkstudios.com/default/image.jpg?quality=20", "1999 - 2015", DUMMY_DESCRIPTION));
		row2.add(new RowItem("Game of Thrones", "http://cdn1.vox-cdn.com/assets/4229567/game-of-thrones-poster_85627-1920x1200.jpg", "2011 - 2015", DUMMY_DESCRIPTION));
		row2.add(new RowItem("Once Upon A Time", "http://1.bp.blogspot.com/-YmwGK0fb3Uw/VAPYwKyBurI/AAAAAAABWUo/ZG9F4V6r2_0/s1600/11174851.jpg", "2011 - 2015", DUMMY_DESCRIPTION));
		row2.add(new RowItem("Narcos", "https://scdn.nflximg.net/images/9834/21939834.jpg", "2015", DUMMY_DESCRIPTION));
		row2.add(new RowItem("Last Week Tonight", "https://liebermannolie.files.wordpress.com/2015/08/john-oliver.jpg", "2014 - 2015", DUMMY_DESCRIPTION));
	}

	public List<RowItem> getRow1()
	{
		return row1;
	}

	public List<RowItem> getRow2()
	{
		return row2;
	}
}
