package com.didi.map.global.component.streetview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C11267R;

public class RoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private int f28532a;

    /* renamed from: b */
    private int f28533b;

    /* renamed from: c */
    private int f28534c;

    /* renamed from: d */
    private int f28535d;

    /* renamed from: e */
    private int f28536e;

    /* renamed from: f */
    private int f28537f;

    /* renamed from: g */
    private int f28538g;

    /* renamed from: h */
    private Path f28539h;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28534c = 0;
        this.f28539h = new Path();
        m22286a(context, attributeSet);
    }

    /* renamed from: a */
    private void m22286a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RoundImageView);
            this.f28534c = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.f28535d = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            this.f28536e = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
            this.f28537f = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            this.f28538g = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
            obtainStyledAttributes.recycle();
            if (this.f28535d == 0) {
                this.f28535d = this.f28534c;
            }
            if (this.f28536e == 0) {
                this.f28536e = this.f28534c;
            }
            if (this.f28537f == 0) {
                this.f28537f = this.f28534c;
            }
            if (this.f28538g == 0) {
                this.f28538g = this.f28534c;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f28532a = getWidth();
        this.f28533b = getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int max = Math.max(this.f28535d, this.f28537f) + Math.max(this.f28536e, this.f28538g);
        int max2 = Math.max(this.f28535d, this.f28536e) + Math.max(this.f28537f, this.f28538g);
        Path path = this.f28539h;
        if (path != null && this.f28532a >= max && this.f28533b > max2) {
            path.reset();
            this.f28539h.moveTo((float) this.f28535d, 0.0f);
            this.f28539h.lineTo((float) (this.f28532a - this.f28536e), 0.0f);
            Path path2 = this.f28539h;
            int i = this.f28532a;
            path2.quadTo((float) i, 0.0f, (float) i, (float) this.f28536e);
            this.f28539h.lineTo((float) this.f28532a, (float) (this.f28533b - this.f28538g));
            Path path3 = this.f28539h;
            int i2 = this.f28532a;
            int i3 = this.f28533b;
            path3.quadTo((float) i2, (float) i3, (float) (i2 - this.f28538g), (float) i3);
            this.f28539h.lineTo((float) this.f28537f, (float) this.f28533b);
            Path path4 = this.f28539h;
            int i4 = this.f28533b;
            path4.quadTo(0.0f, (float) i4, 0.0f, (float) (i4 - this.f28537f));
            this.f28539h.lineTo(0.0f, (float) this.f28535d);
            this.f28539h.quadTo(0.0f, 0.0f, (float) this.f28535d, 0.0f);
            canvas.clipPath(this.f28539h);
        }
        super.onDraw(canvas);
    }
}
