package levels;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import loading.Loading1;
import main.Game;
import main.GameMenu;

import java.util.Random;

public abstract class Level {
    protected int level;
    protected int height;
    protected int width;
    protected Stage stage;
    protected GameMenu menu;
    protected ImageView image;
    protected Scene scene;
    protected AnchorPane pane;
    protected Button invButton;
    protected Inventory inventory;
    protected Rectangle background;
    protected Button backButton;
    protected int bulletCount;
    protected int bulletFull;
    protected Button gun;
    protected Random rd;
    protected Text shootSelf;
    protected Text shootOther;
    protected Text back;
    protected boolean live;
    protected Text endDied;
    protected Text endLived;
    protected Text ending;

    protected ImageView playerGrabGun;
    protected ImageView playerGunSelf;
    protected ImageView shootChar;

    protected Scene scene2;
    protected AnchorPane pane2;
    protected Scene scene3;
    protected AnchorPane pane3;
    protected Scene scene4;
    protected AnchorPane pane4;
    protected Scene scene5;
    protected AnchorPane pane5;
    protected Scene scene6;
    protected AnchorPane pane6;
    protected Scene scene7;
    protected AnchorPane pane7;

    protected Game game;
    protected Loading1 loading1;

    public Level(int level, int height, int width, Stage stage, GameMenu menu, String imagePath, Inventory inventory, Loading1 loading1, Game game, String playerGrabGunPath, String playerGunSelfPath, String shootCharPath) {
        rd = new Random();
        this.level = level;
        this.height = height;
        this.width = width;
        this.stage = stage;
        this.menu = menu;
        this.game = game;
        this.loading1 = loading1;

        pane = new AnchorPane();
        pane2 = new AnchorPane();
        pane3 = new AnchorPane();
        pane4 = new AnchorPane();
        pane5 = new AnchorPane();
        pane6 = new AnchorPane();
        pane7 = new AnchorPane();
        this.inventory = inventory;
        bulletCount = 6;
        //bulletFull = rd.nextInt(5) + 1;
        bulletFull = 6;

        shootSelf = new Text("Shoot yourself");
        shootOther = new Text("Shoot them");
        back = new Text("Go back");

        shootSelf.setFill(Color.BLACK);
        shootSelf.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(shootSelf, 50.0);
        AnchorPane.setLeftAnchor(shootSelf, 50.0);


        shootOther.setFill(Color.BLACK);
        shootOther.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(shootOther, 50.0);
        AnchorPane.setLeftAnchor(shootOther, 600.0);

        back.setFill(Color.BLACK);
        back.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(back, 50.0);
        AnchorPane.setRightAnchor(back, 50.0);

        endDied = new Text("You have died.");
        endDied.setFill(Color.WHITE);
        endDied.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(endDied, 350.0);
        AnchorPane.setRightAnchor(endDied, 650.0);

        ending = new Text("You have survived.");
        ending.setFill(Color.WHITE);
        ending.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(ending, 350.0);
        AnchorPane.setRightAnchor(ending, 650.0);

        endLived = new Text("You have survived.");
        endLived.setFill(Color.WHITE);
        endLived.setFont(new Font("Times New Roman", 60));
        AnchorPane.setTopAnchor(endLived, 350.0);
        AnchorPane.setRightAnchor(endLived, 650.0);

        gun = new Button();
        gun.setPrefWidth(200);
        gun.setPrefHeight(200);
        gun.setOpacity(0);
        AnchorPane.setLeftAnchor(gun, 650.0);
        AnchorPane.setTopAnchor(gun, 500.0);

        invButton = new Button();
        invButton.setPrefWidth(200);
        invButton.setPrefHeight(200);
        AnchorPane.setLeftAnchor(invButton, 200.0);
        AnchorPane.setTopAnchor(invButton, 600.0);
        invButton.setOnMouseClicked(e -> {
            stage.setScene(inventory.getScene());
        });


        image = new ImageView("file:" + imagePath);
        playerGrabGun = new ImageView("file:" + playerGrabGunPath);
        playerGunSelf = new ImageView("file:" + playerGunSelfPath);
        shootChar = new ImageView("file:" + shootCharPath);

        background = new Rectangle(1440, 810);
        background.setFill(Color.BLACK);

        endDied.setVisible(false);

        pane.getChildren().addAll(image, invButton, gun);
        scene = new Scene(pane, width, height);

        pane2.getChildren().addAll(background, endDied);
        scene2 = new Scene(pane2, width, height);

        pane3.getChildren().add(playerGrabGun);
        pane4.getChildren().add(playerGunSelf);
        pane5.getChildren().add(shootChar);
        pane6.getChildren().addAll(background, endLived);
        pane7.getChildren().addAll(background, ending);

        scene3 = new Scene(pane3, width, height);
        scene4 = new Scene(pane4, width, height);
        scene5 = new Scene(pane5, width, height);
        scene6 = new Scene(pane6, width, height);
        scene7 = new Scene(pane7, width, height);
        shootGun();
        cutsceneDeath();
        killOther();
        alive();
    }

