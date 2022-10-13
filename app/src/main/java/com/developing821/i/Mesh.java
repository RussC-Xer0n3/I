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
        ArrayList<ArrayList <Object> > randomAreaPoint = new ArrayList<>();

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
        ArrayList<ArrayList <Object> > surfacePoints = new ArrayList<>();

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
        ArrayList<ArrayList <Object> > up = new ArrayList<>();
        ArrayList<ArrayList <Object> > down = new ArrayList<>();

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
     * The starting poings along the horizontal line of the screen
     * for the starting points of the mesh
     *
     * @return 2-D ArrayList pointA
     */
    protected ArrayList getPointA() {
        int i;

        //Buffer
        ArrayList<ArrayList <Object>> equal = new ArrayList<ArrayList <Object>>(equalPoints());

        //pointA - get the first and second index of the 2 dimensional array to Object is an x,y ArrayList containing two points
        ArrayList<ArrayList<Object>> up = new ArrayList<>();
        ArrayList<ArrayList<Object>> down = new ArrayList<>();

        //Return 2-d ArrayList
        ArrayList<ArrayList<Object>> pointA = new ArrayList<>();

        //pointA - Set pointA vertices
        /**
         * Separates and extracts a multi-dimensional ArrayList of ArrayLists
         * [ 0 [], [], []....
         *   1 [], [], [].... ]
         * into two separate ArrayLists
         */
        for (i = 0; i <= equal.get(i).size(); i++) {
            //Should be getting index 0 and adding each ith value inside the arraylist same for index 1
            up.get(i).add(equal.get(0).indexOf(i));
            down.get(i).add(equal.get(1).indexOf(i));
        }

        pointA.get(0).add(up);
        pointA.get(1).add(down);

        return pointA;
    }
    /**
     * We want to generate random points and link them to other points to draw the mesh
     * In this instance we will look at MST and Spanning Forests making use of other methods
     * to both draw the vertices and the edge (line) between each vertices representing
     * connectivity points. We will work on the animation later and vertices are set at
     * 200 constantly. Point A int the animation is from the horizontal line and point B
     * the randomised end point of a restricted exploratory algorithm.
     *
     * @return 4-D ArrayList - of vertices and edges in the mesh with their proximities
     */
    protected ArrayList pointB() {
        int j, k, m, o, p;

        //Buffer
        ArrayList<ArrayList <Object>> proximity_points = new ArrayList<>();

        //pointB - Set the random direction point of each vertices in up and down arraylists
        ArrayList<ArrayList<Object>> upRandom = new ArrayList<>(99);
        ArrayList<ArrayList<Object>> downRandom = new ArrayList<>(99);

        //Used in processing the connections to be added to connection TGR
        ArrayList<ArrayList<Object>> connectionsT = new ArrayList<>();
        ArrayList<ArrayList<Object>> connections = new ArrayList<>();
        ArrayList<ArrayList<Object>> connectionsR = new ArrayList<>();
        ArrayList<ArrayList<Object>> connectionsT1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connections1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connectionsR1 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connectionsT2 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connections2 = new ArrayList<>();
        ArrayList<ArrayList<Object>> connectionsR2 = new ArrayList<>();

        //Ensure all connections are made making connection pairs
        ArrayList<Object> connectionT = new ArrayList<>();
        ArrayList<Object> connectionG = new ArrayList<>();
        ArrayList<Object> connectionR = new ArrayList<>();

        //Return value
        ArrayList<ArrayList<ArrayList<Object>>> pointB = new ArrayList<>();

        /**
         * Add all the points with their proximities to ArrayList
         * @return Multi-dimensional Arraylist [[x,y], Object, Object, Object, Object, Object, Object]
         */
        for (m = 0; m <= 1000; m++) {
            proximity_points.add(Proximity.proximity(getRandomAreaPoint()));
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
                    if (!upRandom.contains(proximity_points.get(k).indexOf(0))) {
                        upRandom.add((ArrayList<Object>) proximity_points.get(j));
                    }
                } else if (top == false && downRandom.get(99) == null) {
                    if (!downRandom.contains(proximity_points.get(k).indexOf(0))) {
                        downRandom.add((ArrayList<Object>) proximity_points.get(j));
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

        //Connect any upRandom and downRandom to each other if they are within the green zone
        for (o = 0; o <= 100; o++) {
            for (p = 0; p <= 100; p++) {
                if (upRandom.get(o).indexOf(4) == downRandom.get(p).indexOf(0)) {
                    connections.get(0).add(upRandom.get(o));
                    connections.get(1).add(downRandom.get(p));
                    connectionG.add(connections);
                    //clear the buffer
                    connections.clear();
                }

                //How to connect if in the red zone
                if (upRandom.get(o).indexOf(7) == downRandom.get(p).indexOf(2)) {
                    connectionsR.get(0).add(upRandom.get(o));
                    connectionsR.get(1).add(downRandom.get(p));
                    connectionR.add(connectionsR);
                    //clear the buffer
                    connectionsR.clear();
                }

                //How to connect if in the touch zone
                if (upRandom.get(o).indexOf(2) == downRandom.get(p).indexOf(2)) {
                    connectionsT.get(0).add(upRandom.get(o));
                    connectionsT.get(1).add(downRandom.get(p));
                    connectionT.add(connectionsT);
                    //clear the buffer
                    connectionsT.clear();
                }
            }
        }

        //Connect any upRandom and upRandom to each other if they are within the green zone
        for (o = 0; o <= 100; o++) {
            for (p = 0; p <= 100; p++) {
                if (upRandom.get(o).indexOf(4) == upRandom.get(p).indexOf(0)) {
                    connections1.get(0).add(upRandom.get(o));
                    connections1.get(1).add(upRandom.get(p));
                    connectionG.add(connections1);
                    //clear the buffer
                    connections1.clear();
                }

                //How to connect if in the red zone
                if (upRandom.get(o).indexOf(7) == upRandom.get(p).indexOf(2)) {
                    connectionsR1.get(0).add(upRandom.get(o));
                    connectionsR1.get(1).add(downRandom.get(p));
                    connectionR.add(connectionsR1);
                    //clear the buffer
                    connectionsR1.clear();
                }

                //How to connect if in the touch zone
                if (upRandom.get(o).indexOf(2) == upRandom.get(p).indexOf(2)) {
                    connectionsT1.get(0).add(upRandom.get(o));
                    connectionsT1.get(1).add(downRandom.get(p));
                    connectionT.add(connectionsT1);
                    //clear the buffer
                    connectionsT1.clear();
                }
            }
        }

        //Connect any downRandom and downRandom to each other if they are within the green zone
        for (o = 0; o <= 100; o++) {
            for (p = 0; p <= 100; p++) {
                if (downRandom.get(o).indexOf(4) == downRandom.get(p).indexOf(0)) {
                    connections2.get(0).add(downRandom.get(o));
                    connections2.get(1).add(downRandom.get(p));
                    connectionG.add(connections2);
                    //clear the buffer
                    connections2.clear();
                }

                //How to connect if in the red zone
                if (downRandom.get(o).indexOf(7) == downRandom.get(p).indexOf(2)) {
                    connectionsR2.get(0).add(upRandom.get(o));
                    connectionsR2.get(1).add(downRandom.get(p));
                    connectionR.add(connectionsR2);
                    //clear the buffer
                    connectionsR2.clear();
                }

                //How to connect if in the touch zone
                if (upRandom.get(o).indexOf(2) == downRandom.get(p).indexOf(2)) {
                    connectionsT2.get(0).add(upRandom.get(o));
                    connectionsT2.get(1).add(downRandom.get(p));
                    connectionT.add(connectionsT2);
                    //clear the buffer
                    connectionsT2.clear();
                }
            }
        }

        //Add the three
        pointB.get(0).add(connectionT);
        pointB.get(1).add(connectionG);
        pointB.get(2).add(connectionR);

        connectionT.clear();
        connectionG.clear();
        connectionR.clear();
        //Return an array of vertices and edges
        return pointB;
    }
}