package com.brioal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by brioa on 2017/4/21.
 */

public class NumImageButton extends RelativeLayout {
    private ImageView mImageView;
    private RoundTextView mTextView;
    private Drawable mDrawable;//图片背景
    private int mNum;//数量
    private Drawable mNumBg;//数量的背景
    private int mTextSize = 10;
    private int mTextColor = Color.WHITE;

    public NumImageButton(Context context) {
        this(context, null);
    }

    public NumImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDefault();
        initArray(attrs);
    }

    private void initArray(AttributeSet attrs) {
        TypedArray array = getResources().obtainAttributes(attrs, R.styleable.NumImageButton);
        mTextColor = array.getColor(R.styleable.NumImageButton_textColor, Color.WHITE);
        mDrawable = array.getDrawable(R.styleable.NumImageButton_imageSrc);
        mNumBg = array.getDrawable(R.styleable.NumImageButton_numBg);
        mNum = array.getInt(R.styleable.NumImageButton_numIndex,0);
        array.recycle();
    }

    private void initDefault() {
        mImageView = new ImageView(getContext());
        mTextView = new RoundTextView(getContext());
        mDrawable = getContext().getResources().getDrawable(R.drawable.ic_launcher);
        mNum = 0;
        mNumBg = getContext().getResources().getDrawable(R.drawable.round_bg_accent);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                build();
            }
        });
    }

    public NumImageButton setTextColor(int textColor) {
        mTextColor = textColor;
        return this;
    }

    public NumImageButton setDrawable(Drawable drawable) {
        mDrawable = drawable;
        return this;
    }

    public NumImageButton setNum(int num) {
        mNum = num;
        return this;
    }

    public NumImageButton setNumBg(Drawable numBg) {
        mNumBg = numBg;
        return this;
    }

    public NumImageButton build() {
        setBackgroundColor(Color.TRANSPARENT);
        setPadding(0, 0, 0, 0);
        removeAllViews();
        //添加图片
        if (mDrawable != null) {
            LayoutParams drawableParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            drawableParams.topMargin = SizeUtil.DpToPx(getContext(), 2);
            drawableParams.leftMargin = SizeUtil.DpToPx(getContext(), 2);
            drawableParams.rightMargin = SizeUtil.DpToPx(getContext(), 2);
            drawableParams.bottomMargin = SizeUtil.DpToPx(getContext(), 2);
            drawableParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setImageDrawable(mDrawable);
            addView(mImageView, drawableParams);
        }


        //添加数量
        if (mNum != 0) {
            LayoutParams drawableParams = new LayoutParams(mWidth / 2, mWidth / 2);
            drawableParams.topMargin = SizeUtil.DpToPx(getContext(), 2);
            drawableParams.leftMargin = SizeUtil.DpToPx(getContext(), 2);
            drawableParams.rightMargin = SizeUtil.DpToPx(getContext(), 2);
            drawableParams.bottomMargin = SizeUtil.DpToPx(getContext(), 2);
            mTextView.setTextSize(mWidth / 9);
            mTextView.setTextColor(mTextColor);
            mTextView.setGravity(Gravity.CENTER);
            mTextView.setPadding(SizeUtil.DpToPx(getContext(), 2), SizeUtil.DpToPx(getContext(), 2), SizeUtil.DpToPx(getContext(), 2), SizeUtil.DpToPx(getContext(), 2));
            drawableParams.addRule(RelativeLayout.ALIGN_PARENT_TOP | RelativeLayout.ALIGN_PARENT_RIGHT);
            mTextView.setText(mNum + "");
            mTextView.setBackground(mNumBg);
            addView(mTextView, drawableParams);
        }
        return this;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
    }

    private int mWidth;
}
