package com.brioal.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by brioa on 2017/4/29.
 */

public class RoundTextView extends android.support.v7.widget.AppCompatTextView {
    public RoundTextView(Context context) {
        this(context, null);
    }

    public RoundTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        setMeasuredDimension(width,width);
    }
}
