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
 * A loading screen that appears once the player progresses to level 3.
 */
public class Loading3 {
    private VBox vbox;
    private Scene scene;
    private Text lore;
    private Text levelInfo;
    private AnchorPane pane;
    private int level;

    public Loading3(int level, int width, int height) {
        this.level = level;

        pane = new AnchorPane();
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        scene = new Scene(pane, width, height);

        lore = new Text("Your final opponent is waiting, Paige.\nShe's not as easy to fool as the other two...\nAfter this, you'll finally win. Don't mess up.\n\n");
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

    public Scene getScene(){
        return scene;
    }

}
