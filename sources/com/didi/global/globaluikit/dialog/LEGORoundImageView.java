package com.didi.global.globaluikit.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C11267R;

public class LEGORoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private float f24405a;

    /* renamed from: b */
    private float f24406b;

    /* renamed from: c */
    private float f24407c;

    /* renamed from: d */
    private float f24408d;

    /* renamed from: e */
    private float f24409e;

    /* renamed from: f */
    private float f24410f;

    /* renamed from: g */
    private float f24411g;

    public LEGORoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGORoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGORoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19613a(context, attributeSet);
    }

    /* renamed from: a */
    private void m19613a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.custom_Round_Image_View);
        float dimension = obtainStyledAttributes.getDimension(2, 0.0f);
        this.f24407c = dimension;
        if (dimension != 0.0f) {
            this.f24409e = dimension;
            this.f24408d = dimension;
            this.f24411g = dimension;
            this.f24410f = dimension;
            obtainStyledAttributes.recycle();
            return;
        }
        this.f24409e = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f24408d = obtainStyledAttributes.getDimension(1, 0.0f);
        this.f24410f = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f24411g = obtainStyledAttributes.getDimension(3, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f24405a = (float) getWidth();
        this.f24406b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.f24408d, 0.0f);
        path.lineTo(this.f24405a - this.f24410f, 0.0f);
        float f = this.f24405a;
        path.quadTo(f, 0.0f, f, this.f24410f);
        path.lineTo(this.f24405a, this.f24406b - this.f24411g);
        float f2 = this.f24405a;
        float f3 = this.f24406b;
        path.quadTo(f2, f3, f2 - this.f24411g, f3);
        path.lineTo(this.f24409e, this.f24406b);
        float f4 = this.f24406b;
        path.quadTo(0.0f, f4, 0.0f, f4 - this.f24409e);
        path.lineTo(0.0f, this.f24408d);
        path.quadTo(0.0f, 0.0f, this.f24408d, 0.0f);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
