package mazeRunner.model.mapCells;

import mazeRunner.model.weapons.Weapon;

public interface IGift {
/**
 * returns the type of the gift (weapon , health , bullets)
 * all of the returned strings are declared in the contract
 */
public int getGiftType();
/**
 * returns the class of the weapon if the gift is weapon , null otherwise
 */
public Class<? extends Weapon> getWeaponClass();
/**
 * returns the number of the bullets if the gift is a bullet
 */
public int getBulletsNumber();

/**
 * returns the damage of the single bullet
 */
public int getOneBulletDamage();
/**
 * returns the health to give to the runner
 */
public int getGivenHealth();
/**
 * returns the score if coins 
 */
public int getScore();

}
