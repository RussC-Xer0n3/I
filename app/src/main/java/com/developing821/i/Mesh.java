package com.developing821.i;

import static com.developing821.i.Lines.halfHorizontalPoints;

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
    public static ArrayList getRandomAreaPoint() {
        int i, j, s, k;

        ArrayList areaPairs = new ArrayList();
        ArrayList randomAreaPoint = new ArrayList();

        //loop through the height and width
        for (i = 0; i <= getScreenHeight(); i++) {
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
            randomAreaPoint.add(randomPoint.nextInt());
        }
        //Serve it to the masses :'D :'D !!
        return randomAreaPoint;
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

    protected static ArrayList equalPoints () {
        final int _N = 200;
        int i, j;

        ArrayList halfwayLinePoints = new ArrayList(halfHorizontalPoints(_N));
        ArrayList up = new ArrayList();
        ArrayList down = new ArrayList();

        //Equally divide the the vertices on the horizontal line with alternation
        for (i = 0; i <= halfwayLinePoints.lastIndexOf(halfwayLinePoints); i++) {
            //Return an array of endpoints vertices going up
            up.add(i+2);
            for (j = i;; j++) {
                //Return an array of endpoints vertices going down
                down.add(j-1);
            }
        }

        ArrayList equalPairs = new ArrayList();
        equalPairs.add(up);
        equalPairs.add(down);

        return equalPairs;
    }

    /**
     * We want to generate random points and link them to other points to draw the mesh
     * In this instance we will look at MST and Spanning Forests making use of other methods
     * to both draw the vertices and the edge (line) between each vertices representing
     * connectivity points. We will work on the animation later and vertices are set at
     * 200 constantly. Point A int the animation is from the horizontal line and point B
     * the randomised end point of a restricted exploratory algorithm.
     *
     * We have - a 2 dimensional array of surface area vertices
     *           a 2 dimensional array of 200 vertices along the horizontal line
     *           a 2 dimensional array of the selected point
     *           a 2 dimensional array of vertices above the halfway line
     *           a 2 dimensional array of vertices below the halfway line
     *
     * @param canvas
     * @return ArrayList - of vertices and edges in the mesh
     */
    protected ArrayList drawRandomMesh(Canvas canvas) {
        final int _N = 200;
        int i, j, k ,x, y, z;
        boolean isTop;

        ArrayList surfacePairs = new ArrayList(surfacePairs());
        ArrayList equal = new ArrayList(equalPoints());

        //get the first and second index of the 2 dimensional array and add to a new list as starting pointA
        ArrayList up = new ArrayList();
        ArrayList down = new ArrayList();
        for (i = 0; i <= equal.size(); i++) {
            up.add(equal.get(0));
            down.add(equal.get(1));
        }

        //Set the random direction point of each vertices in up and down arraylists
        ArrayList upRandom = new ArrayList();
        ArrayList downRandom = new ArrayList();
        ArrayList pairs = new ArrayList();

        //Randomise x and y to get a vertices to add to the pairs list for pointB
        for (j = 0; j <= 1000; j++) {
            pairs.add(getRandomAreaPoint());
            for (k = 0; k <= pairs.size(); k++) {
                //find out if they are in the top half or bottom half
                boolean top = isTop((ArrayList) pairs.get(k));
                //add them as pointB for mesh growth
                while (upRandom.size() < 100) {
                if (top == true) {
                    upRandom.add(pairs.get(k));
                } else {
                    while (downRandom.size() < 100) {
                        downRandom.add(pairs.get(k));
                    }
            }
                if (upRandom.size() == 100 && downRandom.size() == 100) {
                    j = 1000;
                    break;
                } else {
                    continue;
                }
        }

        //MST to ensure all connections are made
            //Draw Edges of each connection to each vertices

        //Return an array of vertices and edges
        return drawRandomMesh;
    }

}