    public static Level factory(int level, int height, int width, Stage stage, GameMenu menu, Inventory inventory, Loading1 loading1, Game game) {
        return switch (level) {
            case 2 ->
                    new Level2(level, height, width, stage, menu, loading1, game, "resource/levels/level2/level2.png", inventory, "resource/levels/level2/playGrab.png", "resource/levels/level2/playerShootSelf.png", "resource/levels/level2/shootOther.png");
            case 3 ->
                    new Level3(level, height, width, stage, menu, loading1, game, "resource/levels/level3/level3.png", inventory, "resource/levels/level3/playGrab.png", "resource/levels/level3/playerShootSelf.png", "resource/levels/level3/shootOther.png");
            default ->
                    new Level1(level, height, width, stage, menu, loading1, game, "resource/levels/level1/level1.png", inventory, "resource/levels/level1/playGrab.png", "resource/levels/level1/playerShootSelf.png", "resource/levels/level1/shootOther.png");
        };
    }

    public Scene getScene() {
        return scene;
    }

    /**
     * What happens when player presses the gun
     *
     * @return = returns true if player died
     */
    public boolean shootGun() {
        gun.setOnMouseClicked(e -> {
            pane.getChildren().remove(gun);

            pane.getChildren().addAll(shootSelf, shootOther, back);

            shootSelf.setOnMouseEntered(ex -> {
                shootSelf.setUnderline(true);
            });
            shootSelf.setOnMouseExited(ex -> {
                shootSelf.setUnderline(false);
            });

            shootOther.setOnMouseEntered(ex -> {
                shootOther.setUnderline(true);
            });
            shootOther.setOnMouseExited(ex -> {
                shootOther.setUnderline(false);
            });


            back.setOnMouseEntered(ex -> {
                back.setUnderline(true);
            });
            back.setOnMouseExited(ex -> {
                back.setUnderline(false);
            });
            back.setOnMouseClicked(ex -> {
                pane.getChildren().removeAll(back, shootOther, shootSelf);
                pane.getChildren().add(gun);
            });

        });
        return true;

    }

    public void cutsceneDeath() {
        shootSelf.setOnMouseClicked(ex -> {
            try {
                playerGrabGun.toFront();
                playerGunSelf.toFront();
                background.toFront();

                stage.setScene(scene3);
                Thread.sleep(1000);

                stage.setScene(scene4);
                Thread.sleep(1000);

                if (bulletFull == bulletCount) {
                    background.setVisible(true);
                    background.toFront();
                    endDied.setVisible(true);
                    endDied.toFront();

                    stage.setScene(scene2);
                    Thread.sleep(10000);
                    System.exit(0);
                } else {
                    stage.setScene(scene3);
                    Thread.sleep(1000);

                    stage.setScene(scene);
                    Thread.sleep(1000);

                    bulletCount--;
                }

            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }
        });
    }

    public void killOther() {
        shootOther.setOnMouseClicked(ex -> {
            try {
                stage.setScene(scene3);
                Thread.sleep(1000);

                stage.setScene(scene5);
                Thread.sleep(1000);

                if (bulletFull == bulletCount) {
                    background.setVisible(true);
                    stage.setScene(scene6);
                    Thread.sleep(10000);
                    live = true;
                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void alive() {
        try {
            if (live && level == 3) {
                stage.setScene(scene7);
                Thread.sleep(10000);
                System.exit(0);
            } else if (live) {
                level++;
                game.setLevel(level);
                stage.setScene(loading1.getScene());
                Thread.sleep(5000);
                game.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
