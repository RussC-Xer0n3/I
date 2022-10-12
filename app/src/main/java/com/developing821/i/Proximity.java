package com.developing821.i;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.util.ArrayList;

//https://en.wikipedia.org/wiki/Pi - 12/10/2022

/**
 * The class is intended to simply calculate and return radial points
 * to be used as proximities for each point.
 */

public class Proximity extends Mesh {

    static final double _PI = 3.14159265358;

    static final int pi = (int) _PI;

    //Probst., R. 2021. In Android, how do I set margins in dp programmatically? [online] Available from: https://stackoverflow.com/questions/12728255/in-android-how-do-i-set-margins-in-dp-programmatically [12/10/2022].
    //H4Kr - https://stackoverflow.com/users/1713345/renato-probst
    static final int _red_radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getDisplayMetrics());
    static final int _green_radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getDisplayMetrics());
    static final int _touch_radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getDisplayMetrics());

    /**
     * Set the screen area as the proximity since all other metrics are included
     * @return Resources.getSystem().getDisplayMetrics()
     */
    private static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    /**
     * Calculate and return the Area given n value and Pi
     * @param pi
     * @param n
     * @return null, just process
     */
    public static Object Circumference(int pi, int n) { int i = pi * n;
        return null;
    }

    /**
     * Calculate and return the Area given n value and Pi
     * @param pi
     * @param n
     * @return Integer value of area
     */
    public static void Area(int pi, int n) { int i = pi * (n * 2); }

    /**
     * The touch area we want to use in dp minimum 48dp (icon size)
     * @return null, just process
     */
    public static Object Touch(int pi, int _touch_radius) { Area(pi, _touch_radius);
        return null;
    }

    /**
     * The 'green zone' area we want to use in dp minimum 96dp (icon size)
     * @return null, just process
     */
    public static Object Green(int pi, int _green_radius) { Area(pi, _green_radius);
        return null;
    }

    /**
     * The 'red zone' area we want to use in dp minimum 200dp (icon size)
     * @return null, just process
     */
    public static Object Red(int pi, int _red_radius) { Area(pi, _red_radius);
        return null;
    }

    /**
     * Designed to create an arrayList for each point passed in
     * returns the area and circumferences of the proximities of zones in dp
     * @param point
     * @return ArrayList proximity - the x,y and the areas and circumferences
     */
    public static ArrayList proximity(ArrayList point) {
        ArrayList<ArrayList<Object> > proximity = new ArrayList<ArrayList<Object> >();

        proximity.get(0).add(point);
        proximity.get(1).add(Touch(pi, _touch_radius));
        proximity.get(2).add(Circumference(pi, _touch_radius));
        proximity.get(3).add(Green(pi, _green_radius));
        proximity.get(4).add(Circumference(pi, _green_radius));
        proximity.get(5).add(Red(pi, _red_radius));
        proximity.get(6).add(Circumference(pi, _red_radius));

        return proximity;
    }
}
