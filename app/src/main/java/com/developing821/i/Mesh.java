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
     * Cycles through with a (N(log(N))) for loop to calculate and add all
     * coordinate pairs of the screen dimensions to an arraylist
     *
     * @return ArrayList surfacePairs - all points as pair values as a single arraylist
     */
    protected static ArrayList surfacePairs() {
        int x1, x2, y1, y2, i, j, k;
        int n = getScreenArea();
        ArrayList<ArrayList<Object>> surfacePoints = new ArrayList<>();

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
                    surfacePoints.add(new ArrayList<>(screenPointPair(i, j)));
                }
            }
        }
        return surfacePoints;
    }

    /**
     * Gather and return the x,y coordinates in a uw pair for
     * the purposes of randomising pixels points for connectivity
     * and returning their x,y coordinate locations for processing
     * if required
     *
     * @return ArrayList pair of x,y Coordinates
     */
    public static ArrayList getRandomAreaPoint() {
        int s, k;

        areaPairs = surfacePairs();
        ArrayList<ArrayList<Object>> randomAreaPoint = new ArrayList<>();

        //get the size of the entire array list
        s = areaPairs.size();

        //randomise a point based on the size
        Random randomPoint = new Random(s);

        //Get the index location of the pair in the new array List
        for (k = 0; k <= 200; k++) {
            randomAreaPoint.add(new ArrayList<>(areaPairs.get(randomPoint.nextInt()));
        }
        //Serve it to the masses :'D :'D !!
        return randomAreaPoint;
    }

    /**
     * Returns an Object ArrayList of vertices of equal distribution along a horizontal line
     * halfway across the screen, the ArrayList contains two other ArrayLists of equal size (100 objects)
     * one half above the halfway line, the other below
     * @return
     */
    protected static ArrayList equalPoints() {
        final int _N = 200;
        int i;

        ArrayList<ArrayList<Object>> halfwayLinePoints = new ArrayList<>();
        halfwayLinePoints.add(new ArrayList<>(halfHorizontalPoints(_N)));

        ArrayList<ArrayList<Object>> up = new ArrayList<>();
        ArrayList<ArrayList<Object>> down = new ArrayList<>();

        //Equally divide the the vertices on the horizontal line with alternation
        for (i = 0; i <= halfwayLinePoints.size(); i++) {
            if (i % 2 == 0) {
                up.add(new ArrayList<>(halfwayLinePoints.get(i)));
            } else {
                down.add(new ArrayList<>(halfwayLinePoints.get(i)));
            }
        }

        ArrayList<ArrayList<Object>> equalPairs = new ArrayList();
        equalPairs.add(new ArrayList<>(up));
        equalPairs.add(new ArrayList<>(down));

        return equalPairs;
    }

    /**
     * The starting poings along the horizontal line of the screen
     * for the starting points of the mesh
     *
     * @return 2-D ArrayList pointA
     */
    protected ArrayList pointA() {
        //Return 2-d ArrayList
        ArrayList<ArrayList<Object>> pointA = new ArrayList<>();

        //pointA - Set pointA vertices
        equalPoints = equalPoints();
        /**
         * Separates and extracts a multi-dimensional ArrayList of ArrayLists
         * [ 0 [], [], []....
         *   1 [], [], [].... ]
         * into two separate ArrayLists
         */
        pointA.add(new ArrayList<>(equalPoints.get(0)); //up
        pointA.add(new ArrayList<>(equalPoints.get(1)); //down

        return pointA;
    }
    /**
     * We want to generate random points and link them to other points to draw the mesh
     * In this instance we will not look at MST and Spanning Forests and make use of other methods
     * to both make connections  between each vertices representing connectivity points.
     * We will work on the animation later and vertices are set at
     * 200 constantly.
     *
     * Point A int the animation is from the horizontal line and point B (herein) are the
     * randomised end points of a restricted exploratory algorithm housed in connection ArrayLists.
     *
     * In short, pointB is our mesh in the following form each index of 0 - 2 houses connections
     * in the following format ...
     *
     * [[
     *   [[x,y],ta,tc,ga,gc,ra,rc], [[x,y],ta,tc,ga,gc,ra,rc],
     *   [[x,y],ta,tc,ga,gc,ra,rc], [[x,y],ta,tc,ga,gc,ra,rc],
     *   .... N pairs of connections
     *  ],
     * [],
     * []]
     * 
     * @return 4-D ArrayList - of vertices and edges in the mesh with their proximities
     */
    protected ArrayList pointB() {
        int j, k, m, o, p;

        //Buffer
        ArrayList<ArrayList<Object>> proximity_points = new ArrayList<>();

        //pointB - Set the random direction point of each vertices in up and down arraylists
        ArrayList<ArrayList<Object>> upRandom = new ArrayList<>(99);
        ArrayList<ArrayList<Object>> downRandom = new ArrayList<>(99);

        //Used in processing the connections to be added to connection TGR
        //Random connections for both the top and lower half of the screen area
        ArrayList<ArrayList<Object>> connectionsT = new ArrayList<>();
        ArrayList<ArrayList<Object>> connections = new ArrayList<>();
        ArrayList<ArrayList<Object>> connectionsR = new ArrayList<>();

        //Random connections in the top half of the screen area
        ArrayList<ArrayList<Object>> connectionsT1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connections1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connectionsR1 = new ArrayList<>();

        //Random connections in the lower half odf the screen area
        ArrayList<ArrayList<Object>> connectionsT2 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connections2 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connectionsR2 = new ArrayList<>();

        //Ensure all connections are made making connection pairs
        ArrayList<Object> connectionT = new ArrayList<>();
        ArrayList<Object> connectionG = new ArrayList<>();
        ArrayList<Object> connectionR = new ArrayList<>();

        //Return value
        ArrayList<ArrayList<Object>> pointB = new ArrayList<>();

        /**
         * Add all the points with their proximities to ArrayList
         * @return Multi-dimensional Arraylist [[x,y], Object, Object, Object, Object, Object, Object]
         */
        for (m = 0; m <= 1000; m++) {
            proximity_points.add(new ArrayList<>(Proximity.proximity(getRandomAreaPoint())));
        }

        //Data processor buffer
        ArrayList n = new ArrayList();

        //pointB - Randomise x and y to get pointB vertices and sort them into top and bottom of screen
        for (j = 0; j <= proximity_points.size(); j++) {

            n.add(proximity_points.get(j));

            for (k = 0;; j++) {

                // ? Top half of screen ?
                boolean top = isTop((ArrayList) n.get(k));

                //if top and upRandom doesn't contain it, add it else add it to downRandom if not top
                if (top == true && upRandom.get(99) == null) {
                    //Adds to the randomness because we then have variable heights from the 1000 samples
                    if (!upRandom.contains(n.get(k))) {
                        upRandom.add(new ArrayList<>(n));
                    }
                } else if (top == false && downRandom.get(99) == null) {
                    if (!downRandom.contains(n.get(k))) {
                        downRandom.add(new ArrayList<>(n));
                    }
                }
                n.clear();
            }
        }

        /**
         * We want to sort through the upRandom, downRandom and compare their proximities
         * and decide whether we want to make a connection or not and add them to separate
         * arraylists, one for each type of connection according to the proximity for processing
         * later and drawing the connections, we will be returning the mesh with all the data
         * we need as a large multi-dimensional array.
         */

        //Connect any upRandom and downRandom to each other according to zone
        for (o = 0; o <= 100; o++) {
            for (p = 0; p <= 100; p++) {
                //How to connect if in the Red zone
                if (upRandom.get(o).get(7) == downRandom.get(p).get(2)) {
                    connectionsR.add(new ArrayList<>(upRandom.get(o)));
                    connectionsR.add(new ArrayList<>(downRandom.get(p)));
                    connectionR.add(new ArrayList<>(connectionsR));
                    //clear the buffer
                    connectionsR.clear();
                }

                //How to connect if in the Green zone
                if (upRandom.get(o).get(4) == downRandom.get(p).get(0)) {
                    connections.add(new ArrayList<>(upRandom.get(o)));
                    connections.add(new ArrayList<>(downRandom.get(p)));
                    connectionG.add(new ArrayList<>(connections));
                    connections.clear();
                }

                //How to connect if in the touch zone
                if (upRandom.get(o).get(2) == downRandom.get(p).get(2)) {
                    connectionsT.add(new ArrayList<>(upRandom.get(o)));
                    connectionsT.add(new ArrayList<>(downRandom.get(p)));
                    connectionT.add(new ArrayList<>(connectionsT));
                    connectionsT.clear();
                }
            }
        }

        //Connect any upRandom and upRandom to each other according to zone
        for (o = 0; o <= 100; o++) {
            for (p = 0; p <= 100; p++) {
                //How to connect if in the Red zone
                if (upRandom.get(o).get(7) == upRandom.get(p).get(2)) {
                    connectionsR1.add(new ArrayList<>(upRandom.get(o)));
                    connectionsR1.add(new ArrayList<>(downRandom.get(p)));
                    connectionR.add(new ArrayList<>(connectionsR1));
                    connectionsR1.clear();
                }

                //How to connect if in the Green zone
                if (upRandom.get(o).get(4) == upRandom.get(p).get(0)) {
                    connections1.add(new ArrayList<>(upRandom.get(o)));
                    connections1.add(new ArrayList<>(upRandom.get(p)));
                    connectionG.add(new ArrayList<>(connections1));
                    //clear the buffer
                    connections1.clear();
                }

                //How to connect if in the touch zone
                if (upRandom.get(o).get(2) == upRandom.get(p).get(2)) {
                    connectionsT1.add(new ArrayList<>(upRandom.get(o)));
                    connectionsT1.add(new ArrayList<>(downRandom.get(p)));
                    connectionT.add(new ArrayList<>(connectionsT1));
                    connectionsT1.clear();
                }
            }
        }

        //Connect any downRandom and downRandom to each other according ot zone
        for (o = 0; o <= 100; o++) {
            for (p = 0; p <= 100; p++) {
                //How to connect if in the Red zone
                if (downRandom.get(o).get(7) == downRandom.get(p).get(2)) {
                    connectionsR2.add(new ArrayList<>(upRandom.get(o)));
                    connectionsR2.add(new ArrayList<>(downRandom.get(p)));
                    connectionR.add(new ArrayList<>(connectionsR2));
                    connectionsR2.clear();
                }

                //How to connect if in the Green zone
                if (downRandom.get(o).get(4) == downRandom.get(p).get(0)) {
                    connections2.add(new ArrayList<>(downRandom.get(o)));
                    connections2.add(new ArrayList<>(downRandom.get(p)));
                    connectionG.add(new ArrayList<>(connections2));
                    connections2.clear();
                }

                //How to connect if in the touch zone
                if (upRandom.get(o).get(2) == downRandom.get(p).get(2)) {
                    connectionsT2.add(new ArrayList<>(upRandom.get(o)));
                    connectionsT2.add(new ArrayList<>(downRandom.get(p)));
                    connectionT.add(new ArrayList<>(connectionsT2));
                    connectionsT2.clear();
                }
            }
        }

        //Add the three
        pointB.add(new ArrayList<>(connectionT));
        pointB.add(new ArrayList<>(connectionG));
        pointB.add(new ArrayList<>(connectionR));

        //Clear out the connections since we have them in storage per ArrayList Point
        connectionT.clear();
        connectionG.clear();
        connectionR.clear();

        //Return an array of vertices and edges
        return pointB;
    }
}