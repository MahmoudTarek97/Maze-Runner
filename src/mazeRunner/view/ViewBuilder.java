package mazeRunner.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import mazeRunner.controller.PlayingController;
import mazeRunner.view.mapCellsView.MapCellView;
import mazeRunner.view.mapCellsView.Recources;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class ViewBuilder extends Pane{
    private Recources recources = Recources.getRecources();
    private BorderPane borderPane = new BorderPane();
    private ScrollPane mainPane = new ScrollPane();
    private Pane map = new Pane();
    private Label score = new Label("          Score    ");
    private Label bulletsNm = new Label("Bullets Number : ");
    private ImageView weapon ;
    private Label weaponname = new Label();

    private Label remainingLifes = new Label();
    private ProgressBar healthBar = new ProgressBar();
    private HBox parametersBarPane = new HBox();
    private GridPane cellsLayerPane = new GridPane();
    private GridPane movingObjectsLayerPane = new GridPane();
    private GridPane solidWallAndWaysLayerPane = new GridPane();
    private MapCellView nodeCell;
    private static ViewBuilder viewBuilder = new ViewBuilder();

    private ViewBuilder() {
    
        borderPane.setTop(parametersBarPane);
        movingObjectsLayerPane.setStyle("-fx-background-color: transparent");
        cellsLayerPane.setStyle("-fx-background-color: transparent");
        movingObjectsLayerPane.setStyle("-fx-background-color: transparent");
        movingObjectsLayerPane.setGridLinesVisible(false);
        cellsLayerPane.setGridLinesVisible(false);
        map.getChildren().add(solidWallAndWaysLayerPane);
        map.getChildren().add(cellsLayerPane);
        map.getChildren().add(movingObjectsLayerPane);
        mainPane.setContent(map);
    }

    public static ViewBuilder getViewBuilder(){
        return viewBuilder;
    }

    public void putCellInCellsLayer(MapCellView nodeCell, int row, int column,String imageLink){
        ImageView image = recources.getImage(imageLink);
        image.setFitWidth(60);
        image.setFitHeight(60);
        nodeCell.setImage(image);
        cellsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInMovingObjectsLayer(MapCellView nodeCell, int row, int column,String imageLink){ // TODO
        ImageView image = recources.getImage(imageLink);
        image.setFitWidth(20);
        image.setFitHeight(20);
        nodeCell.setImage(image);
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void moveObject(MapCellView nodeCell, int row, int column,String imageLink){ // TODO
        ImageView image = recources.getImage(imageLink);
        image.setFitWidth(20);
        image.setFitHeight(20);
        nodeCell.setImage(image);
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInMovingObjectsLayer(MapCellView nodeCell, int row, int column, javafx.scene.image.ImageView imageView){ // TODO
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        nodeCell.setImage(imageView);
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInMovingObjectsLayer(MapCellView nodeCell, int row, int column){ //TODO
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInSolidWallAndWaysLayer(MapCellView nodeCell, int row, int column,String imageLink){
        ImageView image = recources.getImage(imageLink);
        image.setFitWidth(60);
        image.setFitHeight(60);
        nodeCell.setImage(image);
        solidWallAndWaysLayerPane.add(nodeCell,column,row);
    }

    public void removeFromMovingGrid(MapCellView node){
        movingObjectsLayerPane.getChildren().remove(node);
    }
    public void removeFromCellsGrid(MapCellView node){
        cellsLayerPane.getChildren().remove(node);
    }
    public void removeFromSolidWallsGrid(MapCellView node){
        solidWallAndWaysLayerPane.getChildren().remove(node);
    }

    public BorderPane getPlayingPane(int bullets , String imageWeapon , String wn){
    	this.bulletsNm.setText("bullets number :" + bullets);
    	System.out.println(imageWeapon);
    	this.weapon = new ImageView("file:"+imageWeapon);
    	weaponname.setText("weapon name : "+wn);
    	weapon.setFitWidth(10);
    	weapon.setFitHeight(10);
    	this.score.setText("    score :" + PlayingController.score+"      ");
        healthBar.resize(20,100);
        healthBar.setProgress(1);
        mainPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        mainPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        borderPane.setCenter(mainPane);
        parametersBarPane.getChildren().clear();
        parametersBarPane.getChildren().add(healthBar);

        parametersBarPane.getChildren().add(this.bulletsNm);
        parametersBarPane.getChildren().add(this.score);
        parametersBarPane.getChildren().add(this.weaponname);

        parametersBarPane.getChildren().add(this.weapon);

        //parametersBarPane.getChildren().add(remainingLifes);
        return this.borderPane;
    }
    public void clearViewBuilder(){
        solidWallAndWaysLayerPane.getChildren().clear();
        movingObjectsLayerPane.getChildren().clear();
        cellsLayerPane.getChildren().clear();
    }
    public ProgressBar getHealthBar(){
        return healthBar;
    }
    public HBox getParametersBarPane(int x , String y , String wn){
    	weaponname.setText("weapon name : "+wn);

    	this.bulletsNm.setText("bullets number :" + x);
    	System.out.println(y);
    	this.weapon = new ImageView("file:"+x);
    	weapon.setFitWidth(10);
    	weapon.setFitHeight(10);
    	this.score.setText("    score :" + PlayingController.score+"      ");
    	 parametersBarPane.getChildren().clear();
         parametersBarPane.getChildren().add(healthBar);
         parametersBarPane.getChildren().add(this.bulletsNm);
         parametersBarPane.getChildren().add(this.score);
         parametersBarPane.getChildren().add(this.weaponname);

         parametersBarPane.getChildren().add(this.weapon);
        return this.parametersBarPane;
    }
    public Label getScoreTextField(){
        return this.score;
    }
    public Label getRemainingLifesTextField(){
        return this.remainingLifes;
    }
}

