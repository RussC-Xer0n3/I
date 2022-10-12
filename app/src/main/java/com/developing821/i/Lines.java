package com.developing821.i;

import static com.developing821.i.Interface_Helper.getHalfHeight;
import static com.developing821.i.Interface_Helper.getHalfWidth;
import static com.developing821.i.Interface_Helper.getScreenPointPair_X;
import static com.developing821.i.Interface_Helper.getScreenPointPair_Y;
import static com.developing821.i.Interface_Helper.getScreenWidth;
import static com.developing821.i.Interface_Helper.screenPointPair;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class Lines {

    private Paint paint = new Paint();

    /**
     * Make certain we are drawing the line if required we can call
     * the method later on for further development, such as colour
     * derives x,y paired coordinates from v,w points.
     * @param canvas
     * @param pairA
     * @param pairB
     */
    protected void drawLine(Canvas canvas, ArrayList pairA, ArrayList pairB) {
        int x1, x2, y1, y2;

        x1 = getScreenPointPair_X(pairA);
        y1 = getScreenPointPair_Y(pairA);

        x2 = getScreenPointPair_X(pairB);
        y2 = getScreenPointPair_Y(pairB);

        canvas.drawLine(x1, y1, x2, y2, paint);
    }

    /**
     * Draw the horizontal Line across the screen on method call
     * is called at app start for the first main activity after
     * selecting preferences.
     * @param canvas
     */
    protected void drawHalfHorizontal(Canvas canvas) {
        int x1, x2, y1, y2;

        x1 = getHalfHeight();
        x2 = getHalfHeight();
        y1 = getHalfHeight();
        y2 = getScreenWidth();

        //https://stackoverflow.com/questions/3616676/how-to-draw-a-line-in-android
        paint.setStrokeWidth(1f);
        canvas.drawLine(x1, y1, x2, y2, paint);
    }

    /**
     * Cycles through with a (N(log(log(N))) for loop to calculate and add all
     * coordinate pairs to an arraylist along the central horizontal line
     *
     * @return halfHorizontal - all points as pair values as a single arraylist
     */
    protected static ArrayList halfHorizontal() {
        int x1, x2, y1, y2, i, j, k, l;

        ArrayList<ArrayList<Object> > halfHorizontal = new ArrayList<ArrayList<Object> >();

        x1 = getHalfHeight();
        x2 = getHalfHeight();
        y1 = getHalfHeight();
        y2 = getScreenWidth();

        for (l = 0; l <= getScreenWidth(); l++) {
            //O(Log(Log(n))set value 0 as y1 and any point along the width between x1 and x2 as y2
            for (i = y1; i <= y2; i++) {
                //set half the height as 0 and then any point at half way up as x2
                for (j = i; j == x2; j++) {
                    //enforce x1 and y1 to stay at 0 and set the points on the halfway as pairs
                    for (k = y1; k == x1 + y1; k++) {
                        //Call to screenPointPair to add to out arraylist as points on the line
                        halfHorizontal.get(l).add(screenPointPair(k, j));
                    }
                }
            }
        }
        return halfHorizontal;
    }

    /**
     * Generate equally distributed VERTICES of x,y along the halfway horizontal line
     *
     * @param n - Quantity of random points to generate on the horizontal line
     * @return ArrayList of the random points as point x,y pairs
     */
    protected static ArrayList halfHorizontalPoints(int n) {
        int s, i, k;
        Object j;
        s = getScreenWidth() / n;

        ArrayList<ArrayList<ArrayList<Object> > > points = new ArrayList<ArrayList<ArrayList<Object> > >(halfHorizontal());
        ArrayList<ArrayList<Object> > horizontalPoints = new ArrayList<ArrayList<Object> >();

        //for the quantity n (200)
        for (k = 0; k <= n; k++) {
            //Step through at intervals of width / 200 for the entirety of k (200 points)
            for (i = s; i <= n; i++) {
                //for the object of j get the value at ith index of points
                for (j = points.get(i); ; ) {
                    //add it to a new ArrayList
                    horizontalPoints.get(k).add(j);
                }
            }
        }
        return horizontalPoints;
    }
}