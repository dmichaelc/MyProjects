package game.resources;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import javax.swing.JFrame;



/** This class performs the majority of the basic UI interactions. It 
 * provides a space for rendering graphics as well as a convenient way of 
 * getting mouse and keyboard events.  */
public class WindowUI implements KeyListener{
    
    /** The window of the display.  */
    private JFrame _window;
    
    /** The canvas upon which things are drawn.  */
    private Canvas _canvas;
    
    
    
    /** This tells the canvas how to render frames upon previous frames.  */
    private BufferStrategy _buffer;
    
    /** The graphics to which things are drawn.  */
    private Graphics _graphics;
    
    
    /** The width of the canvas. */
    private int _width;
    /** The height of the canvas. */
    private int _height;
    
    
    
    
    /** An object lock for the KeyEvent buffer.  */
    private Object _keyLock = new Object();
    
    /** The queue for key events from the canvas.  */
    private LinkedList<KeyEvent> _keyQueue;
    
    
    
    /** A boolean that specifies whether to receive and queue KeyPressed 
     *  events. */
    private boolean _queueKeyPressed;
    /** A boolean that specifies whether to receive and queue KeyReleased 
     *  events. */
    private boolean _queueKeyReleased;
    /** A boolean that specifies whether to receive and queue KeyTyped events.*/
    private boolean _queueKeyTyped;
    
    
    /** This is a constant that limits the size of the input queues. This 
     * is in case queues are enabled, but not emptied. 
     * <p>
     * Queue behavior should be to remove the oldest element if this limit
     * is crossed.  */
    private static final int EVENT_QUEUE_MAX_SIZE = 1000;
    
    
    
    
    /** */
    public WindowUI(int width, int height) {
        _width = width;
        _height = height;
        
        //Initialize the window and canvas
        _window = new JFrame();
        _canvas = new Canvas();
        
        
        //Initialize the UI input buffers. 
        _keyQueue = new LinkedList<>();
        
        //Set the canvas to listen to key events.
        _canvas.addKeyListener(this);
        
        
        //Sets the size that the canvas wants to take up in the window. When 
        // pack() is called on the window, the window is sized to fit the 
        // canvas. 
//        this.setPreferredSize(new Dimension(width, height));
        _canvas.setPreferredSize(new Dimension(width, height));
        
        //Set the canvas to listen to key events. 
//        this.adKeyListener(this);
        
        
        //The Buffering of UI events is on by default. Individual buffers need
        // to be turned on by calling their respective 
        _queueKeyTyped = false;
        
        
        _window.add(_canvas);
        _window.pack();
        _window.setVisible(true);
        
        
    } // end of WindowCanvas
    
    
    
    
    /** Creates a 2 buffer strategy. Should only be called once while the window
     * is visible so there is graphical context for the creation of the buffer.
     * This should also be called only before rendering. */
    public void createBufferStrategy() {
        _canvas.createBufferStrategy(2);
        _buffer = _canvas.getBufferStrategy();
    } // end of createBufferStrategy
    
    
    
    /** Draws the contents of the graphics from the buffer to the screen.  */
    public void Draw(){
        //If the volatile contents of the buffer haven't been lost, draw the 
        //  contents. 
        if(!_buffer.contentsLost()){
            _buffer.show();
            
            //Dispose of the old graphics. 
            if(_graphics != null){
                _graphics.dispose();
            }
        }
    } // end of Draw
    
    
    
    
    
    
    
    
    
    
    
    
    
    /** Invoked when a key is pressed on this canvas. It buffers the key event
     * for later retrieval from getKeyEvent().  */
    @Override
    public void keyPressed(KeyEvent event) {
        System.out.println("Pressed: '" + event.getKeyChar() + "' at " + event.getWhen());
        if (_queueKeyPressed) {
            synchronized(_keyLock) {
                _keyQueue.offer(event);
            }
        }
    } // end of keyPressed
    
    /** Invoked when a key is released on this canvas. It buffers the key event
     * for later retrieval from getKeyEvent().  */
    @Override
    public void keyReleased(KeyEvent event) {
        System.out.println("Released: '" + event.getKeyChar() + "' at " + event.getWhen());
        if (_queueKeyReleased) {
            synchronized(_keyLock) {
                _keyQueue.offer(event);
            }
        }
    } // end of keyReleased
    
    /** Invoked when a key is typed on this canvas. It buffers the key event
     * for later retrieval from getKeyEvent() if such buffering is enabled. */
    @Override
    public void keyTyped(KeyEvent event) {
        //Only buffer the event if suffering of typed events are enabled. 
        if (_queueKeyTyped) {
            synchronized(_keyLock) {
                _keyQueue.offer(event);
            }
        }
    } // end of keyTyped
    
    /** A private helper function that puts a key event into the buffer. 
     * The process is synchronized to make the queue thread safe.  */
    private void queueKeyEvent(KeyEvent event) {
        
    }
    
    
    
    /** This function returns true if there are events in the KeyEvent queue. 
     * Returns false if there are no events.  */
    public boolean hasKeyEvent() {
        return !_keyQueue.isEmpty();
    } // hasKeyEvent
    
    /** Gets and removes the first key event in the KeyEvent queue. 
     * @throws NoSuchElementException - If there are no events in the queue. */
    public KeyEvent getKeyEvent() {
        return _keyQueue.removeFirst();
    } // getKeyEvent
    
    
    
    /** This function sets if buffering of KeyPressed events is enabled.  */
    public void setKeyPressedEnabled(boolean enabled) {
        _queueKeyPressed = enabled;
    } // end of setKeyPressedEnabled
    
    /** This function sets if buffering of KeyReleased events is enabled.  */
    public void setKeyReleasedEnabled(boolean enabled) {
        _queueKeyReleased = enabled;
    } // end of setKeyReleasedEnabled
    
    /** This function sets if buffering of KeyTyped events is enabled.  */
    public void setKeyTypedEnabled(boolean enabled) {
        _queueKeyTyped = enabled;
    } // end of setTypedEventsEnabled
    
    
    
    
    /** This function returns true if KeyTyped events are enabled. False 
     * otherwise.  */
    public boolean isKeyTypedEnabled() {
        return _queueKeyTyped;
    } // end of isTypedEventsEnabled
    
    
    
    
    public static void main(String args[]){
        JFrame w = new JFrame();
        WindowUI c = new WindowUI(500, 500);
        
        //Closes program when window is closed. 
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        w.add(c);
//        
//        w.pack();
//        
//        w.setVisible(true);
//        
//        while(true) {
//            if (c.hasKeyEvent()) {
//                KeyEvent tempKey = c.getKeyEvent();
//            }
//        }
    } // end of main
    
    
} // end of WindowUI //









