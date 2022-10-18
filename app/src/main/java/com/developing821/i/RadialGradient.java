package com.developing821.i;

import static android.graphics.Shader.TileMode.DECAL;

import static com.developing821.i.Proximity.proximity;

import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collection;

@RequiresApi(api = Build.VERSION_CODES.S)
public class RadialGradient extends Shader {
    TileMode tileMode = DECAL;
    float[] stops = null;

    /**
     * Simply set the colour gradient based on the periferals
     * @param startX
     * @param startY
     * @param startRadius
     * @param endX
     * @param endY
     * @param endRadius
     * @param colors - The sRGB colors to be distributed between the center and edge of the circle the value cannot be null.
     * @param stops - float: May be null. Valid values are between 0.0f and 1.0f. The relative position of each corresponding color in the colors array. If null, colors are distributed evenly between the center and edge of the circle.
     * @param tileMode - Shader.TileMode: The Shader tiling mode This value cannot be null. - https://developer.android.com/reference/android/graphics/Shader.TileMode - DECAL
     */
    public RadialGradient(float startX, float startY, float startRadius, float endX, float endY, float endRadius, long[] colors, float[] stops, TileMode tileMode) {
        return;
    }
}
