package resources;


/** This class loads different assets into the RAM before use. Put all things
 * that need to be preloaded here.  */
public class Preloader {
    
    /** Load images into the ImageLoader. */
    public static void loadImages() {
        /** Get the reference to the image loader.  */
        ImageLoader loader = ImageLoader.get();
        
        loader.getSprite(ImageLinks.TEST_ENEMY_01);
        loader.getSprite(ImageLinks.TEST_PLAYER_01);
    } // end of loadImages
    
    
} // end of class Preloader //
