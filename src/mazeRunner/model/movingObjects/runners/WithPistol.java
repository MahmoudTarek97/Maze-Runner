package mazeRunner.model.movingObjects.runners;

import java.util.List;

import mazeRunner.model.weapons.Weapon;
import mazeRunner.model.weapons.WeaponFactory;

public class WithPistol extends RunnerDecorator {

	public WithPistol(IRunner runner, int ammo) {
		super(runner);
		Weapon newWeapon = new WeaponFactory().getWeapon("Pistol", ammo);
		List<Weapon> supportedWeapons = super.getSupportedWeapons();
		supportedWeapons.add(newWeapon);
		super.setSupportedWeapons(supportedWeapons);
	}

}
