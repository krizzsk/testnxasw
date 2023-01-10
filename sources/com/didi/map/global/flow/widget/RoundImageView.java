package com.didi.map.global.flow.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C11267R;

public class RoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private int f29828a;

    /* renamed from: b */
    private int f29829b;

    /* renamed from: c */
    private int f29830c;

    /* renamed from: d */
    private int f29831d;

    /* renamed from: e */
    private int f29832e;

    /* renamed from: f */
    private int f29833f;

    /* renamed from: g */
    private int f29834g;

    /* renamed from: h */
    private Path f29835h;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29830c = 0;
        this.f29835h = new Path();
        m23105a(context, attributeSet);
    }

    /* renamed from: a */
    private void m23105a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RoundImageView);
            this.f29830c = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.f29831d = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            this.f29832e = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
            this.f29833f = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            this.f29834g = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
            obtainStyledAttributes.recycle();
            if (this.f29831d == 0) {
                this.f29831d = this.f29830c;
            }
            if (this.f29832e == 0) {
                this.f29832e = this.f29830c;
            }
            if (this.f29833f == 0) {
                this.f29833f = this.f29830c;
            }
            if (this.f29834g == 0) {
                this.f29834g = this.f29830c;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f29828a = getWidth();
        this.f29829b = getHeight();
    }

    public void setCornersRadius(int i, int i2, int i3, int i4) {
        this.f29831d = i;
        this.f29832e = i2;
        this.f29833f = i3;
        this.f29834g = i4;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int max = Math.max(this.f29831d, this.f29833f) + Math.max(this.f29832e, this.f29834g);
        int max2 = Math.max(this.f29831d, this.f29832e) + Math.max(this.f29833f, this.f29834g);
        if (this.f29828a >= max && this.f29829b > max2) {
            this.f29835h.reset();
            this.f29835h.moveTo((float) this.f29831d, 0.0f);
            this.f29835h.lineTo((float) (this.f29828a - this.f29832e), 0.0f);
            Path path = this.f29835h;
            int i = this.f29828a;
            path.quadTo((float) i, 0.0f, (float) i, (float) this.f29832e);
            this.f29835h.lineTo((float) this.f29828a, (float) (this.f29829b - this.f29834g));
            Path path2 = this.f29835h;
            int i2 = this.f29828a;
            int i3 = this.f29829b;
            path2.quadTo((float) i2, (float) i3, (float) (i2 - this.f29834g), (float) i3);
            this.f29835h.lineTo((float) this.f29833f, (float) this.f29829b);
            Path path3 = this.f29835h;
            int i4 = this.f29829b;
            path3.quadTo(0.0f, (float) i4, 0.0f, (float) (i4 - this.f29833f));
            this.f29835h.lineTo(0.0f, (float) this.f29831d);
            this.f29835h.quadTo(0.0f, 0.0f, (float) this.f29831d, 0.0f);
            canvas.clipPath(this.f29835h);
        }
        super.onDraw(canvas);
    }
}
