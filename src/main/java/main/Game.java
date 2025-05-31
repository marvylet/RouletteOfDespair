package main;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import levels.Inventory;
import levels.Level;
import loading.Loading1;

public class Game {
    private int level;
    private int height;
    private int width;
    private Stage stage;
    private GameMenu menu;
    private Level levelClass;
    private Inventory inventory;
    private Button backButton;
    private Loading1 loading1;

    public Game(int level, int height, int width, Stage stage, GameMenu menu) {
        this.level = level;
        this.height = height;
        this.width = width;
        this.stage = stage;
        this.menu = menu;

        backButton = new Button();
        inventory = new Inventory(width, height, backButton());

        levelClass = Level.factory(level, height, width, stage, menu, inventory, loading1, this);


    }

    public void start(){
        stage.setScene(levelClass.getScene());
    }

    public Button backButton() {
        backButton.setPrefWidth(720);
        backButton.setPrefHeight(100);
        backButton.setOnMouseClicked(e -> {
            stage.setScene(levelClass.getScene());
        });
        return backButton;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
