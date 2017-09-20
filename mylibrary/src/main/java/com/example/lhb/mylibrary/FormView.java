package com.example.lhb.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhb on 2017/9/19.
 * Used To:
 */

public class FormView extends View {

    private Paint linePaint;
    private Paint XNamePaint;
    private Paint YNamePaint;
    private Paint ColumnPaint;

    private int maxHeight;
    private int columnWidth;
    private int columnHeight;

    private List<DataBean> mDataList = new ArrayList<>();

    public void setmDataList(List<DataBean> mDataList) {
        this.mDataList = mDataList;
        invalidate();
    }

    public FormView(Context context) {
        this(context, null);
    }

    public FormView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        getAttrs(context);
        initPaint(context);
    }

    private void initPaint(Context context) {
        if (mDataList == null) {
            return;
        }
        XNamePaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        XNamePaint.setTextAlign(Paint.Align.CENTER);
        XNamePaint.setTextSize(Dp2PxUtil.sp2px(context,15));
        XNamePaint.setColor(Color.RED);
        XNamePaint.setAntiAlias(true);

        YNamePaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        YNamePaint.setTextSize(16);
        YNamePaint.setColor(Color.RED);
        YNamePaint.setAntiAlias(true);
    }

    private void getAttrs(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.FormView);
        columnWidth = typedArray.getInteger(R.styleable.FormView_ColumnWidth, Dp2PxUtil.dip2px(context, 20));
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mDataList.size(); i++) {
            DataBean dataBean = mDataList.get(i);
            Rect rect = new Rect();
            XNamePaint.getTextBounds(dataBean.getXName(),0,dataBean.getXName().length(),rect);
            Paint.FontMetricsInt fontMetrics = XNamePaint.getFontMetricsInt();
            int baseline = (getMeasuredHeight() - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
            canvas.drawText(dataBean.getXName(),getMeasuredWidth() / 2 - rect.width() / 2, baseline, XNamePaint);
        }
    }
}