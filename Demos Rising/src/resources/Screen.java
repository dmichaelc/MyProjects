package resources;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/** A screen is defined as some object that needs updating and needs rendering.
 * Screen objects define methods to update their contents, render them, and
 * switch to a new screen object if necessary. */
public abstract class Screen {
    
    /** A screen object that the program will switch to once set.  */
    private Screen _newScreen;
    
    
    /** Set to true when there is a new screen.  */
    private boolean _hasNewScreen;
    
    
    /** This function is called whenever updates to a given screen need to be
     * applied. An example would be calling it once per frame.  */
    public abstract void update();
    
    /** This function should render any graphics to the screen.  */
    public abstract void render(Graphics g);
    
    
    /** This function is called to pass a key event to the screen. */
    public abstract void handleKeyEvent(KeyEvent event);
    
    
    /** This function returns true if the getNewScreen has a new screen 
     * object to give to the ScreenManager. */
    public boolean hasNewScreen() {
        return _hasNewScreen;
    }
    
    /** Get a new screen object from the current screen object. */
    public Screen getNewScreen() {
        //Get the reference to the new screen object. 
        Screen tempScreen = _newScreen;
        
        //Set the old reference to null to prevent it from holding up the GC.
        _newScreen = null;
        
        //Set _hasNewScreen to false as we don't have one anymore. 
        _hasNewScreen = false;
        
        return tempScreen;
    }
    
    
    
} // end of interface Screen
