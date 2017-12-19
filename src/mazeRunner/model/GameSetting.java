package mazeRunner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mazeRunner.model.levels.MapSize;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.Runner1;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class GameSetting {

	/** shared setting (for all the game) **/
	private IRunner currentRunner = new Runner1();
	private List<Class<? extends IRunner>> supportedRunners = new ArrayList<Class<? extends IRunner>>();
	
	
	/** custom level setting **/
	private MapSize customMapize = new MapSize(15, 15);
	private int customRunnerSpeed = 1;
	private Map<String, String> customMapCellsImageLinks = new HashMap<String, String>() {
		{
			put("CustomBomb", "images/Dynamite.png");
			put("CustomDestroyableWall", "images/box.png");
			put("CustomHealthGift", "images/medicine.png");
			put("CustomSolidWall", "images/wall.png");
			put("CustomWay", "images/land.jpg");
		}
	};

	private static GameSetting gameSetting = new GameSetting();

	public static GameSetting getGameSetting() {
		return gameSetting;
	}

	public IRunner getCurrentRunner() {
		return currentRunner;
	}

	public void setCurrentRunner(IRunner currentRunner) {
		this.currentRunner = currentRunner;
	}

	public List<Class<? extends IRunner>> getSupportedRunners() {
		return supportedRunners;
	}

	private void setSupportedRunners() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		String packageBinName = "mazeRunner.model.movingObjects.runners.";
		try {
			supportedRunners.add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner1")));
			supportedRunners.add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner2")));
			supportedRunners.add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner3")));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



	public MapSize getCustomMapize() {
		return customMapize;
	}

	public void setCustomMapize(MapSize customMapize) {
		this.customMapize = customMapize;
	}

	public int getCustomRunnerSpeed() {
		return customRunnerSpeed;
	}

	public void setCustomRunnerSpeed(int customRuunerSpeed) {
		this.customRunnerSpeed = customRuunerSpeed;
	}

	public String getCustomMapCellImageLink(String CustomMapCellName){
		return customMapCellsImageLinks.get(CustomMapCellName);
	}

	
	public void addCustomMapCellImageLink(String CustomMapCellName){
		// TODO : Dynamic Linkage
	}
	
	public void addRunner() {
		// TODO : Dynamic Linkage
	}

}