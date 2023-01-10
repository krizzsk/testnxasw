package com.didi.nova.assembly.country.inner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.RequestConfiguration;
import com.taxis99.R;

public class SideBar extends View {

    /* renamed from: a */
    private OnTouchingLetterChangedListener f31651a;

    /* renamed from: b */
    private String[] f31652b;

    /* renamed from: c */
    private int f31653c;

    /* renamed from: d */
    private Paint f31654d;

    /* renamed from: e */
    private int f31655e;

    public interface OnTouchingLetterChangedListener {
        void onTouchingLetterChanged(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31652b = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, C17272q.f51679a, C17272q.f51680b, "Z"};
        this.f31653c = -1;
        this.f31654d = new Paint();
        init();
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SideBar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.f31655e = ContextCompat.getColor(getContext(), R.color.assembly_unit_color_333333);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int length = height / this.f31652b.length;
        for (int i = 0; i < this.f31652b.length; i++) {
            this.f31654d.setColor(this.f31655e);
            this.f31654d.setAntiAlias(true);
            this.f31654d.setTextSize(((float) length) * 0.8f);
            canvas.drawText(this.f31652b[i], (((float) width) / 2.0f) - (this.f31654d.measureText(this.f31652b[i]) / 2.0f), (float) ((length * i) + length), this.f31654d);
            this.f31654d.reset();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.f31653c;
        OnTouchingLetterChangedListener onTouchingLetterChangedListener = this.f31651a;
        float height = y / ((float) getHeight());
        String[] strArr = this.f31652b;
        int length = (int) (height * ((float) strArr.length));
        if (action == 1) {
            this.f31653c = -1;
            invalidate();
        } else if (i != length && length >= 0 && length < strArr.length) {
            if (onTouchingLetterChangedListener != null) {
                onTouchingLetterChangedListener.onTouchingLetterChanged(strArr[length]);
            }
            this.f31653c = length;
            invalidate();
        }
        return true;
    }

    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.f31651a = onTouchingLetterChangedListener;
    }
}
