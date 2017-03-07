package com.shtoone.liqing.widget.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.shtoone.liqing.R;

public class StatscsView extends View {

	public StatscsView(Context context) {
		super(context);

		init(context, null);
	}

	public StatscsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	// ������ ���� ���ʣ�
	private Paint axisLinePaint;
	// ������ˮƽ�ڲ� ���߻���
	private Paint hLinePaint;
	// �����ı��Ļ���
	private Paint titlePaint;
	// ���λ��� ��״ͼ����ʽ��Ϣ
	private Paint recPaint;

	private void init(Context context, AttributeSet attrs) {

		axisLinePaint = new Paint();
		hLinePaint = new Paint();
		titlePaint = new Paint();
		recPaint = new Paint();

		axisLinePaint.setColor(Color.WHITE);
		hLinePaint.setColor(Color.GRAY);
		titlePaint.setColor(getResources().getColor(R.color.white));

	}

	// 7 ��
	private float[] thisYear;

	// 7 ��
	private float[] lastYear;

	/**
	 * ������������� ��ҪView�����ػ档
	 * 
	 * ���߳� ˢ�¿ؼ���ʱ����ã� this.invalidate(); ʧЧ����˼�� this.postInvalidate(); �������߳�
	 * ������ͼ�ķ������á�
	 * 
	 */
	// ����ʵ��ֵ
	public void updateActualValue(float[] thisData) {
		this.thisYear = thisData;
		// this.invalidate(); //ʧЧ����˼��
		this.postInvalidate(); // �������߳� ������ͼ�ķ������á�
	}

	// ��������ֵ
	public void updateTheoreticalValue(float[] lastData) {
		this.lastYear = lastData;
		// this.invalidate(); //ʧЧ����˼��
		this.postInvalidate(); // �������߳� ������ͼ�ķ������á�
	}

	private String[] yTitlesStrings = new String[] { "1200.00", "1028.57", "857.14", "685.71", "514.29", "342.86",
			"171.43", "0" };

	private String[] xTitles = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
	
	public void setxTitles(String[] xTitles) {
		this.xTitles = xTitles;
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int width = getWidth();
		// 1 ���������ߣ�
		canvas.drawLine(80, 0, 80, 160, axisLinePaint);

		canvas.drawLine(80, 160, width - 10, 160, axisLinePaint);

		// 2 ���������ڲ���ˮƽ��

		int leftHeight = 80;// ������ܵ� ��Ҫ���ֵĸ߶ȣ�

		int hPerHeight = leftHeight / 4;

		hLinePaint.setTextAlign(Align.CENTER);
		for (int i = 0; i < yTitlesStrings.length - 1; i++) {
			canvas.drawLine(80, 20 + i * hPerHeight, width - 10, 20 + i * hPerHeight, hLinePaint);
		}

		// 3 ���� Y ������

		FontMetrics metrics = titlePaint.getFontMetrics();
		int descent = (int) metrics.descent;
		titlePaint.setTextAlign(Align.RIGHT);
		titlePaint.setTextSize(15.5f); // ���������С
		for (int i = 0; i < yTitlesStrings.length; i++) {
			canvas.drawText(yTitlesStrings[i], 70, 20 + i * hPerHeight + descent, titlePaint);
		}

		// 4 ���� X �� ������

		int xAxisLength = width - 110;
		int columCount = xTitles.length + 1;
		int step = xAxisLength / columCount + 5;

		for (int i = 0; i < columCount - 1; i++) {
			canvas.drawText(xTitles[i], 90 + step * (i + 1), 180, titlePaint);
		}

		// 5 ���ƾ���

		if (thisYear != null && thisYear.length > 0) {
			int thisCount = thisYear.length;

			for (int i = 0; i < thisCount; i++) {
				float value = thisYear[i];

				float num = 8 - value / 171.43f; // TODO 171.43f

//				recPaint.setColor(getResources().getColor(R.color.buttonBgBlue));

				Rect rect = new Rect();

				rect.left = 70 + step * (i + 1) - 5;
				rect.right = 70 + step * (i + 1) + 5;

				int rh = (int) ((leftHeight * num) / 8); // ��ǰ����Ը߶�

				rect.top = rh + 20;
				rect.bottom = 160;

				canvas.drawRect(rect, recPaint);

			}
		}

		if (lastYear != null && lastYear.length > 0) {
			int thisCount = lastYear.length;

			for (int i = 0; i < thisCount; i++) {
				float value = lastYear[i];

				float num = 8 - value / 171.43f; // TODO 171.43

//				recPaint.setColor(0xFFAA1122);
//				recPaint.setColor(getResources().getColor(R.color.yellowgreen));

				Rect rect = new Rect();

				rect.left = 80 + step * (i + 1) - 5;
				rect.right = 80 + step * (i + 1) + 5;

				// ��ǰ����Ը߶ȣ�
				int rh = (int) ((leftHeight * num) / 8);

				rect.top = rh + 20;
				rect.bottom = 160;

				canvas.drawRect(rect, recPaint);

			}
		}
	}

}
