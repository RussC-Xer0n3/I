package com.developing821.i;

import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.util.ArrayList;

//https://en.wikipedia.org/wiki/Pi - 12/10/2022

/**
 * The class is intended to simply calculate and return radial points
 * to be used as proximities for each point.
 */

public class Proximity extends Mesh {

    final double _PI = 3.14159265358;

    //Probst., R. 2021. In Android, how do I set margins in dp programmatically? [online] Available from: https://stackoverflow.com/questions/12728255/in-android-how-do-i-set-margins-in-dp-programmatically [12/10/2022].
    //H4Kr - https://stackoverflow.com/users/1713345/renato-probst
    final int _red_radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getDisplayMetrics());
    final int _green_radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 96, getDisplayMetrics());
    final int _touch_radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getDisplayMetrics());

    /**
     * Set the screen area as the proximity since all other metrics are included
     * @return screen area as Integer
     */
    private DisplayMetrics getDisplayMetrics() {
        return getScreenArea();
    }

    /**
     * Calculate and return the Area given n value and Pi
     * @param _PI
     * @param n
     * @return Integer value of circumference
     */
    public static int Circumference(double _PI, int n) {
        return (int) _PI * n;
    }

    /**
     * Calculate and return the Area given n value and Pi
     * @param _PI
     * @param n
     * @return Integer value of area
     */
    public static int Area(double _PI, int n) {
        return (int) _PI * (n * 2);
    }

    /**
     * The touch area we want to use in dp minimum 48dp (icon size)
     * @return Integer
     */
    public int Touch() {
        return (int) Area(_PI, _touch_radius);
    }

    /**
     * The 'green zone' area we want to use in dp minimum 96dp (icon size)
     * @return Integer
     */
    public int Green () {
        return (int) Area(_PI, _green_radius);
    }

    /**
     * The 'red zone' area we want to use in dp minimum 200dp (icon size)
     * @return Integer
     */
    public int Red () {
        return (int) Area(_PI, _red_radius);
    }

    /**
     * Designed to create an arrayList for each point passed in
     * returns the area and circumferences of the proximities of zones in dp
     * @param point
     * @return ArrayList proximity - the x,y and the areas and circumferences
     */
    public ArrayList proximity(ArrayList point) {
        ArrayList proximity = new ArrayList();

        int touch_circ = Circumference(_PI, _touch_radius);
        int green_circ = Circumference(_PI, _touch_radius);
        int red_circ = Circumference(_PI, _touch_radius);

        proximity.add(point);
        proximity.add(Touch());
        proximity.add(touch_circ);
        proximity.add(Green());
        proximity.add(green_circ);
        proximity.add(Red());
        proximity.add(red_circ);

        return proximity;
    }
}
