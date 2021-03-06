package mazeRunner.controller;


import java.util.Arrays;
import java.util.List;

import javafx.application.Platform;
import javafx.util.Pair;
import mazeRunner.view.MainMenu;

public class MainController {
    //this controller will control main menu actions
    private static MainController controller = new MainController();
    private MainMenu menu;
    private CustemOrLevelController Custom = CustemOrLevelController.getController();
    private SettingController settingController = new SettingController();
    private MainController(){
        this.menu = new MainMenu();
        menu.setMenuData(this.menuData);
    }

    public static MainController getController(){
        return controller;
    }

    private List<Pair<String, Runnable>> menuData= Arrays.asList(
            new Pair<String, Runnable>("Start Game", Custom),
            new Pair<String, Runnable>("Game Setting", settingController),
            new Pair<String, Runnable>("Credits", () -> {}),
            new Pair<String, Runnable>("Exit to Desktop", Platform::exit)
    );

    public MainMenu getMenu(){
        return this.menu;
    }

    public void addMenuOption(Pair<String, Runnable> option){
        this.menuData.add(option);
    }
}
