package resources;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/** A screen is defined as some object that needs updating and needs rendering.
 * Screen objects define methods to update their contents, render them, and
 * switch to a new screen object if necessary. */
public interface Screen {
    
    /** This function is called whenever updates to a given screen need to be
     * applied. An example would be calling it once per frame.  */
    public void update();
    
    /** This function should render any graphics to the screen.  */
    public void render(Graphics g);
    
    /** This function should return true if the getNewScreen has a new screen 
     * object to give to the ScreenManager. */
    public boolean hasNewScreen();
    
    /** This should get a new screen object from the current screen object. */
    public Screen getNewScreen();
    
    /** This function is called to pass a key event to the screen. */
    public void handleKeyEvent(KeyEvent event);
    
} // end of interface Screen
