package levels;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.Game;

import java.util.Random;

/**
 * A class for the player's inventory once they press the button to show it in game.
 */
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

    private boolean item1use;
    private boolean item2use;
    private boolean item3use;

    private Text item1UseText;
    private Text item2UseText;
    private Text item3UseText;

    private Random rd;

    private boolean distraction;

    private Game game;

    public Inventory(int width, int height, Button backButton, Game game) {
        pane = new AnchorPane();
        scene = new Scene(pane, width, height);
        item1 = new Button();
        item2 = new Button();
        item3 = new Button();
        this.game = game;
        rd = new Random();

        item1UseText = new Text();
        item2UseText = new Text();
        item3UseText = new Text();

        distraction = false;
        item1use = true;
        item2use = true;
        item3use = true;

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

        item1Text = new Text("Shows if there's a bullet in the current barrel.");
        item1Text.setFill(Color.BLACK);
        item1Text.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(item1Text, 50.0);
        AnchorPane.setLeftAnchor(item1Text, 200.0);
        item1Text.setVisible(false);

        item2Text = new Text("Distracts the opponent.");
        item2Text.setFill(Color.BLACK);
        item2Text.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(item2Text, 50.0);
        AnchorPane.setLeftAnchor(item2Text, 500.0);
        item2Text.setVisible(false);

        item3Text = new Text("Shows how many slots are left in the barrel.");
        item3Text.setFill(Color.BLACK);
        item3Text.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(item3Text, 50.0);
        AnchorPane.setLeftAnchor(item3Text, 200.0);
        item3Text.setVisible(false);

        pane.getChildren().addAll(imageView, backButton, item1, item2, item3, item1Text, item2Text, item3Text);

        item1.setOpacity(0);
        item2.setOpacity(0);
        item3.setOpacity(0);
        backButton.setOpacity(0);

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

        whatItemsDo();
    }

    /**
     * Initializes what each item does once clicked.
     */
    public void whatItemsDo(){
        item1.setOnMouseClicked(e -> {
            if(item1use){
                if(game.getBulletCount() == game.getBulletFull()){
                    item1UseText.setText("There's a bullet in the current barrel.");
                    item1UseText.setFill(Color.BLACK);
                    item1UseText.setFont(new Font("Times New Roman", 40));
                    AnchorPane.setTopAnchor(item1UseText, 550.0);
                    AnchorPane.setLeftAnchor(item1UseText, 425.0);
                    item1UseText.setVisible(true);
                    item2UseText.setVisible(false);
                    item3UseText.setVisible(false);
                    pane.getChildren().add(item1UseText);
                    item1use = false;
                }else{
                    item1UseText.setText("There is not a bullet in the current barrel.");
                    item1UseText.setFill(Color.BLACK);
                    item1UseText.setFont(new Font("Times New Roman", 40));
                    AnchorPane.setTopAnchor(item1UseText, 600.0);
                    AnchorPane.setLeftAnchor(item1UseText, 350.0);
                    item1UseText.setVisible(true);
                    item2UseText.setVisible(false);
                    item3UseText.setVisible(false);
                    pane.getChildren().add(item1UseText);
                    item1use = false;
                }
            }
        });

        item2.setOnMouseClicked(e -> {
            if(item2use){
                item2UseText.setFont(new Font("Times New Roman", 40));
                item2UseText.setFill(Color.BLACK);
                AnchorPane.setTopAnchor(item2UseText, 600.0);
                AnchorPane.setLeftAnchor(item2UseText, 150.0);
                item2UseText.setVisible(true);
                item3UseText.setVisible(false);
                item1UseText.setVisible(false);

                if(game.getLevel() == 1) {

                    int distract = rd.nextInt(6) + 1;
                    if(game.getDistracted() >= distract) {
                        distraction = true;

                        item2UseText.setText("The opponent has been distracted for the round and won't try to shoot.");

                        pane.getChildren().add(item2UseText);
                        item2use = false;
                    }else{
                        distraction = false;
                        item2UseText.setText("Failed to distract the opponent.");
                        pane.getChildren().add(item2UseText);
                        item2use = false;
                    }

                }else if(game.getLevel() == 2){

                    int distract = rd.nextInt(2) + 1;

                    if(game.getDistracted() >= distract) {
                        distraction = true;

                        item2UseText.setText("The opponent has been distracted for the round and won't try to shoot.");

                        pane.getChildren().add(item2UseText);
                        item2use = false;
                    }else{
                        distraction = false;
                        item2UseText.setText("Failed to distract the opponent.");
                        pane.getChildren().add(item2UseText);
                        item2use = false;
                    }

                }else if (game.getLevel() == 3){
                    int distract = rd.nextInt(2) + 1;

                    if(game.getDistracted() == distract) {
                        distraction = true;

                        item2UseText.setText("The opponent has been distracted for the round and won't try to shoot.");

                        pane.getChildren().add(item2UseText);
                        item2use = false;
                    }else{
                        distraction = false;
                        item2UseText.setText("Failed to distract the opponent.");
                        pane.getChildren().add(item2UseText);
                        item2use = false;
                    }
                }
            }
        });

        item3.setOnMouseClicked(e -> {
            if(item3use){
                item3UseText.setText("There are currently " + game.getBulletCount() + " bullet slots in the barrel.");
                item3UseText.setFill(Color.BLACK);
                item3UseText.setFont(new Font("Times New Roman", 40));
                AnchorPane.setTopAnchor(item3UseText, 600.0);
                AnchorPane.setLeftAnchor(item3UseText, 350.0);
                item3UseText.setVisible(true);
                item2UseText.setVisible(false);
                item1UseText.setVisible(false);
                pane.getChildren().add(item3UseText);
                item3use = false;
            }
        });
    }

    public Scene getScene() {
        return scene;
    }

    public Text getItem1UseText() {
        return item1UseText;
    }

    public Text getItem2UseText() {
        return item2UseText;
    }

    public Text getItem3UseText() {
        return item3UseText;
    }

    public boolean isDistraction() {
        return distraction;
    }

    public void setDistraction(boolean distraction) {
        this.distraction = distraction;
    }
}
