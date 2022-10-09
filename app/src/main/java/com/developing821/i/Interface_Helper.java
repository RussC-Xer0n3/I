package com.developing821.i;

import android.content.res.Resources;
import java.util.ArrayList;

/**
 * We need to display metrics and matrix for placement of
 * interactive points and randomisation. In addition, they are
 * required for animations and manually moving and tracking
 * them. The purposes of the methods below are self
 * explanatory and annotated.
 */

public class Interface_Helper {

    private static int x;
    private static int y;

    /**
     * These get set helper methods are akin to helping to
     * get pixels points within range of the screen
     * metrics and for setting points in the randomisation
     * of x,y geometrics of the screen
     * @return int x / y
     */

    /* Ensures we aren't out of bounds when getting screen height */
    public static int getX() {
        if (x < 0) {
            Crashed.outOfBounds();
        } else if (x > getScreenWidth()){
            Crashed.outOfBounds();
        } else if (x >= 0 && x <= getScreenWidth()) {
            return x;
        } else if (x == getScreenWidth()) {
            return x;
        } else {
            int a = x - getScreenWidth();
            return x = a + (x * 2);
        }
        return x;
    }

    /* Ensures we aren't out of bounds when getting screen width */
    public static int getY() {
        if (y < 0) {
            Crashed.outOfBounds();
        } else if (y > getScreenHeight()){
            Crashed.outOfBounds();
        } else if (y >= 0 && y <= getScreenHeight()) {
            return y;
        } else if (y == getScreenHeight()) {
            return y;
        } else {
            int a = y - getScreenHeight();
            return y = a + (y * 2);
        }
        return y;
    }

    /* Ensures we are setting the height within the bounds in randomisation or manually */
    public static int setX(int x) {
        if (x < 0) {
            Crashed.outOfBounds();
        } else if (x > getScreenWidth()) {
            Crashed.outOfBounds();
        } else if (x >= 0 && x <= getScreenWidth()) {
            x = x;
        } else if (x == getScreenWidth()) {
            x = x;
        } else {
            x = x;
        }
        return x;
    }

    /* Ensures we are setting the height within the bounds in randomisation or manually */
    public static int setY(int y) {
        if (y < 0) {
            Crashed.outOfBounds();
        } else if (y > getScreenHeight()){
            Crashed.outOfBounds();
        } else if (y >= 0 && y <= getScreenHeight()) {
            y = y;
        } else if (y == getScreenHeight()) {
            y = y;
        } else {
            y = y;
        }
        return y;
    }

    /**
     * Get and return the device width
     * @return int
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * Get and return the device height
     * @return int
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /**
     * Get and return the device square area
     * @return int
     */
    public static int getScreenArea() {
        return getScreenWidth() * getScreenHeight();
    }

    /**
     * Get and return half the height
     * @return int
     */
    public static int getHalfHeight() { return getScreenHeight() / 2; }

    /**
     * Get and return half the width
     * @return int
     */
    public static int getHalfWidth() { return getScreenWidth() / 2; }

    /**
     * Get and return the device square centre
     * @return int
     */
    public static int getScreenCentre() { return (getScreenHeight() * getScreenWidth()) - getHalfWidth(); }

    /**
     * Set and return any point in the device screen area based on values
     * @return int
     */
    public static ArrayList screenPointPair(int x, int y) {
        ArrayList point = new ArrayList(2);
        point.add(0, x);
        point.add(1, y);
        return point; //pair, refactored, stops an automated feed to getScreenPointPair_N()
    }

    /**
     * Get the x value from the point pair
     * @param pair
     * @return index 0 from the pair
     */
    public static int getScreenPointPair_X(ArrayList pair) {
        return pair.indexOf(0);
    }

    /**
     * get the y value from the point pair
     * @param pair
     * @return index 1 from the pair
     */
    public static int getScreenPointPair_Y(ArrayList pair) {
        return pair.indexOf(1);
    }
}