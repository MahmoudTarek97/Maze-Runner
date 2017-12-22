package mazeRunner.model.mapBuilder;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import mazeRunner.model.mapCells.CellFactory;
import mazeRunner.model.mapCells.CheckPoint;
import mazeRunner.model.mapCells.Gate;
import mazeRunner.model.mapCells.IGift;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.themes.warTheme.Bullets1;

public class MapGenerator {

	private MapCell[][] maze;
	private Map map;
	java.util.Map<String, Integer> mapElementType;
	int numberOfNeededBullets = 0;
	CellFactory factory = new CellFactory();
	Stack<Point> allFreeCells = new Stack<>();
	public MapGenerator( Map map) {
		this.map = map;
		this.mapElementType = map.getLevel().getSupportedMapCellsCounts();
		this.maze = new MapCell[map.getBooleanMaze().length][map.getBooleanMaze()[0].length];
		map.setCellsLayer(this.maze);
		GenerateCheckPoint.map = map;
		GenerateCheckPoint.generate();

			}

	public Point getRandomCell(Stack<Point> allFreeCells) {
		Collections.shuffle(allFreeCells);
		return new Point(allFreeCells.pop());

	}
	public void setWallsAndWays() throws Exception {
		MapCell[][] solidWallAndWaysLayer = new MapCell[map.getBooleanMaze().length][map.getBooleanMaze()[0].length];
		for (int i = 0; i < map.getBooleanMaze().length; i++) {

			for (int j = 0; j < map.getBooleanMaze()[0].length; j++) {

				if (map.getBooleanMaze()[i][j]) {

					this.maze[i][j] = factory.getUndestroyableWall();
					solidWallAndWaysLayer[i][j] = factory.getUndestroyableWall();

				}
				else {

					if(!(map.getCellsLayer()[i][j] instanceof CheckPoint)) {
						this.maze[i][j] = factory.getWay(); // if it is check point donot put way
					}
					solidWallAndWaysLayer[i][j] = factory.getWay();
					if((i != 1 || j != 1)&& !(map.getCellsLayer()[i][j] instanceof CheckPoint)) {
						allFreeCells.add(new Point(i, j));
					}

				}
			}
		}
		map.setSolidWallAndWaysLayer(solidWallAndWaysLayer);

	}
	public Map generateMap() throws Exception {

		ArrayList<String> classesName = new ArrayList<>();
		for (int i = 0; i < map.getLevel().getSupportedMapCells().size(); i++) {
			classesName.add(map.getLevel().getSupportedMapCells().get(i).getName());
		}
		factory.setClasses(classesName);
		setWallsAndWays();
		for (java.util.Map.Entry<String, Integer> entry : this.mapElementType.entrySet()) {
			MapCell cell = factory.getInstanceByClassName(entry.getKey());
			for (int i = 0; i < entry.getValue(); i++) {
				Point randomCell = getRandomCell(allFreeCells);
				maze[randomCell.x][randomCell.y] = cell;
				if (cell.isObstacle() || (cell.isWall() && cell.isDestroyable() == true)) {
					numberOfNeededBullets += cell.getHealth();
				}
			}
		}
		generateBulletsGift();
		addGate();
		return  map;
	}
	public void generateBulletsGift() throws Exception {
		Bullets1 initial = new Bullets1();
		numberOfNeededBullets = numberOfNeededBullets - initial.getOneBulletDamage() * 6;
		int bulletsRunHas = 6*initial.getOneBulletDamage();

		while (numberOfNeededBullets > 0) {
			MapCell cell =	factory.getGiftDestroysObstacles();
			DistributeRandomGifts randomGifts = new DistributeRandomGifts(maze, numberOfNeededBullets, bulletsRunHas);
			Point random = randomGifts.getRandomPoint();
			maze[random.x][random.y] = cell;
			int damage = ((IGift) cell).getOneBulletDamage() *  ((IGift) cell).getBulletsNumber();
			numberOfNeededBullets = numberOfNeededBullets - damage;
			bulletsRunHas += damage;
		}
	}
	
	private void addGate(){
		Point end = map.getEndPoint();
		_2DArrayIterator iterator = new _2DArrayIterator(map.getCellsLayer());
		while(iterator.hasNext()){
			MapCell cell = (MapCell) iterator.next();
			if (iterator.rowIndex() == end.getX() && iterator.columnIndex() == end.getY()) {
				try {
					maze[end.x][end.y] = new Gate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}


