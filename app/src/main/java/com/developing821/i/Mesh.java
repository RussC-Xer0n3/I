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

        ArrayList<ArrayList <Integer> > areaPairs = new ArrayList<ArrayList <Integer>>(surfacePairs());
        ArrayList<ArrayList <Object> > randomAreaPoint = new ArrayList<ArrayList <Object> >();

        //get the size of the entire array list
        s = areaPairs.size();

        //randomise a point based on the size
        Random randomPoint = new Random(s);

        //Get the index location of the pair in the new array List
        for (k = 0; k <= 200; k++) {
            randomAreaPoint.get(k).add(areaPairs.get(randomPoint.nextInt()));
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
    protected static ArrayList surfacePairs() {
        int x1, x2, y1, y2, i, j, k;

        int n = getScreenHeight() * getScreenWidth();
        ArrayList<ArrayList <Object> > surfacePoints = new ArrayList<ArrayList <Object> >();

        x1 = 0;
        x2 = getScreenHeight();
        y1 = 0;
        y2 = getScreenWidth();

        for (k = 0; k <= n; k++) {
            //set value 0 as y1 and any point along the width between x1 and x2 as y2
            for (i = y1; i <= y2; i++) {
                //set half the height as 0 and then any point at half way up as x2
                for (j = x1; j <= x2; j++) {
                    //Call to screenPointPair to add to out arraylist as points on the surface area
                    surfacePoints.get(k).add(screenPointPair(i, j));
                }
            }
        }
        return surfacePoints;
    }

    protected static ArrayList equalPoints() {
        final int _N = 200;
        int i;

        ArrayList<ArrayList <Object> > halfwayLinePoints = new ArrayList<ArrayList <Object> >(halfHorizontalPoints(_N));
        ArrayList<ArrayList <Object> > up = new ArrayList<ArrayList <Object> >();
        ArrayList<ArrayList <Object> > down = new ArrayList<ArrayList <Object> >();

        //Equally divide the the vertices on the horizontal line with alternation
        for (i = 0; i <= halfwayLinePoints.lastIndexOf(halfwayLinePoints); i++) {
            if (i % 2 == 0) {
                up.get(i).add(halfwayLinePoints.get(i));
            } else {
                down.get(i).add(halfwayLinePoints.get(i));
            }
        }

        ArrayList<ArrayList<Object> > equalPairs = new ArrayList();
        equalPairs.get(0).add(up);
        equalPairs.get(1).add(down);

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
     * @param canvas
     * @return ArrayList - of vertices and edges in the mesh
     */
    protected ArrayList drawRandomMesh(Canvas canvas) {
        int i, j, k, m, o, p;

        ArrayList<ArrayList <Object> > equal = new ArrayList<ArrayList <Object> >(equalPoints());
        ArrayList drawRandomMesh = new ArrayList();
        ArrayList proximity_points = new ArrayList();

        //pointA - get the first and second index of the 2 dimensional array to Object is an x,y ArrayList containing two points
        ArrayList<ArrayList<Object>> up = new ArrayList<ArrayList <Object> >();
        ArrayList<ArrayList<Object>> down = new ArrayList<ArrayList <Object> >();

        //pointB - Set the random direction point of each vertices in up and down arraylists
        ArrayList<ArrayList<Object>> upRandom = new ArrayList<>(99);
        ArrayList<ArrayList<Object>> downRandom = new ArrayList<>(99);

        //Clear the arrayLists from last time
        up.clear();
        down.clear();
        upRandom.clear();
        downRandom.clear();

        /**
         * Add all the points with their proximities to ArrayList
         * @return Multi-dimensional Arraylist [[x,y], Object, Object, Object, Object, Object, Object]
         */
        for (m = 0; m <= 1000; m++) {
            proximity_points.add(Proximity.proximity(getRandomAreaPoint()));
        }

        //pointA - Set pointA vertices
        /**
         * Separates and extracts a multi-dimensional ArrayList of ArrayLists
         * [ 0 [], [], []....
         *   1 [], [], [].... ]
         * into two separate ArrayLists
         */
        for (i = 0; i <= equal.size(); i++) {
            up.get(i).add(equal.get(0));
            down.get(i).add(equal.get(1));
        }

        //Data processor buffer
        ArrayList n = new ArrayList();

        //pointB - Randomise x and y to get pointB vertices
        for (j = 0; j <= proximity_points.size(); j++) {

            n.add(proximity_points.get(j));

            for (k = 0;; j++) {

                // ? Top half of screen ?
                boolean top = isTop((ArrayList) n.get(k));

                //if top and upRandom doesn't contain it, add it else add it to downRandom if not top
                if (top == true && upRandom.get(99) == null) {
                    if (!upRandom.contains(proximity_points.get(k))) {
                        upRandom.add((ArrayList<Object>) proximity_points.get(j));
                    }
                } else if (top == false && downRandom.get(99) == null) {
                    if (!downRandom.contains(proximity_points.get(k))) {
                        downRandom.add((ArrayList<Object>) proximity_points.get(j));
                    }
                }
                n.clear();
            }
        }

        //Ensure all connections are made
        ArrayList connection = new ArrayList();


        for (o = 0; o <= upRandom.size() && o <= downRandom.size(); o++) {

            for (p = 0; p <= upRandom.lastIndexOf(o) && p <= downRandom.lastIndexOf(o); p++) {

            }
        }
            //Draw Edges of each connection to each vertices
        //Return an array of vertices and edges
        return drawRandomMesh;
    }
}

