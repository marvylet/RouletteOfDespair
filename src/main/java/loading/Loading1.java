package loading;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * A class for the loading screen at the beginning of the game.
 */
public class Loading1 {
    private VBox vbox;
    private Scene scene;
    private Text lore;
    private Text levelInfo;
    private AnchorPane pane;
    private int level;

    public Loading1(int level, int width, int height) {

        this.level = level;

        pane = new AnchorPane();
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        scene = new Scene(pane, width, height);

        lore = new Text("You appear in a place unknown to you,\nYou're forced to play games of russian roulette against unknown opponents...\nHowever, if you win, you'll finally be able to pay of your debt.\n\n");
        lore.setFill(Color.WHITE);
        lore.setFont(new Font("Times New Roman", 40));

        levelInfo = new Text("Round " + level);
        levelInfo.setFill(Color.WHITE);
        levelInfo.setFont(new Font("Times New Roman", 40));

        vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(vbox, 250.0);
        AnchorPane.setLeftAnchor(vbox, 100.0);
        vbox.getChildren().addAll(lore, levelInfo);
        pane.getChildren().add(vbox);

    }

    public Scene getScene(){
        return scene;
    }

}
