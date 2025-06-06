package levels;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import loading.Loading1;
import loading.Loading2;
import loading.Loading3;
import main.Game;
import main.GameMenu;


public class Level1 extends Level {

    private AnchorPane pane8;
    private Scene scene8;
    private AnchorPane pane9;
    private Scene scene9;
    private AnchorPane pane10;
    private Scene scene10;
    private AnchorPane pane11;
    private Scene scene11;

    public Level1(int level, int height, int width, Stage stage, GameMenu menu, Loading1 loading1, Game game, String imagePath, Inventory inventory, String playerGrabGunPath, String playerGunSelfPath, String shootCharPath) {
        super(level, height, width, stage, menu, imagePath, inventory, loading1, game, playerGrabGunPath, playerGunSelfPath, shootCharPath, "resource/levels/level1/npcGrabGun.png", "resource/levels/level1/npcShootPlayer.png", "resource/levels/level1/npcShootSelf.png", "resource/levels/level1/npcDead.png", 6);

        pane8 = new AnchorPane();
        pane8.getChildren().addAll(npcGrabGun);
        scene8 = new Scene(pane8, width, height);

        pane9 = new AnchorPane();
        pane9.getChildren().addAll(npcShootPlayer);
        scene9 = new Scene(pane9, width, height);

        pane10 = new AnchorPane();
        pane10.getChildren().addAll(npcShootSelf);
        scene10 = new Scene(pane10, width, height);

        pane11 = new AnchorPane();
        pane11.getChildren().addAll(npcDead);
        scene11 = new Scene(pane11, width, height);

        bulletFull = rd.nextInt(5) + 1;


    }


    @Override
    public void shotGun(boolean boo) {
        try {

            pane.getChildren().removeAll(gun, invButton);
            if (boo) {
                stage.setScene(scene8);
                Thread.sleep(1000);

                stage.setScene(scene9);
                Thread.sleep(1000);

                if (bulletFull == bulletCount) {
                    //pressed = false;

                    background.setVisible(true);
                    background.toFront();
                    endDied.setVisible(true);
                    endDied.toFront();

                    stage.setScene(scene2);
                    Thread.sleep(10000);
                    System.exit(0);
                } else {
                    bulletCount--;

                    stage.setScene(scene8);
                    Thread.sleep(1000);

                    stage.setScene(scene);
                    pane.getChildren().addAll(gun, invButton);
                    pressed = false;
                    //Thread.sleep(1000);
                }
            } else {
                stage.setScene(scene8);
                Thread.sleep(1000);

                stage.setScene(scene10);
                Thread.sleep(1000);

                if (bulletFull == bulletCount) {
                    level++;
                    pressed = false;
                    game.setLevel(level);
                    stage.setScene(scene11);
                    Thread.sleep(5000);

                    if(level == 2) {
                        Loading2 loading2 = new Loading2(level, width, height);
                        stage.setScene(loading2.getScene());
                    }else if(level == 3){
                        Loading3 loading3 = new Loading3(level, width, height);
                        stage.setScene(loading3.getScene());
                    }
                    Thread.sleep(7000);
                    game.start();

                } else {
                    bulletCount--;
                    pressed = false;

                    stage.setScene(scene8);
                    Thread.sleep(1000);

                    stage.setScene(scene);
                    pane.getChildren().addAll(gun, invButton);
                    //Thread.sleep(1000);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
