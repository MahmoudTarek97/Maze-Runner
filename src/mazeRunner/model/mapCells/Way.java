package mazeRunner.model.mapCells;

public abstract class Way implements MapCell {

	@Override
	public boolean isWall(){
		return false;
	}

	@Override

	public boolean isNonObstacle(){
		return false;
	}
	@Override
	public boolean isObstacle() {
		return false;
	}
	@Override
	public boolean isWay(){
		return true;
	}
	
	@Override
	public int getHealth() {
		throw new UnsupportedOperationException("making health for the ground is unsupported yet");
	}

	@Override
	public boolean isDestroyable() {
		return false;
	}
	@Override
	public String getDestroyingSound() {
		throw new UnsupportedOperationException("making the ground destroyable object is not supported yet");
	}

	@Override
	public boolean isCauseDamage(){
		return false;
	}
	@Override
	public String getHittingSound() {
		throw new UnsupportedOperationException("hitting the ground  is not supported yet");
	}

	@Override
	public int getDamage() {
		throw new UnsupportedOperationException("making the ground causes damages is not supported yet");//Flammable cells or something like that
	}
	@Override
	public MapCell getUpdateResult() {
		return null;
	}
	@Override
	public boolean update(int fullDamage) {
		return false;
	}

}
