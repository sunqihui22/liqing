package com.shtoone.liqing.widget.ui;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.view.View;

import com.shtoone.liqing.R;

//����ͼ
public class ChartView extends View {

	private Paint ovalPaint;
	private Paint axisLinePaint;
	private Paint hLinePaint;
	private Paint linePaint;

	private float[] yValue;
	private float[] yPadding;
	private String[] yTitle;
	private Paint titlePaint;

	public void setyValue(float[] yValue) {
		this.yValue = yValue;
		conversion();
	}

	public void setyPadding(float[] yPadding) {
		this.yPadding = yPadding;
	}

	public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initObj();
	}

	public ChartView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initObj();
	}

	public ChartView(Context context) {
		super(context);
		initObj();
	}

	private void initObj() {
		ovalPaint = new Paint();
		axisLinePaint = new Paint();
		linePaint = new Paint();
		hLinePaint = new Paint();
		titlePaint = new Paint();

		axisLinePaint.setColor(Color.WHITE);
		ovalPaint.setColor(Color.GREEN);
		hLinePaint.setColor(Color.GRAY);
		linePaint.setColor(Color.GREEN);
		linePaint.setStrokeWidth(2.0f);
		titlePaint.setColor(getResources().getColor(R.color.white));
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int width = getWidth();
		// 1. ��������ϵ
		canvas.drawLine(60, 0, 60, 120, axisLinePaint);
		canvas.drawLine(60, 120, width - 20, 120, axisLinePaint);

		int leftHeight = 80;// ������ܵ� ��Ҫ���ֵĸ߶ȣ�
		float hPerHeight = leftHeight / 4;

		// 2. ��������
		hLinePaint.setTextAlign(Align.CENTER);
		for (int i = 0; i < 5; i++) {
			canvas.drawLine(60, 20 + i * hPerHeight, width - 20, 20 + i * hPerHeight, hLinePaint);
		}

		// 3. ���� Y ������
		conversion();
		FontMetrics metrics = titlePaint.getFontMetrics();
		int descent = (int) metrics.descent;
		titlePaint.setTextAlign(Align.RIGHT);
		titlePaint.setTextSize(15.5f); // ���������С
		if (yTitle != null && yTitle.length > 0) {
			for (int i = 0; i < yTitle.length; i++) {
				canvas.drawText(yTitle[i], 50, 20 + i * hPerHeight + descent, titlePaint);
			}
		}
		// 4. ���� �����Լ���
		lineDraw(canvas);
	}

	private void lineDraw(Canvas canvas) {
		canvas.save();

		float step = ((float)getWidth()) / 480;
		if (yPadding != null && yPadding.length > 0) {

			float[] xValue = new float[yPadding.length]; //{ 60, 150, 240, 330, 420 };
			float baseValue = 60;
			float stepValue = 100 * step;

			for (int i = 0; i < xValue.length; i++) {
				xValue[i] = baseValue;
				if (i < xValue.length) {
					baseValue += stepValue;
				}
			}

			int k = 0;
			float[] pts = new float[xValue.length * 2];
			for (int i = 0; i < xValue.length; i++) {
				pts[k] = xValue[i];
				k += 2;
			}
			k = 1;

			for (int i = 0; i < yPadding.length; i++) {
				pts[k] = yPadding[i];
				if (k < 9) {
					k += 2;
				}
			}
			k = 0;
			for (int i = 0; i < pts.length; i++, i++) {
				if (i + 1 < pts.length)
					canvas.drawCircle(pts[i], pts[i + 1], 3, ovalPaint);
				if (i + 3 < pts.length) {
					canvas.drawLine(pts[i], pts[i + 1], pts[i + 2], pts[i + 3], linePaint);
				}
			}
		}
		canvas.restore();
	}

	/**
	 * �� float ת��Ϊ String
	 */
	private void conversion() {
		// { 0, 4.55f, 4.60f, 4.65f, 4.70f, 4.75f };
		// yValue = new float[] { 0, 4.55f, 4.60f, 4.65f, 4.70f, 4.75f };

		if (yValue != null && yValue.length > 0) {
			yTitle = new String[yValue.length];
			for (int i = 0; i < yValue.length; i++) {
				yTitle[i] = yValue[yValue.length - 1 - i] + "";
			}
		} else {
			yTitle = new String[]{""};
		}
	}
}
