package mazeRunner.themes.customTheme;


import mazeRunner.model.GameSetting;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Obstacle;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.themes.warTheme.LandAshes;

public class CustomBomb extends Obstacle  {
	private MapCell afterUpdate = null;
	private final String standardImageLink = GameSetting.getGameSetting().getCustomMapCellImageLink("CustomBomb");


	private final String destroySound = "file:mazeRunner.themes.theme1.media.soundEffects.bombdestroy";
	private final String hittingSound = "file:mazeRunner.themes.theme1.media.soundEffects.bombdestroy";
	private  int health = 1;
	private int damage = 3 ;
	

	@Override
	public String getDestroyingSound() {
		return this.destroySound;
	}

	@Override
	public String getHittingSound() {
		return this.hittingSound;
	}

	@Override
	public int getHealth() {
		return this.health;
	}




	@Override
	public boolean update(int fullDamage) {
		this.health -= fullDamage;
		if(this.getHealth()<=0){
			this.afterUpdate = new LandAshes();
			return true;
		}
		return false;
	}

	@Override
	public MapCell getUpdateResult() {
		return this.afterUpdate;
	}

	@Override
	public String getImageLink() {
		return this.standardImageLink;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}

	@Override
	public int getBombType() {
		return GameContract.BombsTypes.DECREASES_HEALTH;
	}

	@Override
	public int getBombDamage() {
		return this.damage;
	}

	@Override
	public int getBombScore() {
		return -1;
	}



}
