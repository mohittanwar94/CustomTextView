package com.github.customview;

import android.content.Context;
import android.graphics.Typeface;

public class CustomTypeFace {
    public static Typeface GOTHAM_LIGHT, GOTHAM_MEDIUM, GOTHAM_BOLD, HELVETICA_NEUE_BOLD, HELVETICA_NEUE_REGULAR, HELVETICA_NEUE_MEDIUM;
    private static CustomTypeFace customTypeFace;

    private CustomTypeFace(Context mContext) {
        GOTHAM_LIGHT = Typeface.createFromAsset(mContext.getAssets(), "fonts/GOTHAM_LIGHT.OTF");
        GOTHAM_MEDIUM = Typeface.createFromAsset(mContext.getAssets(), "fonts/GOTHAM_MEDIUM.TTF");
        GOTHAM_BOLD = Typeface.createFromAsset(mContext.getAssets(), "fonts/GOTHAM_BOLD.OTF");
        HELVETICA_NEUE_BOLD = GOTHAM_BOLD;
        HELVETICA_NEUE_REGULAR = GOTHAM_LIGHT;
        HELVETICA_NEUE_MEDIUM = GOTHAM_MEDIUM;
    }

    public static void createInstance(Context context) {
        if (customTypeFace == null)
            customTypeFace = new CustomTypeFace(context);
    }
}
