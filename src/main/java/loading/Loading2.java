package loading;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * A loading screen that appears once the player progresses to level 2
 */
public class Loading2 {
    private VBox vbox;
    private Scene scene;
    private Text lore;
    private Text levelInfo;
    private AnchorPane pane;
    private int level;

    public Loading2(int level, int width, int height) {
        this.level = level;

        pane = new AnchorPane();
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        scene = new Scene(pane, width, height);

        lore = new Text("You have beaten your first opponent,\nNext up, you're against a man called Oscar.\nYou just wish to have this finally over with.\n\n");
        lore.setFill(Color.WHITE);
        lore.setFont(new Font("Times New Roman", 40));

        levelInfo = new Text("Round " + level);
        levelInfo.setFill(Color.WHITE);
        levelInfo.setFont(new Font("Times New Roman", 40));

        vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(vbox, 250.0);
        AnchorPane.setLeftAnchor(vbox, 300.0);
        vbox.getChildren().addAll(lore, levelInfo);
        pane.getChildren().add(vbox);
    }

    public Scene getScene() {
        return scene;
    }
}
