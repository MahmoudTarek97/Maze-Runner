package mazeRunner.themes.theme1;

import mazeRunner.model.mapCells.Way;

public class ashes extends Way {
	
	private final String ashes = "images/ashes.png";

	@Override
	public String getImageLink() {
		return this.ashes;
	}
}
