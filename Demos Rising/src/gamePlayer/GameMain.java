package gamePlayer;

import resources.ScreenManager;

public class GameMain {


    public static void main(String[] args) {
        LevelManager player = new LevelManager();
        
        ScreenManager manager = new ScreenManager(player);
        
        manager.startSreenManager();
    }

}
