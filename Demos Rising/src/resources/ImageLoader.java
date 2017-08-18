package resources;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;


/** This is a legacy system for loading images into sprite objects.
 * It takes a file reference and either returns an already loaded sprite, 
 * or attempts to load the specified sprite. If it fails,  */
public class ImageLoader {
    
    //TODO: Update the old code to a better coding standard
    //TODO: Make more comments. 


    /** A single instance of the image loader */
    private static ImageLoader single = new ImageLoader();

    /** This function is used to return a reference to the actual image
     * loader object.  */
    public static ImageLoader get() {
        return single;
    }

    public String sep = File.separator;
    private HashMap<String, Sprite> Images = new HashMap<String, Sprite>();
    
    /** This variable specifies if the loader should print a message if 
     * an image requested wasn't previously loaded in the preload phase.  */
    private boolean _isPreloading = true;
    
    
    /** This function is used to specify if the program is in preloading mode
     * or not in preloading mode. If the <@code preloading> mode is set to 
     * false, then the image loader prints a stack trace if an image is 
     * requested that hasn't been preloaded. */
    public void setPreloading(boolean preloading) {
        _isPreloading = preloading;
    } // end of setPreloading
    
    

    public Sprite getSprite(String ref) {

        if (Images.get(ref) != null) {
            return Images.get(ref);
        }
        String reference = changeFileSeparators(ref);

        BufferedImage sourceImage = null;
        
        //This prints an error message if an image to load wasn't preloaded.
        if (!_isPreloading) {
            System.err.println("Image not preloaded: " + ref);
            System.err.println(Thread.currentThread().getStackTrace());
        }
        

        try {
            //Attempt to read the specified image
            sourceImage = ImageIO.read(new File(reference));
        } catch (IOException e) {
            //If there is a problem, print to console and create a placeholder
            System.err.println("Image Unable To Load: " + reference
                                + "\nCause: " + e.getMessage());
            
            
            //Create a placeholder image in case of an error
            sourceImage = new BufferedImage(40, 40, Transparency.TRANSLUCENT);
            
            sourceImage.createGraphics().drawImage(
                    sourceImage, 0, 0,Color.red, null);
            
            sourceImage.getGraphics().setColor(Color.blue);
            sourceImage.getGraphics().drawString("Err", 0, 15);
        }

        // GraphicsConfiguration gc =
        // GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        // Image image = gc.createCompatibleImage(sourceImage.getWidth(),
        // sourceImage.getHeight(), Transparency.BITMASK);
        //
        // image.getGraphics().drawImage(sourceImage, 0, 0, null);

        Sprite sprite = new Sprite(sourceImage);
        Images.put(ref, sprite);

        return sprite;
    }// end of getSprite


    private String changeFileSeparators(String ref) {
        String reference = ref;
        for (int i = 0; i < reference.length(); i++) {
            if (reference.charAt(i) == '\\') {
                reference = reference.replace('\\', File.separatorChar);
            }
        }
        return reference;
    }// end of getFullRef

}// end of class ImageLoader
