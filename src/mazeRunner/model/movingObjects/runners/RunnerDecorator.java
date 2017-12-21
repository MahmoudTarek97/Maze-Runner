package mazeRunner.model.movingObjects.runners;

import java.awt.Point;
import java.util.List;

import mazeRunner.model.weapons.Weapon;

public  class RunnerDecorator implements IRunner{

	protected final IRunner decoratedRunner;
	
	public RunnerDecorator(IRunner runner){
		this.decoratedRunner = runner;
	}
	


	@Override
	public void moveUp() {
		decoratedRunner.moveUp();
	}

	@Override
	public void moveDown() {
		decoratedRunner.moveDown();
		
	}

	@Override
	public void moveRight() {
		decoratedRunner.moveDown();
		
	}

	@Override
	public void moveLeft() {
		decoratedRunner.moveLeft();
		
	}

	@Override
	public void setDirection(int direction) {
		decoratedRunner.setDirection(direction);
		
	}

	@Override
	public int getDirection() {
		return decoratedRunner.getDirection();
	}

	@Override
	public void setPosition(Point position) {
		decoratedRunner.setPosition(position);
	}

	@Override
	public Point getPosition() {
		return decoratedRunner.getPosition();
	}

	@Override
	public void setImageLinks(String imageLinks) {
		decoratedRunner.setImageLinks(imageLinks);
		
	}

	@Override
	public String getImageLinks() {
		return decoratedRunner.getImageLinks();
	}

	@Override
	public void setMappedPosition(Point mappedPosition) {
		decoratedRunner.setMappedPosition(mappedPosition);
		
	}

	@Override
	public Point getMappedPosition() {
		return decoratedRunner.getMappedPosition();
	}

	@Override
	public String getLayer() {
		return "movingObjectsLayerPane";
	}

	@Override
	public void setHealth(int health) {
		decoratedRunner.setHealth(health);
		
	}

	@Override
	public int getHealth() {
		return decoratedRunner.getHealth();
	}

	@Override
	public List<Weapon> getSupportedWeapons() {
		return decoratedRunner.getSupportedWeapons();
	}

	@Override
	public void setSupportedWeapons(List<Weapon> supportedWeapons) {
		decoratedRunner.setSupportedWeapons(supportedWeapons);
		
	}



	@Override
	public void setSpeedState(SpeedState speedState) {
		decoratedRunner.setSpeedState(speedState);
		
	}



	@Override
	public SpeedState getSpeedState() {
		return decoratedRunner.getSpeedState();
	}



	@Override
	public Weapon hasWeapon(String WeaponName) {
		return decoratedRunner.hasWeapon(WeaponName);
	}


	@Override
	public Weapon getCurrentWeapon() {
		return decoratedRunner.getCurrentWeapon();
	}

	@Override
	public void setCurrentWeapon(Weapon currentWeapon) {
		decoratedRunner.setCurrentWeapon(currentWeapon);	
	}



	@Override
	public Weapon getNextWeapon() {
		return decoratedRunner.getNextWeapon();
	}



	@Override
	public Weapon getPrevWeapon() {
		return decoratedRunner.getPrevWeapon();
	}
	
}
