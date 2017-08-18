package player;

import resources.WindowUI;

/** This class manages all of the high level components of the game, 
 * like delegating map loading or rendering to necessary game components.  */
public class GameManager {
    
    /** This number represents the desired FPS for the game. 
     * The delay required to reach this FPS is calculated by the class. 
     * At this time, the FPS is not modifiable. */
    public static final int DESIRED_FPS = 60;
    
    /** This number, determined at runtime, shows how many milliseconds are in 
     * a single frame.  */
    private int _millisPerFrame;
    
    
    
    /** Temporary variable to set the width */
    public static final int TEMP_WIDTH = 960;
    /** Temporary variable to set the height. */
    public static final int TEMP_HEIGHT = 540;
    
    
    /** This is the window of the game. From this, gui events can be received 
     * and rendering can be performed. */
    private WindowUI _window;
    
    /** This object is used to play levels.  */
    private LevelPlayer _levelPlayer;
    
    
    
    
    
    
    /** Constructs a new GameManager object.  */
    public GameManager() {
        //Compute the number of milliseconds that are in a single frame.
        //  Divide 1000ms by the desired frames per second to get milliseconds 
        //  per frame.
        _millisPerFrame = 1000 / DESIRED_FPS;
    } // end of constructor GameManager
    
    
    /** This function launches the game manager.  */
    public void startGameManager() {
        
        //TODO: Put initialization stuff here
        
        //Create a new user interface. 
        _window = new WindowUI(TEMP_WIDTH, TEMP_HEIGHT);
        
        
        //TEMPORARY
        //Just making a new level
        _levelPlayer = new LevelPlayer();
        
        
        
        
        
        //The start and end times of the current frame. 
        //TODO: Implement the lossless frame rate controller (like from
        //           Auto_Mouse_Click in the projects03 folder)
        long frameStartTime = 0;
        long frameEndTime = 0;
        
        //Loop until some arbitrary quit condition is met. 
        //This loop controls updating and rendering of any game components
        //  under the manager. 
        do {
            //Get the start time of the frame. Calling nano is more accurate
            frameStartTime = System.currentTimeMillis();
            
            update();
            render();
            
            frameEndTime = System.currentTimeMillis();
            
            //Sleep for the remaining amount of time to equal the requested FPS
            try {
                Thread.sleep(_millisPerFrame - (frameEndTime - frameStartTime));
            } catch (InterruptedException ex) {
                //Do nothing if interrupted.
            }
            
        } while (true);//TODO: change to some actual quit condition. 
        
    } // end of startGameManager
    
    
    
    
    
    public void update() {
        
    }
    
    
    public void render() {
        
    }
    
    
    
} // end of GameManager //












