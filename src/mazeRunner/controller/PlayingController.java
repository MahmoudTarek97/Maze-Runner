package mazeRunner.controller;

import mazeRunner.model.levels.ILevelFactory;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.MapBuilder;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class PlayingController implements Runnable {
    private IMapBuilder mapBuilder;
    private ILevelFactory levelFactory;
    public static BuildingController buildingController;
    private MovingController movingController;
    public static int score = 0;
    public static int collectedGifts = 0;
    public static int remainingLives = 3;
    public PlayingController(){
        mapBuilder = MapBuilder.createMapBuilder();
        levelFactory = new ILevelFactory();
    }
    @Override
    public  void run() {
        int i = 1;

        mapBuilder.setLevel(levelFactory.getLevel(i));
        try {
            buildingController = new BuildingController(mapBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int x = 0;
        movingController = new MovingController();
        buildingController.updateSolidWallAndWaysLayerPane();
        updateView();
        ////
        long lStartTime = System.nanoTime();

        movingController.actionHandeling();
        //TODO

    }

    public void updateView(){
        buildingController.updateCellsLayerPane();
        buildingController.updatemovingObjectsLayerPane();
    }
    public void getSnapShot() {
        SettingController setting = new SettingController();
        //setting.gameSetting.getCurrentRunner() = (IRunner) (GetSnapShot.getRunner());
    }
}
