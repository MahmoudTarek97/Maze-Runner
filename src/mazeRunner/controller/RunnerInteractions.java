package mazeRunner.controller;

import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.IBombs;
import mazeRunner.model.mapCells.IGift;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Obstacle;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.WithA4;
import mazeRunner.model.movingObjects.runners.WithAK;
import mazeRunner.model.movingObjects.runners.WithPistol;
import mazeRunner.model.movingObjects.runners.WithSpaceGun1;
import mazeRunner.model.movingObjects.runners.WithSpaceGun2;
import mazeRunner.model.movingObjects.runners.WithSpaceGun3;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.model.weapons.Weapon;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class RunnerInteractions {
  
    Map map;
    IRunner runner;
    MapCell runnerCell;
    int runnerMappedPositionX;
    int runnerMappedPositionY;
    BuildingController buildingController;
    public RunnerInteractions(BuildingController buildingController, Map map){
    	this.buildingController = buildingController;
        this.map = map;
        this.runner = map.getRunner();
        
    }

    public void update(){
    	runnerMappedPositionX = runner.getMappedPosition().x;
    	runnerMappedPositionY = runner.getMappedPosition().y;
    	System.out.println("mapped position : " + runnerMappedPositionX + " "+ runnerMappedPositionY);
    	System.out.println("position : " + runner.getPosition().x +" "+  runner.getPosition().y);
        runnerCell = map.getCellsLayer()[runnerMappedPositionX][runnerMappedPositionY];
        if(isThereAnAction()){
            performAction(getAction());
        }
    }

    private boolean isThereAnAction(){
        //see if there is any thing in that position
    	return runnerCell instanceof Obstacle || runnerCell instanceof Gifts;
    }

    private void runnerGiftInteraction(){
        //runner gift interaction logic will be here
    	IGift gift = (IGift) runnerCell;
    	int giftType = gift.getGiftType();
    	System.out.println("hit with" + gift);
    	if(giftType == GameContract.GiftsTypes.HEALTH){
    		if(runner.getHealth() + gift.getGivenHealth() <= 100){
    			runner.setHealth(runner.getHealth() + gift.getGivenHealth());	
    		}else{
    			runner.setHealth(100);
    		}
    		System.out.println(runner.getHealth());
    	}else if(giftType == GameContract.GiftsTypes.COIN){
    		PlayingController.score += gift.getScore();
    		System.out.println(PlayingController.score);
    	}else if(giftType == GameContract.GiftsTypes.WEAPON){
    		String weaponName = gift.getWeaponClass().getSimpleName();
    		System.out.println(weaponName);
    		Weapon weapon;
    		if((weapon = runner.hasWeapon(weaponName)) == null) {
				if(weaponName.equals("Pistol")){
					runner = new WithPistol(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with Pistol");
				}else if(weaponName.equals("AK")){
					runner = new WithAK(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with AK");
				}else if(weaponName.equals("A4")){
					runner = new WithA4(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with A4");
				}else if(weaponName.equals("spaceGun1")){
					runner = new WithSpaceGun1(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with spaceGun1");
				}else if(weaponName.equals("spaceGun2")){
					runner = new WithSpaceGun2(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with spaceGun2");
				}else if(weaponName.equals("spaceGun3")){
					runner = new WithSpaceGun3(runner, gift.getBulletsNumber(),gift.getOneBulletDamage());
					System.out.println("decorator with spaceGun3");
				}
			}else{
				weapon.setFullAmmo();
			}
    		System.out.println(runner.getSupportedWeapons());

    	}else if(giftType == GameContract.GiftsTypes.BULLETS){
    		// TODO : add bullets to runner current weapon
    	}
    	map.addCellAtRunTime(runnerCell.getUpdateResult(), runnerMappedPositionX, runnerMappedPositionY);
    	buildingController.removeFromCellsLayer(runnerMappedPositionX, runnerMappedPositionY);
    	System.out.println(runnerCell);
    }

    private void runnerBombInteraction(){
        //runner bomb interaction will be here
    	System.out.println("hit with" + runnerCell);
    	IBombs bomb = (IBombs) runnerCell;
    	int bombType = bomb.getBombType();
    	if(bombType == GameContract.BombsTypes.DECREASES_HEALTH){
    		runner.setHealth(runner.getHealth() - bomb.getBombDamage());
    		System.out.println(runner.getHealth());
    	}else if(bombType == GameContract.BombsTypes.DECREASES_SCORE){
    		PlayingController.score -= bomb.getBombScore();
    		System.out.println(PlayingController.score);
    	}
    	map.addCellAtRunTime(runnerCell.getUpdateResult(), runnerMappedPositionX, runnerMappedPositionY);
    	buildingController.removeFromCellsLayer(runnerMappedPositionX, runnerMappedPositionY);
    	
    }

    private void performAction(String action){
        //perform specific action based on its name
    	if(action == "BombAction"){
    		runnerBombInteraction();
    	}else if(action == "GiftAction"){
    		runnerGiftInteraction();
    	}

    }



    private String getAction(){
        // return the name of action
    	if(runnerCell instanceof Obstacle){
    		return "BombAction";
    	}else if(runnerCell instanceof Gifts){
    		return "GiftAction";
    	}
    	return null;
    }
   
}
