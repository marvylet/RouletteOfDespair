package levels;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import loading.Loading1;
import loading.Loading2;
import loading.Loading3;
import main.Game;
import main.GameMenu;

import java.util.Random;

/**
 * An abstract class for each Level, where all the parameters, the screen etc. is initialized.
 */
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

    protected boolean pressed;
    protected boolean attemptShootOther;

    protected ImageView npcGrabGun;
    protected ImageView npcShootPlayer;
    protected ImageView npcShootSelf;
    protected ImageView npcDead;

    protected int distracted;

    public Level(int level, int height, int width, Stage stage, GameMenu menu, String imagePath, Inventory inventory, Loading1 loading1, Game game, String playerGrabGunPath, String playerGunSelfPath, String shootCharPath, String npcGrabGunPath, String npcShootPlayerPath, String npcShootSelfPath, String npcDeadPath, int distracted) {
        rd = new Random();
        this.level = level;
        this.height = height;
        this.width = width;
        this.stage = stage;
        this.menu = menu;
        this.game = game;
        this.loading1 = loading1;
        this.distracted = distracted;

        pane = new AnchorPane();
        pane2 = new AnchorPane();
        pane3 = new AnchorPane();
        pane4 = new AnchorPane();
        pane5 = new AnchorPane();
        pane6 = new AnchorPane();
        pane7 = new AnchorPane();
        pane2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        pane3.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        pane4.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        pane5.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        pane6.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        pane7.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        this.inventory = inventory;
        bulletCount = 6;
        bulletFull = rd.nextInt(5) + 1;

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

        ending = new Text("You have survived the game.\nYou may feel guilt over killing other innocent people like this, but...\nIt was worth it. You can pay off your debt now.");
        ending.setFill(Color.WHITE);
        ending.setFont(new Font("Times New Roman", 40));
        AnchorPane.setTopAnchor(ending, 300.0);
        AnchorPane.setRightAnchor(ending, 225.0);

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
        invButton.setOpacity(0);


        image = new ImageView("file:" + imagePath);
        playerGrabGun = new ImageView("file:" + playerGrabGunPath);
        playerGunSelf = new ImageView("file:" + playerGunSelfPath);
        shootChar = new ImageView("file:" + shootCharPath);
        npcGrabGun = new ImageView("file:" + npcGrabGunPath);
        npcShootPlayer = new ImageView("file:" + npcShootPlayerPath);
        npcShootSelf = new ImageView("file:" + npcShootSelfPath);
        npcDead = new ImageView("file:" + npcDeadPath);

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
        //shotGun();
    }

    /**
     * Factory method that will choose and make the level depending on the level integer
     * @param level = number of the level
     * @param height = height of the screen
     * @param width = width of the screen
     * @param stage = the stage that is being used for the game
     * @param menu = the game menu
     * @param inventory = the inventory that's being used in the game
     * @param loading1 = loading screen
     * @param game = the class for the game itself
     * @return = returns a new class depending on the level chosen
     */
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
     * Abstract method for what each NPC does on their turn with the gun.
     * @param boo = true if the player attempted to shoot the NPC
     */
    public abstract void shotGun(boolean boo);

    /**
     * What happens when player presses the gun
     */
    public void shootGun() {
        gun.setOnMouseClicked(e -> {

            pane.getChildren().removeAll(gun, invButton);

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
                pane.getChildren().addAll(gun, invButton);
            });

        });

    }

    /**
     * What happens when player presses to shoot themself
     */
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
                    pressed = false;
                    attemptShootOther = false;

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
                    pressed = true;
                    pane.getChildren().removeAll(back, shootOther, shootSelf);
                    pane.getChildren().addAll(gun, invButton);
                    //Thread.sleep(1000);

                    bulletCount--;
                    shotGun(false);
                }

            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }
        });
    }

    /**
     * What happens when player presses to shoot their opponent
     */
    public void killOther() {
        shootOther.setOnMouseClicked(ex -> {
            try {
                stage.setScene(scene3);
                Thread.sleep(1000);

                stage.setScene(scene5);
                Thread.sleep(1000);

                if (bulletFull == bulletCount) {
                    pressed = false;
                    attemptShootOther = false;

                    background.setVisible(true);
                    stage.setScene(scene6);
                    Thread.sleep(1000);
                    live = true;
                    if (level == 3) {
                        stage.setScene(scene7);
                        Thread.sleep(10000);
                        System.exit(0);
                    } else {
                        level++;
                        game.setLevel(level);
                        if(level == 2) {
                            Loading2 loading2 = new Loading2(level, width, height);
                            stage.setScene(loading2.getScene());
                        }else if(level == 3){
                            Loading3 loading3 = new Loading3(level, width, height);
                            stage.setScene(loading3.getScene());
                        }
                        Thread.sleep(5000);
                        game.start();
                    }
                } else {
                    pressed = true;
                    attemptShootOther = true;
                    bulletCount--;

                    stage.setScene(scene3);
                    Thread.sleep(1000);

                    stage.setScene(scene);
                    pane.getChildren().removeAll(back, shootOther, shootSelf);
                    pane.getChildren().addAll(gun, invButton);
                    if(inventory.isDistraction()){
                        shotGun(false);
                        inventory.setDistraction(false);
                    }else {
                        shotGun(true);
                    }
                    //Thread.sleep(1000);
                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public int getBulletFull() {
        return bulletFull;
    }

    public int getDistracted() {
        return distracted;
    }

    public int getLevel() {
        return level;
    }
}
