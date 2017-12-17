package mazeRunner.controller;


import javafx.application.Platform;
import javafx.util.Pair;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.MapBuilder;
import mazeRunner.view.MainMenu;

import java.util.Arrays;
import java.util.List;

public class MainController {
    //this controller will controle main menu actions
    private static MainController controller = new MainController();
    private MainMenu menu;
    private PlayingController playingController = new PlayingController();;
    private MainController(){
        this.menu = new MainMenu();

        menu.setMenuData(this.menuData);
    }

    public static MainController getController(){
        return controller;
    }

    private List<Pair<String, Runnable>> menuData= Arrays.asList(
            new Pair<String, Runnable>("Start Game", playingController),
            //new Pair<String, Runnable>("Game Options", () -> {}),
            //new Pair<String, Runnable>("Tutorial", () -> {}),
            //new Pair<String, Runnable>("Credits", () -> {}),
            new Pair<String, Runnable>("Exit to Desktop", Platform::exit)
    );

    public MainMenu getMenu(){
        return this.menu;
    }

    public void addMenuOption(Pair<String, Runnable> option){
        this.menuData.add(option);
    }
}
