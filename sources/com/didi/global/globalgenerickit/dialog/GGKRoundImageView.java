package com.didi.global.globalgenerickit.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C11267R;

public class GGKRoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private float f24015a;

    /* renamed from: b */
    private float f24016b;

    /* renamed from: c */
    private float f24017c;

    /* renamed from: d */
    private float f24018d;

    /* renamed from: e */
    private float f24019e;

    /* renamed from: f */
    private float f24020f;

    /* renamed from: g */
    private float f24021g;

    public GGKRoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19429a(context, attributeSet);
    }

    /* renamed from: a */
    private void m19429a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.custom_Round_Image_View);
        float dimension = obtainStyledAttributes.getDimension(2, 0.0f);
        this.f24017c = dimension;
        if (dimension != 0.0f) {
            this.f24019e = dimension;
            this.f24018d = dimension;
            this.f24021g = dimension;
            this.f24020f = dimension;
            obtainStyledAttributes.recycle();
            return;
        }
        this.f24019e = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f24018d = obtainStyledAttributes.getDimension(1, 0.0f);
        this.f24020f = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f24021g = obtainStyledAttributes.getDimension(3, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f24015a = (float) getWidth();
        this.f24016b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.f24018d, 0.0f);
        path.lineTo(this.f24015a - this.f24020f, 0.0f);
        float f = this.f24015a;
        path.quadTo(f, 0.0f, f, this.f24020f);
        path.lineTo(this.f24015a, this.f24016b - this.f24021g);
        float f2 = this.f24015a;
        float f3 = this.f24016b;
        path.quadTo(f2, f3, f2 - this.f24021g, f3);
        path.lineTo(this.f24019e, this.f24016b);
        float f4 = this.f24016b;
        path.quadTo(0.0f, f4, 0.0f, f4 - this.f24019e);
        path.lineTo(0.0f, this.f24018d);
        path.quadTo(0.0f, 0.0f, this.f24018d, 0.0f);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
