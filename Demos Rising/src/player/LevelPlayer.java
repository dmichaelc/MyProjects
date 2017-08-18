package player;

import java.awt.Graphics;

import resources.ImageLoader;
import resources.Sprite;

/** This class handles all of the  */
public class LevelPlayer {
    
    
    
    
    Sprite test = ImageLoader.get().getSprite("assets\\image\\TestEnemy01.png");
    
    /**  */
    public void update() {
        
    }
    
    /** Handles the rendering of everything currently on screen in the level. */
    public void render(Graphics g) {
        test.draw(g, 100, 100);
    }
    
    
    
    
}
