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
        canvas.drawLine(pairA.indexOf(0), pairA.indexOf(1), pairB.indexOf(0), pairB.indexOf(1), paint);
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
        x2 = getScreenWidth();
        y1 = getHalfHeight();
        y2 = getHalfHeight();
        //https://stackoverflow.com/questions/3616676/how-to-draw-a-line-in-android
        paint.setStrokeWidth(1f);

        ArrayList pairA = new ArrayList();
        ArrayList pairB = new ArrayList();

        pairA.add(x1);
        pairA.add(y1);
        pairB.add(x2);
        pairB.add(y2);

        drawLine(canvas, pairA, pairB);
    }

    /**
     * Cycles through with a O(n) for loop to calculate and add all
     * coordinate pairs to an arraylist along the central horizontal line
     *
     * @return halfHorizontal - all points as pair values as a single arraylist
     */
    protected static ArrayList halfHorizontal() {
        int l, k;

        ArrayList<ArrayList<Object>> halfHorizontal = new ArrayList<>();

        //set value half the height, iterate
        for (l = getHalfHeight(); l <= getScreenWidth(); l++) {
                k = l * getHalfHeight();
                //enforce x1 and y1 to stay at 0 and set the points on the halfway as a multiple to get the nth halfway
                //Call to screenPointPair to add to out arraylist as points on the line
                halfHorizontal.add(screenPointPair(k, l));
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
        s = getScreenWidth() / n;

        ArrayList<ArrayList<ArrayList<Object> > > points = new ArrayList<>(halfHorizontal());
        ArrayList<ArrayList<Object> > horizontalPoints = new ArrayList<>();

        //for the quantity n (200)
        for (k = 0; k <= n; k++) {
            //Step through at intervals of width / 200 for the entirety of k (200 points)
            for (i = s; i <= n; i++) {
                //for the object of j get the value at ith index of points
                //add it to a new ArrayList
                horizontalPoints.get(k).add(points.get(i));
            }
        }
        return horizontalPoints;
    }
}