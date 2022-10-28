package com.developing821.i;
import java.Math.*;

public class Transitions {

    public static void expand (){}
    public static void contract (){}
    public static void crossfadeIn (){}
    public static void crossfadeOut (){}

    /**
     * Receive starting point A and end point B, helictically move point A to point B
     * making use of standardised Fibonacci Algebra
     * @param pointA
     * @param pointB
     */
    public static void fibonacci (ArrayList pointA, ArrayList pointB){
        int A = pointAsInteger(pointA);
        int B = pointAsInteger(pointB);
        /**
         * Sedgewick & Wayne - Algorithms 4th .Ed. 2011 - MODDED
         * @param args
         */
        static final int radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getDisplayMetrics());
        static final double sin = Math.sin(3.6);

        public static long F(int N) {
            if (N == 0) return 0;
            if (N == 1) return 1;
            return F(N-1) + F(N-2);
        }

        for (int j = A; j <= B; j++) {
            for (int i = j; i < radius; i++) {
                sin++;
                F(i);
            }
        }
    }

    /**
     * Takes the values as ArrayLists and converts them to integers for use
     * in a radial helitical expanse from point B to point A
     * @param pointA
     * @param pointB
     */
    public static void reverseFibonacci (ArrayList pointA, ArrayList pointB) {
        int A = pointAsInteger(pointA);
        int B = pointAsInteger(pointB);

        /**
         * Sedgewick & Wayne - Algorithms 4th .Ed. 2011 - MODDED
         * @param args
         */
        static final int radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pointA, getDisplayMetrics());
        static final double sin = Math.sin(3.6);

        for (int j = B; j <= A; j++) {
            for (int i = j; i <= radius; i++) {
                sin++;
            }
        }
    }

    /**
     * simply receives integer and calls the respective method
     * pre coded, some are standardised som hybrid.
     * @param int type
     */
    public static void animate (int type){
        switch(type) {
            case 0:
                //https://developer.android.com/training/animation/reveal-or-hide-view#Reveal
                circular();
                break;
            case 1:
                //https://developer.android.com/training/animation/reveal-or-hide-view#Crossfade
                crossfadeIn();
                break;
            case 2:
                //https://developer.android.com/training/animation/zoom
                expand();
                break;
            case 3:
                hybrid();
                break;
            case 4:
                contract();
                break;
            case 5:
                crossfadeOut();
                break;
            default:
                break;
        }
    }

    /**
     * When calling the type consider the method with which it is being applied
     * below are the notes. int 0 RadialGradient int 1 Canvas.paint()
     * @param int type
     */
    public static void colourChange (int type){
        switch(type) {
            case 0:
                //For use with RadialGradient
                Colours.gen();
                break;
            case 1:
                //For use with canvas.paint
                ColourGen.gen();
                break;
            default:
                break;
        }

    }

    public static void prim (ArrayList pointA, Arraylist pointB){
        int A = pointAsInteger(pointA);
        int B = pointAsInteger(pointB);
        /**
         * Sedgewick & Wayne - Algorithms 4th .Ed. 2011
         */
    }

    public static void mazeExploration (ArrayList pointA, Arraylist pointB){
        int A = pointAsInteger(pointA);
        int B = pointAsInteger(pointB);
        /**
         * Sedgewick & Wayne - Algorithms 4th .Ed. 2011
         */
    }

    public static void circularRotation (){}
    public static void moveLettersOut() {}
    public static void moveLettersIn() {}




}
