package levels;

import javafx.stage.Stage;
import loading.Loading1;
import main.Game;
import main.GameMenu;

public class Level1 extends Level {

    public Level1(int level, int height, int width, Stage stage, GameMenu menu, Loading1 loading1, Game game, String imagePath, Inventory inventory, String playerGrabGunPath, String playerGunSelfPath, String shootCharPath) {
        super(level, height, width, stage, menu, imagePath, inventory, loading1, game, playerGrabGunPath, playerGunSelfPath, shootCharPath);


    }
}
