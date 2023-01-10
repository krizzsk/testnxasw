package com.didi.soda.customer.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.didi.app.nova.support.util.DisplayUtils;
import com.google.android.gms.ads.RequestConfiguration;
import com.taxis99.R;

public class SideLetterBar extends View {

    /* renamed from: a */
    private String[] f44207a = {"★", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, C17272q.f51679a, C17272q.f51680b, "Z"};

    /* renamed from: b */
    private int f44208b = -1;

    /* renamed from: c */
    private Paint f44209c = new Paint();

    /* renamed from: d */
    private boolean f44210d = false;

    /* renamed from: e */
    private OnLetterChangedListener f44211e;

    /* renamed from: f */
    private TextView f44212f;

    /* renamed from: g */
    private ViewTreeObserver.OnGlobalLayoutListener f44213g = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            Rect rect = new Rect();
            ((Activity) SideLetterBar.this.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int screenHeight = DisplayUtils.getScreenHeight(SideLetterBar.this.getContext());
            if (Math.abs(screenHeight - rect.bottom) > screenHeight / 4) {
                if (SideLetterBar.this.getVisibility() == 0) {
                    SideLetterBar.this.setVisibility(8);
                }
            } else if (SideLetterBar.this.getVisibility() == 8) {
                SideLetterBar.this.setVisibility(0);
            }
        }
    };

    public interface OnLetterChangedListener {
        void onLetterChanged(String str);
    }

    public SideLetterBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SideLetterBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SideLetterBar(Context context) {
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.f44208b;
        OnLetterChangedListener onLetterChangedListener = this.f44211e;
        float height = y / ((float) getHeight());
        String[] strArr = this.f44207a;
        int length = (int) (height * ((float) strArr.length));
        if (action == 0) {
            this.f44210d = true;
            if (i != length && onLetterChangedListener != null && length >= 0 && length < strArr.length) {
                onLetterChangedListener.onLetterChanged(strArr[length]);
                this.f44208b = length;
                invalidate();
                TextView textView = this.f44212f;
                if (textView != null) {
                    textView.setVisibility(0);
                    this.f44212f.setText(this.f44207a[length]);
                }
            }
        } else if (action == 1) {
            this.f44210d = false;
            this.f44208b = -1;
            invalidate();
            TextView textView2 = this.f44212f;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else if (action == 2 && i != length && onLetterChangedListener != null && length >= 0 && length < strArr.length) {
            onLetterChangedListener.onLetterChanged(strArr[length]);
            this.f44208b = length;
            invalidate();
            TextView textView3 = this.f44212f;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.f44212f.setText(this.f44207a[length]);
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setLetters(String[] strArr) {
        this.f44207a = strArr;
        postInvalidate();
    }

    public void setOnLetterChangedListener(OnLetterChangedListener onLetterChangedListener) {
        this.f44211e = onLetterChangedListener;
    }

    public void setOverlay(TextView textView) {
        this.f44212f = textView;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f44210d) {
            canvas.drawColor(0);
        }
        int height = getHeight();
        int width = getWidth();
        String[] strArr = this.f44207a;
        if (strArr != null && strArr.length > 0) {
            int length = height / strArr.length;
            for (int i = 0; i < this.f44207a.length; i++) {
                this.f44209c.setTextSize(DisplayUtils.sp2px(getContext(), 12.0f));
                this.f44209c.setColor(getResources().getColor(R.color.rf_color_gery_2_40_666666));
                this.f44209c.setAntiAlias(true);
                canvas.drawText(this.f44207a[i], ((float) (width / 2)) - (this.f44209c.measureText(this.f44207a[i]) / 2.0f), (float) ((length * i) + length), this.f44209c);
                this.f44209c.reset();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
