package com.developing821.i;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

/**
 * The purpose of the class here is to get and set coordinates
 * of the point v and w to draw lines. The Class needs to be capable
 * of redraw as point v and w move manually or autonomously.
 * They have to be colourable too.
 */

public class Mesh extends Interface_Helper {

    //Randomising the point of each x and y however drawlines excepts x and y only
    private int a = getScreenHeight();
    private int b = getScreenWidth();

    private Paint paint = new Paint();

    /**
     * Get a new random x value from screen x and y coordinates
     * @param a - getScreenHeight() as integer range value from callback
     * @return integer x
     */
    public static int getRandomX(int a){
        int x;
        Random v = new Random(a);
        x = v.nextInt();
        return x;
    }

    /**
     * Get a new random y value from screen x and y coordinates
     * @param b - getScreenWidth() as integer range value from callback
     * @return integer y
     */
    public static int getRandomY(int b) {
        int y;
        Random w = new Random(b);
        y = w.nextInt();
        return y;
    }

    /**
     * Gather and return the x,y coordinates in a uw pair for
     * the purposes of randomising pixels points for connectivity
     * and returning their x,y coordinate locations for processing
     * if required
     *
     * @return ArrayList pair of x,y Coordinates
     */
    public static ArrayList getRandomPoint() {
        int i, j, s, k;

        ArrayList areaPairs = new ArrayList();
        ArrayList point = new ArrayList();

        //loop through the height and width
        for (i = 0; i<= getScreenHeight(); i++) {
            //calculate each point
            for (j = i; j <= getScreenWidth(); j++) {
                //add them to array
                areaPairs.add(i, j);
            }
        }

        //get the size of the entire array list
        s = areaPairs.size();

        //randomise a point based on the size
        Random randomPoint = new Random(s);

        //Get the index location of the pair in the new array List
        for (k = 0; k <= areaPairs.indexOf(s); k++) {
            point.get(k);
        }
        //Serve it to the masses :'D :'D !!
        return point;
    }

    //TODO: write method to get each x,y value from random point

    /**
     *
     * @param canvas
     * @param a
     * @param b
     */
    protected  void drawRandomMesh(Canvas canvas, int a, int b) {
        //Three random x values
        int x1 = getRandomX(a);
        int x2 = getRandomX(a);
        int x3 = getRandomX(a);

        //three random y values
        int y1 = getRandomY(b);
        int y2 = getRandomY(b);
        int y3 = getRandomY(b);

        // Draw a polygonal triangle and link the points with lines
        canvas.drawLine(x1, y1, x2, y2, paint);
        canvas.drawLine(x1, y1, x3, y3, paint);
        canvas.drawLine(x3, y3, x2, y2, paint);

        //We want to generate random points and link them to other points to draw the mesh
        for (int i = 0; i <= 30; i++) {

            int d1 = getRandomPoint(x1, y1);
            int d2 = getRandomPoint(x2, y2);

            for (int j = 0; j == 1; j++) {
             //TODO: sort out the algorithm
            }
        }
    }
}
