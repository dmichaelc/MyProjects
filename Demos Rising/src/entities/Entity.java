package entities;

import gamePlayer.DataOnscreen;
import resources.ImageLoader;
import resources.Sprite;

public abstract class Entity {
    
    /** The sprite object that contains the imaget use for rendering.  */
    protected Sprite _sprite;
    
    /** The X coordinate of this entity in pixels from the top left of the 
     * screen.  */
    protected int _x;
    
    /** The Y coordinate of this entity in pixels from the top left of the 
     * screen.  */
    protected int _y;
    
    
    /** The width of the entity's collision detection.  */
    protected int _collisionWidth;
    
    /** The height of the entity's collision detection.  */
    protected int _collisionHeight;
    
    /** The width to render the entity on screen.  */
    protected int _renderWidth;
    
    /** The height to render the entity on screen.  */
    protected int _renderHeight;
    
    
    
    
    public Entity(String imgRef, int x, int y) {
        /** Get the sprite from the image loader. */
        _sprite = ImageLoader.get().getSprite(imgRef);
    }
    
    
    
    
    
    public abstract void update(DataOnscreen onscreenData);
    
    public abstract void render();
    
    
    
    
} // end of class Entity
