package com.shtoone.liqing.widget.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/**
 * �ٶ��Ǳ��� �Ϸ�Ϊһ��������1-100��ָ������¶�,��λ�ǡ�
 * 
 * @author hezexi
 * 
 */
public class DashBoardView extends View {

	private static final int BGPIC_WIDTH = 302;
	private static final int PROGRESS_INC = 1;
	private static final int SWEEPANGLE_INC = 1;

	private static final int ARC_COLOR = 0xffb5de84;
	private static final int POINTER_COLOR1 = 0xffAE0303;
	private static final int POINTER_COLOR2 = 0xffDE0202;
	private static final int Text_COLOR = 0xffEDA64B;
	private static final int FIXED_TEXT_COLOR = 0xffffffff;
	private static final int SCALE_COLOR = 0xffC9D2DB;
	private static final int[] CENTER_COLORS = { 0xffABABAB, 0xffFCFCFC, 0xffBBBBBB, 0xffFAFAFA, 0xffBBBBBB, 0xffFEFEFE,
			0xffCCCCCC, 0xffFAFAFA, 0xffABABAB };

	private static final String C = "��C";
	private static final String[] FIXED_SPEED_LEVEL = { "0", "20", "40", "60", "80", "100", "120", "140", "160", "180",
			"200" };
	private static final int[] FIXED_SPEED_VALUE = { 0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200 };

	private int progress;
	private int toProgress;

	private int speed;

	private Paint mScalePaint;
	private Paint mArcPaint;
	private Paint mPointerPaint;
	private Paint mTextPaint;
	private Paint mFixedTextPaint;
	private Paint mCenterPaint;
	private Paint mCenterShadowPaint;

	private int view_width = 0;
	private int mProgressArcWidth = 4;
	private int mScaleWidth2 = 2;
	private int mScaleWidth3 = 3;

	int progressStartAngle = 150;
	int progressSweepAngle = 240;
	int progressMaxAngle = 240;

	float scaleProAngle = 4.8f;

	int pointerStartAngle = -120;
	int pointerSweepAngle = 0;
	int toPointerSweepAngle = 0;

	private int mPointerLength1 = 110;
	private int mPointerLength2 = 45;
	private int mPointerWidth = 12;

	private String speedNumber = "0";
	private String speedLevel = C;

	public DashBoardView(Context context) {
		super(context);
		init(context);
	}

