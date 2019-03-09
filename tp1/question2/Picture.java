package question2;

import question1.Circle;
import question1.Square;
import question1.Triangle;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class represents a simple picture. You can draw the picture using the
 * draw method. But wait, there's more: being an electronic picture, it can be
 * changed. You can set it to black-and-white display and back to colors (only
 * after it's been drawn, of course).
 * 
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.1 (24 May 2001)
 */
public class Picture {
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun,yellowsun;
    static int distance=0;
    private boolean terreEstFix=false;
    /**
     * Constructor for objects of class Picture
     */
    public Picture() {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw() {
        wall = new Square();
        wall.moveVertical(80);
        wall.changeSize(100);
        wall.makeVisible();

        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(20);
        window.moveVertical(100);
        window.makeVisible();

        roof = new Triangle();
        roof.changeSize(50, 140);
        roof.moveHorizontal(60);
        roof.moveVertical(70);
        roof.makeVisible();

        sun = new Circle();
        sun.changeColor("blue");
        sun.moveHorizontal(180);
        sun.moveVertical(-10);
        sun.changeSize(60);
        sun.makeVisible();
        
        yellowsun = new Circle();
        yellowsun.changeColor("yellow");
        yellowsun.moveHorizontal(180);
        yellowsun.moveVertical(-10);
        yellowsun.changeSize(60);
        yellowsun.makeVisible();
        
        terreEstFix=true;
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
    }
    
    public void coucher(){
        if(terreEstFix){
            distance=200;
            Timer t = new Timer(50,new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(distance==0)
                        ((Timer)e.getSource()).stop();
                        
                    sun.moveVertical(1);
                    distance--;
                }
            });
            t.setRepeats(true);
            t.setCoalesce(true);
            t.setInitialDelay(0);
            t.start();
        }
    }

}
