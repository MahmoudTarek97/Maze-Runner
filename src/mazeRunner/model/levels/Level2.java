package mazeRunner.model.levels;

public class Level2 extends Level {

	public Level2(){
		setSize(new MapSize(50, 50));
		setTheme(1);
		setSupportedMapCells();
		setObstacleCount(15);
		setNonObstacleCount(17);
		setRunnerSpeed(20);
	}
}
