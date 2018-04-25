package com.github.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;

import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;



public class SnapTextView extends AppCompatTextView {

    public SnapTextView(Context context) {
        super(context);
        applyCustomFont(context, null);
    }

    public SnapTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public SnapTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context, attrs);
    }

    public void applyCustomFont(Context context, AttributeSet attrs) {
        if (attrs != null && !isInEditMode()) {
            TypedArray attributeArray = context.obtainStyledAttributes(
                    attrs,
                    R.styleable.SnapTextView);
            try {
                int fontFamily = attributeArray.getInt(R.styleable.SnapTextView_textFont, 0);
                setTypeface(selectTypeface(context, fontFamily));
                Drawable drawableLeft = null;
                Drawable drawableRight = null;
                Drawable drawableBottom = null;
                Drawable drawableTop = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    drawableLeft = attributeArray.getDrawable(R.styleable.SnapTextView_drawableLeftCompat);
                    drawableRight = attributeArray.getDrawable(R.styleable.SnapTextView_drawableRightCompat);
                    drawableBottom = attributeArray.getDrawable(R.styleable.SnapTextView_drawableBottomCompat);
                    drawableTop = attributeArray.getDrawable(R.styleable.SnapTextView_drawableTopCompat);
                } else {
                    final int drawableLeftId = attributeArray.getResourceId(R.styleable.SnapTextView_drawableLeftCompat, -1);
                    final int drawableRightId = attributeArray.getResourceId(R.styleable.SnapTextView_drawableRightCompat, -1);
                    final int drawableBottomId = attributeArray.getResourceId(R.styleable.SnapTextView_drawableBottomCompat, -1);
                    final int drawableTopId = attributeArray.getResourceId(R.styleable.SnapTextView_drawableTopCompat, -1);

                    if (drawableLeftId != -1)
                        drawableLeft = AppCompatResources.getDrawable(context, drawableLeftId);
                    if (drawableRightId != -1)
                        drawableRight = AppCompatResources.getDrawable(context, drawableRightId);
                    if (drawableBottomId != -1)
                        drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId);
                    if (drawableTopId != -1)
                        drawableTop = AppCompatResources.getDrawable(context, drawableTopId);
                }
                setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
            } finally {
                attributeArray.recycle();
            }
        }
    }
// change the typeface according to your typeface
    private Typeface selectTypeface(Context context, int fontFamily) {
        CustomTypeFace.createInstance(context);
        switch (fontFamily) {
            case 0:
                return CustomTypeFace.GOTHAM_LIGHT;
            case 1:
                return CustomTypeFace.GOTHAM_MEDIUM;
            case 2:
                return CustomTypeFace.GOTHAM_BOLD;
            default:
                break;
        }
        return CustomTypeFace.GOTHAM_LIGHT;
    }

}
