package com.developing821.i;

import static com.developing821.i.Lines.halfHorizontal;

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

    /**
     * Cycles through with a (N(log(N))) for loop to calculate and add all
     * coordinate pairs of the screen dimensions to an arraylist
     *
     * @return ArrayList surfacePairs - all points as pair values as a single arraylist
     */
    protected ArrayList surfacePairs() {
        int x1, x2, y1, y2, i, j;

        ArrayList surfacePoints = new ArrayList();

        x1 = 0;
        x2 = getScreenHeight();
        y1 = 0;
        y2 = getScreenWidth();

        //set value 0 as y1 and any point along the width between x1 and x2 as y2
        for (i = y1; i <= y2; i++) {
            //set half the height as 0 and then any point at half way up as x2
            for (j = x1; j <= x2; j++) {
                //Call to screenPointPair to add to out arraylist as points on the surface area
                surfacePoints.add(screenPointPair(i, j));
            }
        }
        return surfacePoints;
    }

    protected  void drawRandomMesh(Canvas canvas, ArrayList point) {

        int i, j, k;

        ArrayList surfacePairs = new ArrayList(surfacePairs());
        ArrayList randomPoints = new ArrayList(getRandomPoint());
        ArrayList halwaylinePoints = new ArrayList(Lines.halfHorizontalRandomPoints(75));
        ArrayList pairs = new ArrayList(point);

        //We want to generate random points and link them to other points to draw the mesh
        for (i = 0; i <= surfacePairs.lastIndexOf(surfacePairs); i++) {
            //We need to do that from above and below the horizontal line
        }

        // Draw a polygonal triangle and link the points with lines



    }
}