	public DashBoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public DashBoardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	/***
	 * ��ʼ��
	 * 
	 * @param hezexi
	 */
	@SuppressLint("NewApi")
	private void init(Context context) {
		if (android.os.Build.VERSION.SDK_INT >= 11) {
			this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
		BlurMaskFilter mArcBlur = new BlurMaskFilter(1, BlurMaskFilter.Blur.INNER);
		BlurMaskFilter mPointerBlur = new BlurMaskFilter(1, BlurMaskFilter.Blur.SOLID);
		BlurMaskFilter mCenterBlur = new BlurMaskFilter(2, BlurMaskFilter.Blur.SOLID);

		mScalePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mScalePaint.setStyle(Paint.Style.STROKE);
		mScalePaint.setColor(SCALE_COLOR);

		mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mArcPaint.setStyle(Paint.Style.STROKE);
		mArcPaint.setColor(ARC_COLOR);
		mArcPaint.setMaskFilter(mArcBlur);
		mArcPaint.setAlpha(0);

		mPointerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPointerPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mPointerPaint.setMaskFilter(mPointerBlur);

		mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mTextPaint.setColor(Text_COLOR);

		mFixedTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mFixedTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mFixedTextPaint.setColor(FIXED_TEXT_COLOR);

		mCenterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mCenterPaint.setStyle(Paint.Style.FILL);
		Shader mShader = new SweepGradient(0, 0, CENTER_COLORS, null);
		mCenterPaint.setShader(mShader);
		mCenterPaint.setMaskFilter(mCenterBlur);

		mCenterShadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mCenterShadowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mCenterShadowPaint.setColor(0x55000000);
		mCenterShadowPaint.setMaskFilter(new BlurMaskFilter(1, BlurMaskFilter.Blur.NORMAL));
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		view_width = getWidth();
		if (getHeight() < getWidth())
			view_width = getHeight();

		canvas.translate(getWidth() / 2, getHeight() / 2 - 4 * view_width / BGPIC_WIDTH);

		RectF arcOval = new RectF(-129 * view_width / BGPIC_WIDTH, -129 * view_width / BGPIC_WIDTH,
				129 * view_width / BGPIC_WIDTH, 129 * view_width / BGPIC_WIDTH);
		RectF centerOval = new RectF(-19 * view_width / BGPIC_WIDTH, -19 * view_width / BGPIC_WIDTH,
				19 * view_width / BGPIC_WIDTH, 19 * view_width / BGPIC_WIDTH);
		RectF centerShadowOval = new RectF(-20 * view_width / BGPIC_WIDTH, -20 * view_width / BGPIC_WIDTH,
				20 * view_width / BGPIC_WIDTH, 20 * view_width / BGPIC_WIDTH);

		mProgressArcWidth = 7 * view_width / BGPIC_WIDTH;
		mScaleWidth2 = 3 * view_width / BGPIC_WIDTH;
		mScaleWidth3 = 5 * view_width / BGPIC_WIDTH;
		mScalePaint.setStrokeWidth(mProgressArcWidth);
		mArcPaint.setStrokeWidth(mProgressArcWidth);

		mPointerLength1 = 110 * view_width / BGPIC_WIDTH;
		mPointerLength2 = 45 * view_width / BGPIC_WIDTH;
		mPointerWidth = 12 * view_width / BGPIC_WIDTH;

		progressSweepAngle = progress * 240 / 100;
		progressSweepAngle = pointerSweepAngle;// ���ν�������ָ��һ��ڶ�
		super.onDraw(canvas);

		canvas.drawArc(arcOval, progressStartAngle, progressMaxAngle, false, mScalePaint);
		scaleDraw(canvas);
		fixedTextDraw(canvas);
		canvas.drawArc(arcOval, progressStartAngle, progressSweepAngle, false, mArcPaint);
		pointerDraw(canvas);

		speedNumberDraw(canvas);

		canvas.drawOval(centerShadowOval, mCenterShadowPaint);
		canvas.drawOval(centerOval, mCenterPaint);

		bufferChange();
	}

	private void fixedTextDraw(Canvas canvas) {
		mFixedTextPaint.setColor(Color.GREEN);
		mFixedTextPaint.setTextSize(14 * view_width / BGPIC_WIDTH);
		canvas.drawText(FIXED_SPEED_LEVEL[0], -95 * view_width / BGPIC_WIDTH, 55 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		canvas.drawText(FIXED_SPEED_LEVEL[1], -105 * view_width / BGPIC_WIDTH, 19 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		canvas.drawText(FIXED_SPEED_LEVEL[2], -104 * view_width / BGPIC_WIDTH, -20 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		canvas.drawText(FIXED_SPEED_LEVEL[3], -86 * view_width / BGPIC_WIDTH, -55 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		mFixedTextPaint.setColor(Color.YELLOW);
		canvas.drawText(FIXED_SPEED_LEVEL[4], -56 * view_width / BGPIC_WIDTH, -80 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		canvas.drawText(FIXED_SPEED_LEVEL[5], -17 * view_width / BGPIC_WIDTH, -98 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		canvas.drawText(FIXED_SPEED_LEVEL[6], 24 * view_width / BGPIC_WIDTH, -80 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		canvas.drawText(FIXED_SPEED_LEVEL[7], 61 * view_width / BGPIC_WIDTH, -55 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		mFixedTextPaint.setColor(Color.RED);
		canvas.drawText(FIXED_SPEED_LEVEL[8], 80 * view_width / BGPIC_WIDTH, -20 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		canvas.drawText(FIXED_SPEED_LEVEL[9], 84 * view_width / BGPIC_WIDTH, 19 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		canvas.drawText(FIXED_SPEED_LEVEL[10], 63 * view_width / BGPIC_WIDTH, 55 * view_width / BGPIC_WIDTH,
				mFixedTextPaint);
		mFixedTextPaint.setColor(FIXED_TEXT_COLOR);
	}

	/***
	 * �����̶̿�
	 * 
	 * @param hezexi
	 */
	private void scaleDraw(Canvas canvas) {

		canvas.save(); // ����canvas״̬
		canvas.rotate(pointerStartAngle);
		for (int i = 0; i < 51; i++) {
			if (0 == i % 5) {
				mScalePaint.setStrokeWidth(mScaleWidth3);
				canvas.drawLine(0, -129 * view_width / BGPIC_WIDTH - mProgressArcWidth / 2, 0,
						-(129 - 9) * view_width / BGPIC_WIDTH, mScalePaint);
			} else {
				mScalePaint.setStrokeWidth(mScaleWidth2);
				canvas.drawLine(0, -129 * view_width / BGPIC_WIDTH, 0, -(129 - 6) * view_width / BGPIC_WIDTH,
						mScalePaint);
			}
			canvas.rotate(scaleProAngle);
		}
		mScalePaint.setStrokeWidth(mProgressArcWidth);
		canvas.restore();
	}

	/***
	 * �����ٶ�Ϊ�ַ���
	 * @param inSpeed 
	 */
	private void calcSpeedNumber(double inSpeed) {
		speedNumber = "" + inSpeed;
		speedLevel = C;
	}

	private void speedNumberDraw(Canvas canvas) {
		mTextPaint.setTextSize(25 * view_width / BGPIC_WIDTH);
		if (speed <= 80)
			mTextPaint.setColor(Color.GREEN);
		else if (speed > 80 && speed < 160)
			mTextPaint.setColor(Color.YELLOW);
		else
			mTextPaint.setColor(Color.RED);
		canvas.drawText(speedNumber + speedLevel, -40 * view_width / BGPIC_WIDTH, 66 * view_width / BGPIC_WIDTH,
				mTextPaint);
		mTextPaint.setColor(Text_COLOR);
	}

	/***
	 * ����ı䣬ʹ��������Ȼ����
	 * 
	 */
	private void bufferChange() {
		if (progress != toProgress) {
			if (progress < toProgress) {
				progress += PROGRESS_INC;
				if (progress > toProgress)
					progress = toProgress;
			} else {
				// progress -= PROGRESS_INC;
				// if (progress < toProgress)
				progress = toProgress;
			}
			postInvalidate();
		}
		if (pointerSweepAngle != toPointerSweepAngle) {
			if (pointerSweepAngle < toPointerSweepAngle) {
				int range = toPointerSweepAngle - pointerSweepAngle;
				if (range > 8) {
					pointerSweepAngle += range / 5;
				} else {
					pointerSweepAngle += SWEEPANGLE_INC;
				}
				if (pointerSweepAngle > toPointerSweepAngle)
					pointerSweepAngle = toPointerSweepAngle;
			}
			if (pointerSweepAngle > toPointerSweepAngle) {
				int range = pointerSweepAngle - toPointerSweepAngle;
				if (range > 8) {
					pointerSweepAngle -= range / 6;
				} else {
					pointerSweepAngle -= SWEEPANGLE_INC;
				}
				if (pointerSweepAngle < toPointerSweepAngle)
					pointerSweepAngle = toPointerSweepAngle;
			}
			postInvalidate();
		}
	}

	/***
	 * ������ͷ
	 * 
	 * @param hezexi
	 */
	private void pointerDraw(Canvas canvas) {
		Path path1 = new Path();
		path1.moveTo(0, -mPointerLength1);
		path1.lineTo(mPointerWidth, 0);
		path1.lineTo(1, mPointerLength2);
		path1.lineTo(0, mPointerLength2);
		path1.close();
		Path path2 = new Path();
		path2.moveTo(0, -mPointerLength1);
		path2.lineTo(-mPointerWidth, 0);
		path2.lineTo(-1, mPointerLength2);
		path2.lineTo(0, mPointerLength2);
		path2.close();

		canvas.save(); // ����canvas״̬
		canvas.rotate(pointerStartAngle);
		canvas.rotate(pointerSweepAngle);
		mPointerPaint.setColor(POINTER_COLOR1);
		canvas.drawPath(path1, mPointerPaint);
		mPointerPaint.setColor(POINTER_COLOR2);
		canvas.drawPath(path2, mPointerPaint);

		canvas.restore();
	}

	/***
	 * ����ָ��ƫ�ƽǶ�
	 * 
	 */
	private void calcpointerSweepAngle() {
		if (speed > FIXED_SPEED_VALUE[9]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[9]) * 24 / (FIXED_SPEED_VALUE[10] - FIXED_SPEED_VALUE[9])
					+ 216;
			return;
		} else if (speed > FIXED_SPEED_VALUE[8]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[8]) * 24 / (FIXED_SPEED_VALUE[9] - FIXED_SPEED_VALUE[8])
					+ 192;
			return;
		} else if (speed > FIXED_SPEED_VALUE[7]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[7]) * 24 / (FIXED_SPEED_VALUE[8] - FIXED_SPEED_VALUE[7])
					+ 168;
			return;
		} else if (speed > FIXED_SPEED_VALUE[6]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[6]) * 24 / (FIXED_SPEED_VALUE[7] - FIXED_SPEED_VALUE[6])
					+ 144;
			return;
		} else if (speed > FIXED_SPEED_VALUE[5]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[5]) * 24 / (FIXED_SPEED_VALUE[6] - FIXED_SPEED_VALUE[5])
					+ 120;
			return;
		} else if (speed > FIXED_SPEED_VALUE[4]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[4]) * 24 / (FIXED_SPEED_VALUE[5] - FIXED_SPEED_VALUE[4])
					+ 96;
			return;
		} else if (speed > FIXED_SPEED_VALUE[3]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[3]) * 24 / (FIXED_SPEED_VALUE[4] - FIXED_SPEED_VALUE[3])
					+ 72;
			return;
		} else if (speed > FIXED_SPEED_VALUE[2]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[2]) * 24 / (FIXED_SPEED_VALUE[3] - FIXED_SPEED_VALUE[2])
					+ 48;
			return;
		} else if (speed > FIXED_SPEED_VALUE[1]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[1]) * 24 / (FIXED_SPEED_VALUE[2] - FIXED_SPEED_VALUE[1])
					+ 24;
			return;
		} else if (speed > FIXED_SPEED_VALUE[0]) {
			toPointerSweepAngle = (speed - FIXED_SPEED_VALUE[0]) * 24 / (FIXED_SPEED_VALUE[1] - FIXED_SPEED_VALUE[0])
					+ 0;
			return;
		}

	}

	public int getProgress() {
		return progress;
	}

	/***
	 * �Ǳ����Ϸ�������0-100
	 * 
	 * @param inProgress
	 */
	public void setProgress(int inProgress) {
		if (inProgress < 0) {
			this.toProgress = 0;
		} else if (inProgress < 100) {
			this.toProgress = inProgress;
		} else {
			this.toProgress = 100;
			this.progress = 100;
		}
		postInvalidate();
	}

	public int getSpeed() {
		return speed;
	}

	/***
	 * �������٣���λb 0-104857600(100Mbps)
	 * 
	 * @param inSpeed
	 */
	public void setSpeed(double inSpeed) {
		this.speed = (int) inSpeed;
		calcSpeedNumber(inSpeed);
		calcpointerSweepAngle();
		postInvalidate();
	}

	public void clear() {
		this.speed = 0;
		pointerSweepAngle = 0;
		toPointerSweepAngle = 0;
		postInvalidate();
	}

}