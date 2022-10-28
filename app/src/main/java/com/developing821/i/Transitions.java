package com.developing821.i;

public class Transitions {

    public static void expand (){}
    public static void contract (){}
    public static void fadeIn (){}
    public static void fadeOut (){}

    /**
     * Receive starting point A and end point B, helictically move point A to point B
     * making use of standardised Fibonacci Algebra
     * @param pointA
     * @param pointB
     */
    public static void fibonacci (ArrayList pointA, ArrayList pointB){
        /**
         * Sedgewick & Wayne - Algorithms 4th .Ed. 2011 - MODDED
         * @param args
         */
        //TODO: CHECK HOW CONVERION IS OCCURRING FOR XY IN arraylist POINTa / b
        static final int radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getDisplayMetrics());
        static final double sin = Math.sin(3.6);

        public static long F(int N) {
            if (N == 0) return 0;
            if (N == 1) return 1;
            return F(N-1) + F(N-2);
        }

        //Might work, from point A go to point B using rotation sin for each step fibonacci radial increase
        for (int j = pointA; j <= pointB; j++) {
            for (int i = j; i < radius; i++) {
                sin++;
                F(i);
            }
        }
    }
    //TODO: reassess after going through the code once more about the compiled value of pA and pB
    public static void reverseFibonacci (ArrayList pointA, ArrayList pointB) {
        /**
         * Sedgewick & Wayne - Algorithms 4th .Ed. 2011 - MODDED
         * @param args
         */
        //TODO: CHECK HOW CONVERION IS OCCURRING FOR XY IN arraylist POINTa / b
        static final int radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pointA, getDisplayMetrics());
        static final double sin = Math.sin(3.6);

        //Might work, from point B go to point A using rotation sin for each step fibonacci radial decrease
        for (int j = pointB; j <= pointA; j++) {
            for (int i = j; i <= radius; j++) {
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
                crossfade();
                break;
            case 2:
                //https://developer.android.com/training/animation/zoom
                zoom();
                break;
            case 3:
                hybrid();
                break;
            default:
                break;
        }
    }

    /**
     * When calling the type consider the method with which it is being applied
     * below are the notes.
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

    public static void prim (){}
    public static void mazeExploration (){}
    public static void circularRotation (){}
    public static void moveLettersOut() {}
    public static void moveLettersIn() {}




}
