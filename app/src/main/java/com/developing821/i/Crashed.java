package com.developing821.i;

import android.util.Log;

/*
 * Crash Handlers enabled for debugging on device if required
 * can work on log gathering later with send to developer
 * errors and Stack Traces etc.
 */

/*
 * https://stackoverflow.com/questions/49822191/android-how-to-enable-logging-log-v-values-which-are-by-default-disabled#:~:text=If%20you%20want%20to%20keep%20a%20log%20of,part%20of%20your%20app%2C%20use%20the%20Log.v%20tag.
 */

public class Crashed {

    /**
     * Based on the coding in Device_Helper Class
     * The application shouldn't be going outside of the
     * screen width and height bounds and so this is a
     * serious error somewhere else and needs to be looked into
     */
    public static void outOfBounds() {
        Log.v("Device_Helper.class", "The index of x and or y are out of device screen dimension bounds!");
        Log.e("IndexOutOfBounds", String.valueOf(Interface_Helper.getX()));
        Log.e("ScreenHeight", String.valueOf(Interface_Helper.getScreenHeight()));
        Log.e("IndexOutOfBounds", String.valueOf(Interface_Helper.getY()));
        Log.e("ScreenWidth", String.valueOf(Interface_Helper.getScreenWidth()));
        System.exit(0);
    }
}
