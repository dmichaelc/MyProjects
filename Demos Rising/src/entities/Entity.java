package entities;

import gamePlayer.Data_Onscreen;
import resources.Sprite;

public abstract class Entity {
    
    /**  */
    Sprite _sprite;
    
    /** The X coordinate of this entity in pixels from the top left of the 
     * screen.  */
    int _x;
    
    /** The Y coordinate of this entity in pixels from the top left of the 
     * screen.  */
    int _y;
    
    
    /**  */
    protected int _collisionWidth;
    
    /**  */
    protected int _collisionHeight;
    
    
    protected int _renderWidth;
    
    protected int _renderHeight;
    
    
    
    
    public abstract void update(Data_Onscreen onscreenData);
    
    public abstract void render();
    
    
    
    
} // end of class Entity
