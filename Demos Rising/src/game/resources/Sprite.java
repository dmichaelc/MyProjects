package game.resources;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferInt;
//import java.awt.Color;

public class Sprite {


    /** The image that this sprite holds. */
    private BufferedImage _image;


    // /** This is a boolean that's set to declare if manual transparency is
    // being used. */
    // protected boolean transparent = false;
    //
    //
    //
    // private static final int TRANS_RED = 1;
    // private static final int TRANS_GREEN = 10;
    // private static final int TRANS_BLUE = 100;

    /** The constructor for the sprite. */
    public Sprite(BufferedImage image) {
        _image = image;
    }// end of Sprite


    /** Returns the width of the image in this sprite. */
    public int getWidth() {
        return _image.getWidth();
    } // end of getWidth


    /** Returns the height of the image in this sprite. */
    public int getHeight() {
        return _image.getHeight();
    } // end of getHeight


    /** Draws the sprite on the specified graphics at the specified position. */
    public void draw(Graphics g, int x, int y) {
        g.drawImage(_image, x, y, null);
    }// end of draw


    /**
     * Draws the sprite on the specified graphics scaling it based on 
     * destination coordinates d and source image s.
     */
    public void draw(Graphics g, int dx1, int dy1, int dx2, int dy2, 
            int sx1, int sy1, int sx2, int sy2) {
        g.drawImage(_image, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
    }// end of draw

    // /** This function is used in the event that RGB transparency is
    // implemented.
    // * It sets all pixels of a specific RGB value to an alpha of 0. These
    // * RGB values are specified by the variables, red*/
    // private void updateTransparency(){
    // int[] ref =
    // ((DataBufferInt)_image.getRaster().getDataBuffer()).getData();
    // for(int i=0; i<ref.length; i++){
    // boolean colorTrans=false;
    // Color c = new Color(ref[i]);
    // if(c.getGreen()==TRANS_GREEN){
    // if(c.getBlue()>=blue && c.getBlue()<=_blue){
    // if(c.getRed()>=red && c.getRed()<=red){
    // int tempColor = new Color(c.getRed(), c.getGreen(), c.getBlue(),
    // 0).getRGB();
    // ref[i]=tempColor;
    // colorTrans=true;
    // }
    // }
    // }
    // if(colorTrans == false){
    // int tempColor = new Color(c.getRed(), c.getGreen(), c.getBlue(),
    // 255).getRGB();
    // ref[i]=tempColor;
    // }
    // }//end for
    //// transCounter++;
    //// System.out.println("TransCount"+transCounter);
    // image.getGraphics().drawImage(image, 0, 0, null);
    // }//end of updateTrancparency

}// end of class Sprite
