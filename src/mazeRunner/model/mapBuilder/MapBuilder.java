package mazeRunner.model.mapBuilder;

import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.MapCell;

import java.util.HashMap;

public class MapBuilder implements IMapBuilder{
	
	ILevel level;
	Map map;
	HashMap<MapCell, Integer> mapElementsType;
	private static MapBuilder builder = new MapBuilder();
	
	public static MapBuilder createMapBuilder(){
		return builder;
	}
	
	@Override
	public Map getMap() {
		//TODO: implement method logic
		MazeGenerator mazeGenerator = new MazeGenerator(level.getMapSize());
		boolean[][] maze = mazeGenerator.generateMaze();
		MapGenerator mapGenerator = new MapGenerator(maze, level.getSupportedMapCellsCounts(), level);
		return mapGenerator.generateMap();
	}
	
	@Override
	public void setLevel(ILevel level) {
		this.level = level;
	}
	
	
}
