package mazeRunner.model.levels;

public class Level1 extends Level{

	public Level1(){
		this.mapSize = new MapSize(10, 10);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = 1;
		this.numberOfCheckPoints = 1;
	}
	
}
