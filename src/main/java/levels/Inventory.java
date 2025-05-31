package levels;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Inventory {

    private Scene scene;
    private AnchorPane pane;
    private Button backButton;
    private ImageView imageView;
    private Button item1;
    private Button item2;
    private Button item3;
    private Text item1Text;
    private Text item2Text;
    private Text item3Text;

    public Inventory(int width, int height, Button backButton) {
        pane = new AnchorPane();
        scene = new Scene(pane, width, height);
        item1 = new Button();
        item2 = new Button();
        item3 = new Button();

        item1.setPrefWidth(250);
        item1.setPrefHeight(350);
        AnchorPane.setLeftAnchor(item1, 50.0);
        AnchorPane.setTopAnchor(item1, 200.0);

        item2.setPrefWidth(400);
        item2.setPrefHeight(350);
        AnchorPane.setLeftAnchor(item2, 520.0);
        AnchorPane.setTopAnchor(item2, 200.0);

        item3.setPrefWidth(250);
        item3.setPrefHeight(350);
        AnchorPane.setRightAnchor(item3, 75.0);
        AnchorPane.setTopAnchor(item3, 200.0);

        this.backButton = backButton;
        imageView = new ImageView("file:resource/inv/invBackground.png");

        AnchorPane.setTopAnchor(backButton, 675.0);
        AnchorPane.setLeftAnchor(backButton, 350.0);

        item1Text = new Text("blablabla");
        item1Text.setFill(Color.BLACK);
        item1Text.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(item1Text, 50.0);
        AnchorPane.setLeftAnchor(item1Text, 550.0);
        item1Text.setVisible(false);

        item2Text = new Text("jajajaj");
        item2Text.setFill(Color.BLACK);
        item2Text.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(item2Text, 50.0);
        AnchorPane.setLeftAnchor(item2Text, 550.0);
        item2Text.setVisible(false);

        item3Text = new Text("eeeeeee");
        item3Text.setFill(Color.BLACK);
        item3Text.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(item3Text, 50.0);
        AnchorPane.setLeftAnchor(item3Text, 550.0);
        item3Text.setVisible(false);

        pane.getChildren().addAll(imageView, backButton, item1, item2, item3, item1Text, item2Text, item3Text);

        item1.setOnMouseEntered(e -> {
            item1Text.setVisible(true);
        });
        item1.setOnMouseExited(e -> {
            item1Text.setVisible(false);
        });

        item2.setOnMouseEntered(e -> {
            item2Text.setVisible(true);
        });
        item2.setOnMouseExited(e -> {
            item2Text.setVisible(false);
        });

        item3.setOnMouseEntered(e -> {
            item3Text.setVisible(true);
        });
        item3.setOnMouseExited(e -> {
            item3Text.setVisible(false);
        });

    }

    public Scene getScene() {
        return scene;
    }
}
