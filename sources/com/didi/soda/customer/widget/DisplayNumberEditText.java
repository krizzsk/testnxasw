package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.didi.passenger.C11267R;

public class DisplayNumberEditText extends MaxLengthEditText {

    /* renamed from: a */
    private static final int f44146a = 25;

    /* renamed from: b */
    private int f44147b;

    /* renamed from: c */
    private int f44148c;

    /* renamed from: d */
    private float f44149d;

    /* renamed from: e */
    private float f44150e;

    /* renamed from: f */
    private float f44151f;

    /* renamed from: g */
    private float f44152g = 25.0f;

    /* renamed from: h */
    private Paint f44153h;

    public DisplayNumberEditText(Context context) {
        super(context);
        m32871a(context, (AttributeSet) null);
    }

    public DisplayNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32871a(context, attributeSet);
    }

    public DisplayNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32871a(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = getText().length();
        String valueOf = String.valueOf(length);
        int width = (int) ((((float) getWidth()) - this.f44149d) - this.f44153h.measureText(String.valueOf(length) + "/" + String.valueOf(this.mMaxNumber)));
        this.f44153h.setColor(this.f44147b);
        float height = (float) ((int) ((((float) getHeight()) - this.f44150e) - this.f44151f));
        canvas.drawText(valueOf, (float) width, height, this.f44153h);
        this.f44153h.setColor(this.f44148c);
        canvas.drawText("/" + String.valueOf(this.mMaxNumber), (float) (width + ((int) this.f44153h.measureText(valueOf))), height, this.f44153h);
    }

    /* renamed from: a */
    private void m32871a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.DisplayNumberEditText);
            this.mMaxNumber = obtainStyledAttributes.getInt(3, 0);
            this.f44147b = obtainStyledAttributes.getColor(0, 0);
            this.f44148c = obtainStyledAttributes.getColor(4, 0);
            this.f44152g = obtainStyledAttributes.getDimension(5, 25.0f);
            this.f44149d = obtainStyledAttributes.getDimension(2, 0.0f);
            this.f44150e = obtainStyledAttributes.getDimension(1, 0.0f);
            obtainStyledAttributes.recycle();
            setMaxNumber(this.mMaxNumber);
        }
        Paint paint = new Paint();
        this.f44153h = paint;
        paint.setAntiAlias(true);
        this.f44153h.setTextSize(this.f44152g);
        this.f44151f = (float) ((int) this.f44153h.getFontMetrics().bottom);
    }
}
