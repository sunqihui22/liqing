package com.shtoone.liqing.widget.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.text.CollationKey;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;

/**
 * Author： hengzwd on 2017/4/5.
 * Email：hengzwdhengzwd@qq.com
 */

public class MoreIconsTextView extends TextView {
    /**
     * 外部轮廓的宽度。
     */
    private int outLineWidth = 2;

    /**
     * 外部轮廓的颜色。
     */
    private int outLineColor = Color.BLACK;

    /**
     * View的显示区域。
     */
    final Rect bounds = new Rect();
    /**
     * view中文字的显示边界
     */
    final Rect textBounds = new Rect();
    /**
     * 画笔。
     */
    private Paint mPaint = new Paint();

    /**
     * Resources对象
     */
    Resources resource = getResources();

    /**
     * R.draw中的图片资源
     */
    private int iconResource;

    /**
     * 图片要画出来多少个
     */
    private int iconCount;

    /**
     * 要显示的文字
     */
    private String text;

    /**
     * 图片转换的bitmap对象
     */
    private Bitmap bitmap;

    public MoreIconsTextView(Context context) {
        super(context, null);
    }


    public MoreIconsTextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MoreIconsTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MoreIconsTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获取view的边界
        getDrawingRect(bounds);
        //画内部背景
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, mPaint);

        //画边框
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(outLineWidth);
        mPaint.setColor(outLineColor);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, mPaint);
        //画字
        Paint paint = getPaint();

        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(text, bounds.left, bounds.bottom - 5, paint);

        paint.getTextBounds(text, 0, text.length(), textBounds);
        //画图片
//        mPaint.setColor(color);
        for (int i = 0; i < iconCount; i++) {
            mPaint.setColor(getCurrentTextColor());
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawBitmap(bitmap, textBounds.right + i * (bitmap.getWidth()) + 2, textBounds.bottom, mPaint);

        }
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        this.text = (String) text;
    }


    /**
     * 设置图片资源
     *
     * @param resources
     */
    public void setBitmapRescource(int resources, int count) {
        this.iconResource = resources;
        this.iconCount = count;
        bitmap = BitmapFactory.decodeResource(resource, resources);
        invalidate();
    }

}
