package main;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import levels.Inventory;
import loading.Loading1;

/**
 * A class for creating the menu when game is started, player can choose to start game or exit
 */
public class GameMenu {
    private Stage stage;
    private int width;
    private int height;
    private Scene scene;
    private AnchorPane pane;
    private Text gameTitle;
    private Text startText;
    private Text endText;
    private VBox vBox;
    private ImageView background;

    /**
     * Initializes all values, creates the whole menu
     * @param stage = The stage that shows each scene on the screen
     */
    public GameMenu(Stage stage) {
        this.stage = stage;
        this.width = 1400;
        this.height = 800;
        pane = new AnchorPane();
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        scene = new Scene(pane, width, height);
        background = new ImageView("file:resource/menu/menuBackground.png");

        gameTitle = new Text("Roulette of Despair");
        gameTitle.setFill(Color.WHITE);
        gameTitle.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(gameTitle, 150.0);
        AnchorPane.setLeftAnchor(gameTitle, 450.0);


        buttons();

        vBox = new VBox();
        vBox.setSpacing(20.0);
        AnchorPane.setTopAnchor(vBox, 350.0);
        AnchorPane.setLeftAnchor(vBox, 600.0);
        vBox.getChildren().addAll(startText, endText);

        pane.getChildren().addAll(background, vBox, gameTitle);


        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Creates all the buttons in the menu
     */
    private void buttons(){
        startText = new Text("Start Game");
        startText.setFill(Color.WHITE);
        startText.setFont(new Font("Times New Roman", 40));

        startText.setOnMouseEntered(e -> {
            startText.setUnderline(true);
        });

        startText.setOnMouseExited(e -> {
            startText.setUnderline(false);
        });

        startText.setOnMouseClicked(e -> {
            try {
                start(1);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        endText = new Text("End Game");
        endText.setFill(Color.WHITE);
        endText.setFont(new Font("Times New Roman", 40));

        endText.setOnMouseEntered(e -> {
            endText.setUnderline(true);
        });

        endText.setOnMouseExited(e -> {
            endText.setUnderline(false);
        });

        endText.setOnMouseClicked(e -> {
            System.exit(0);
        });

    }

    /**
     * Shows at first the loading screen and then starts up the game.
     * @param level = number of the current level that's being played
     * @throws InterruptedException = throws out an exception if something goes wrong (due to Thread.sleep())
     */
    private void start(int level) throws InterruptedException {
        Loading1 loading = new Loading1(level, width, height);
        stage.setScene(loading.getScene());
        Game game = new Game(level, height, width, stage, this);
        Thread.sleep(10000);

        game.start();
    }
}
