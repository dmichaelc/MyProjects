package player;

import resources.ScreenManager;

public class GameMain {


    public static void main(String[] args) {
        LevelPlayer player = new LevelPlayer();
        
        ScreenManager manager = new ScreenManager(player);
        
        manager.startSreenManager();
    }

}
