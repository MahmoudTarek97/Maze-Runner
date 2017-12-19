package mazeRunner.model.movingObjects.monsters;

import java.awt.Point;

import mazeRunner.model.utilities.GameContract;

public abstract class Monster implements IMonster{
	private int speed;
	private int direction;
	private Point position;
	// position on runner layer
	private Point mappedPosition;
	private int health;
	//imageLink{UP, Down, Right, Left}
	private String imageLinks;

	
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setDirection(int direction) {
		this.direction = direction;
		
	}

	@Override
	public int getDirection() {
		return direction;
	}

	@Override
	public void moveUp() {
		this.direction = GameContract.Direction.UP;
		// TODO : implement movement
	}

	@Override
	public void moveDown() {
		this.direction = GameContract.Direction.DOWN;
		// TODO : implement movement
	}

	@Override
	public void moveRight() {
		this.direction = GameContract.Direction.RIGHT;
		// TODO : implement movement
	}

	@Override
	public void moveLeft() {
		this.direction = GameContract.Direction.LEFT;
		// TODO : implement movement
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void setPosition(Point position) {
		this.position = position;
		
	}

	@Override
	public void setHealth(int health) {
		this.health = health;
		
	}

	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public String getImageLinks() {
		return imageLinks;
	}

	@Override
	public void setImageLinks(String imageLinks) {
		this.imageLinks = imageLinks;
	}
	
	@Override
	public void setMappedPosition(Point mappedPosition) {
		this.mappedPosition = mappedPosition;
		
	}

	@Override
	public Point getMappedPosition() {
		return mappedPosition;
		
	}

	@Override
	public String getLayer(){
		return "movingObjectsLayerPane";
	}
}
