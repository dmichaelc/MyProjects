package gamePlayer;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import resources.ImageLoader;
import resources.Screen;
import resources.Sprite;

/** This class handles all of the  */
public class LevelManager extends Screen {
    
    
    
    
    Sprite test = ImageLoader.get().getSprite("assets\\image\\TestEnemy01.png");
    int xOffset = 0;
    /**  */
    public void update() {
        
    }
    
    /** Handles the rendering of everything currently on screen in the level. */
    public void render(Graphics g) {
        test.draw(g, 100 + xOffset, 100);
    }
    
    
    
    @Override
    public boolean hasNewScreen() {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public Screen getNewScreen() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleKeyEvent(KeyEvent event) {
        // TODO Auto-generated method stub
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            xOffset++;
        }
        
    }
    
    
    
    
}
