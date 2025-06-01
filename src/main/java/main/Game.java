package main;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import levels.Inventory;
import levels.Level;
import loading.Loading1;

/**
 * Class where everything about the game is initialized, including individual levels, inventory etc.
 */
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
        inventory = new Inventory(width, height, backButton(), this);


    }

    /**
     * Starts up the level depending on its number and sets the scene/screen as the level's.
     */
    public void start(){
        levelClass = Level.factory(level, height, width, stage, menu, inventory, loading1, this);
        stage.setScene(levelClass.getScene());
    }

    /**
     * A back button which will return the player back to the main game screen.
     * @return - returns the button after everything about it is initialized.
     */
    public Button backButton() {
        backButton.setPrefWidth(720);
        backButton.setPrefHeight(100);
        backButton.setOnMouseClicked(e -> {
            stage.setScene(levelClass.getScene());
            inventory.getItem1UseText().setVisible(false);
            inventory.getItem2UseText().setVisible(false);
            inventory.getItem3UseText().setVisible(false);
        });
        return backButton;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBulletCount(){
        return levelClass.getBulletCount();
    }

    public int getBulletFull(){
        return levelClass.getBulletFull();
    }

    public int getDistracted(){
        return levelClass.getDistracted();
    }

    public int getLevel(){
        return levelClass.getLevel();
    }
}
