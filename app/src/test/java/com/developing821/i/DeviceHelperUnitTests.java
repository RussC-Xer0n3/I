package com.developing821.i;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DeviceHelperUnitTests {
    /**
     * Test that the getters and setters are working
     * properly for the device size
     */
    @Test
    public void screenGetterSetter() {
        Interface_Helper.setX(1);
        Interface_Helper.setY(1);

        int a = Interface_Helper.getX();
        int b = Interface_Helper.getY();

        assertEquals(1, a);
        assertEquals(1, b);
    }

    /**
     * Test that the getters and setters are working
     * properly for the device size and force an error
     * because of minus 1
     */
    @Test
    public void screenGetterSetterMinusOne() {
        //Should fail instantly here!
        Interface_Helper.setX(-1);
        Interface_Helper.setY(-1);

        int a = Interface_Helper.getX();
        int b = Interface_Helper.getY();

        //Return true here though!
        assertEquals(-1, a);
        assertEquals(-1, b);
    }

    /**
     * The purpose of the test is to test the functions on device
     * emulator, get the screen width and size and then set them plus one
     * to force an error.
     */
    @Test
    public void screenSizeOutOfBounds() {
        Interface_Helper.getX();
        Interface_Helper.getY();

        int x = Interface_Helper.getScreenHeight() + 1;
        int y = Interface_Helper.getScreenWidth() + 1;

        Interface_Helper.setX(x);
        Interface_Helper.setY(y);
    }

    /**
     * The purpose of the test is to test the functions on device
     * emulator, get the screen width and size and then set them
     * below zero to force an error.
     */
    @Test
    public void screenUnderSizeOutOfBounds() {
        int x = Interface_Helper.getScreenHeight();
        int y = Interface_Helper.getScreenWidth();

        //sets the value 1 less than zero
        int w = (x - 1);
        int v = (y - 1);

        Interface_Helper.setX(w);
        Interface_Helper.setY(v);
    }

    /**
     * The purpose of the test is to test the functions on device
     * emulator, get the screen width and size and then set them
     * below zero to force an error.
     */
    @Test
    public void screenIsZero() {
        int x = Interface_Helper.getScreenHeight();
        int y = Interface_Helper.getScreenWidth();

        //sets the value 0
        int w = x - x;
        int v = y - y;

        //sets the values in the class
        Interface_Helper.setX(w);
        Interface_Helper.setY(v);

        //gets the new values in the class
        int j = Interface_Helper.getX();
        int k = Interface_Helper.getY();

        //expect 0, test against actual
        assertEquals(0, j);
        assertEquals(0, k);
    }
}