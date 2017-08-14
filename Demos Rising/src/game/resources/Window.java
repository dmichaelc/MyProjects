package game.resources;

import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.image.BufferStrategy;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    private WindowCanvas _canvas;
    
//    /** This tells the canvas how to render frames upon previous frames.  */
//    private BufferStrategy _buffer;
//    
//    /** The graphics to which things are drawn.  */
//    private Graphics _graphics;
    
    
    
    
    /** FOR TESTING */
    public static void main(String args[]){
        Window w = new Window();
        WindowCanvas c = new WindowCanvas(500, 500);
        
        //Closes program when window is closed. 
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        w.add(c);
        
        w.pack();
        
        w.setVisible(true);
        
        while(true) {
            if (c.hasKeyEvent()) {
                KeyEvent tempKey = c.getKeyEvent();
            }
        }
    } // end of main
    
} // end of Window //
