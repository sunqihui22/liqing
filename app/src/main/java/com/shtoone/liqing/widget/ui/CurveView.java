package com.shtoone.liqing.widget.ui;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class CurveView extends View {
	private static final int STEPS = 12;
	Paint paint;
	Path curvePath;
	List<Point> points;
	List<Integer> points_x;
	List<Integer> points_y;

	boolean drawLineFlag;
	boolean drawCurveFlag;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public CurveView(Context context) {
		super(context);
		initObj();
	}

	public CurveView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initObj();
	}

	public CurveView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initObj();
	}

	/**
	 * ��������.
	 * 
	 * @param x
	 * @return
	 */
	private List<Cubic> calculate(List<Integer> x) {
		int n = x.size() - 1;
		float[] gamma = new float[n + 1];
		float[] delta = new float[n + 1];
		float[] D = new float[n + 1];
		int i;

		gamma[0] = 1.0f / 2.0f;
		for (i = 1; i < n; i++) {
			gamma[i] = 1 / (4 - gamma[i - 1]);
		}
		gamma[n] = 1 / (2 - gamma[n - 1]);

		delta[0] = 3 * (x.get(1) - x.get(0)) * gamma[0];
		for (i = 1; i < n; i++) {
			delta[i] = (3 * (x.get(i + 1) - x.get(i - 1)) - delta[i - 1]) * gamma[i];
		}
		delta[n] = (3 * (x.get(n) - x.get(n - 1)) - delta[n - 1]) * gamma[n];

		D[n] = delta[n];
		for (i = n - 1; i >= 0; i--) {
			D[i] = delta[i] - gamma[i] * D[i + 1];
		}

		/* now compute the coefficients of the cubics */
		List<Cubic> cubics = new LinkedList<Cubic>();
		for (i = 0; i < n; i++) {
			Cubic c = new Cubic(x.get(i), D[i], 3 * (x.get(i + 1) - x.get(i)) - 2 * D[i] - D[i + 1],
					2 * (x.get(i) - x.get(i + 1)) + D[i] + D[i + 1]);
			cubics.add(c);
		}
		return cubics;
	}

	// /**
	// * �����Ļ�ϵĵ�.
	// */
	// public void clearPoints() {
	// points.clear();
	// invalidate();
	// }

	/**
	 * ������.
	 * 
	 * @param canvas
	 */
	private void drawCurve(Canvas canvas) {
		canvas.save();
		paint.setColor(Color.GREEN);
		points_x.clear();
		points_y.clear();
		for (int i = 0; i < points.size(); i++) {
			points_x.add(points.get(i).x);
			points_y.add(points.get(i).y);
		}

		List<Cubic> calculate_x = calculate(points_x);
		List<Cubic> calculate_y = calculate(points_y);
		curvePath.moveTo(calculate_x.get(0).eval(0), calculate_y.get(0).eval(0));

		for (int i = 0; i < calculate_x.size(); i++) {
			for (int j = 1; j <= STEPS; j++) {
				float u = j / (float) STEPS;
				curvePath.lineTo(calculate_x.get(i).eval(u), calculate_y.get(i).eval(u));
			}
		}
		canvas.drawPath(curvePath, paint);
		canvas.restore();
	}

	/**
	 * ����.
	 * 
	 * @param canvas
	 */
	private void drawPoints(Canvas canvas) {
		canvas.save();
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			canvas.drawCircle(p.x, p.y, 2, paint);
		}
		canvas.restore();
	}

	/**
	 * ��ʼ��.
	 */
	private void initObj() {
		paint = new Paint();
		// linePath = new Path();
		curvePath = new Path();
		points = new LinkedList<Point>();
		points_x = new LinkedList<Integer>();
		points_y = new LinkedList<Integer>();
		drawLineFlag = false;
		drawCurveFlag = true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int height = getHeight();
		int leftPadding = 0;
		if (points.size() != 0) {
			leftPadding = getWidth() / points.size();
		}
		paint.setAntiAlias(true);
		paint.setColor(Color.GREEN);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(1);
		for (int i = 0; i < points.size(); i++) {
			Point point = points.get(i);
			point.y = height - point.y * (height / 18);
			if (i > 0) {
				point.x = points.get(i - 1).x + leftPadding;
			}
		}
		super.onDraw(canvas);
		drawPoints(canvas);
		if (points.size() > 2) {
			drawCurve(canvas);
		}
		curvePath.reset();//���reset������
	}
	
	public void resetPath(){
		curvePath.reset();
	}

	private class Cubic {

		float a, b, c, d; /* a + b*u + c*u^2 +d*u^3 */

		public Cubic(float a, float b, float c, float d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		public float eval(float u) {
			return (((d * u) + c) * u + b) * u + a;
		}
	}

}
