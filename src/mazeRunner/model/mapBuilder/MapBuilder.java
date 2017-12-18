package mazeRunner.model.mapBuilder;

import mazeRunner.model.GameSetting;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.movingObjects.runners.IRunner;

import java.util.HashMap;

public class MapBuilder implements IMapBuilder{
	
	ILevel level;
	Map map = new Map();
	HashMap<MapCell, Integer> mapElementsType;
	private static MapBuilder builder = new MapBuilder();
	public static MapBuilder createMapBuilder() {
		return builder;
	}
	
	@Override
	public Map getMap() throws Exception {
		MazeGenerator mazeGenerator = new MazeGenerator(level.getMapSize());
		boolean[][] maze = mazeGenerator.generateMaze();
		GetEndPoint end = new GetEndPoint(maze);
		map.setLevel(level);
		map.setEndPoint(end.getEnd());
		map.setCorrectWay(end.getCorrectWay());
		//map.setRunnerInitalPosition();
		MapGenerator mapGenerator = new MapGenerator(maze, map);
		map = mapGenerator.generateMap();
		return map;
	}

	@Override
	public void setLevel(ILevel level) {
		this.level = level;
	}
	@Override
	public Map getGeneratedMap(){
		return map;
	}



}
