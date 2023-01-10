package com.didi.entrega.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.didi.passenger.C11267R;

public class DisplayNumberEditText extends MaxLengthEditText {

    /* renamed from: a */
    private static final int f22151a = 25;

    /* renamed from: b */
    private int f22152b;

    /* renamed from: c */
    private int f22153c;

    /* renamed from: d */
    private float f22154d;

    /* renamed from: e */
    private float f22155e;

    /* renamed from: f */
    private float f22156f;

    /* renamed from: g */
    private float f22157g = 25.0f;

    /* renamed from: h */
    private Paint f22158h;

    public DisplayNumberEditText(Context context) {
        super(context);
        m18321a(context, (AttributeSet) null);
    }

    public DisplayNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18321a(context, attributeSet);
    }

    public DisplayNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18321a(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = getText().length();
        String valueOf = String.valueOf(length);
        int width = (int) ((((float) getWidth()) - this.f22154d) - this.f22158h.measureText(String.valueOf(length) + "/" + String.valueOf(this.mMaxNumber)));
        this.f22158h.setColor(this.f22152b);
        float height = (float) ((int) ((((float) getHeight()) - this.f22155e) - this.f22156f));
        canvas.drawText(valueOf, (float) width, height, this.f22158h);
        this.f22158h.setColor(this.f22153c);
        canvas.drawText("/" + String.valueOf(this.mMaxNumber), (float) (width + ((int) this.f22158h.measureText(valueOf))), height, this.f22158h);
    }

    /* renamed from: a */
    private void m18321a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaDisplayNumberEditText);
            this.mMaxNumber = obtainStyledAttributes.getInt(3, 0);
            this.f22152b = obtainStyledAttributes.getColor(0, 0);
            this.f22153c = obtainStyledAttributes.getColor(4, 0);
            this.f22157g = obtainStyledAttributes.getDimension(5, 25.0f);
            this.f22154d = obtainStyledAttributes.getDimension(2, 0.0f);
            this.f22155e = obtainStyledAttributes.getDimension(1, 0.0f);
            obtainStyledAttributes.recycle();
            setMaxNumber(this.mMaxNumber);
        }
        Paint paint = new Paint();
        this.f22158h = paint;
        paint.setAntiAlias(true);
        this.f22158h.setTextSize(this.f22157g);
        this.f22156f = (float) ((int) this.f22158h.getFontMetrics().bottom);
    }
}
