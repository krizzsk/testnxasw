package com.didi.component.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.passenger.C11267R;

public class RoundFrameLayout extends FrameLayout {

    /* renamed from: a */
    float f13709a;

    /* renamed from: b */
    float f13710b;

    /* renamed from: c */
    private int f13711c;

    /* renamed from: d */
    private int f13712d;

    /* renamed from: e */
    private int f13713e;

    /* renamed from: f */
    private int f13714f;

    /* renamed from: g */
    private int f13715g;

    /* renamed from: h */
    private int f13716h;

    /* renamed from: i */
    private int f13717i;

    /* renamed from: j */
    private int f13718j;

    /* renamed from: k */
    private int f13719k;

    /* renamed from: l */
    private int f13720l;

    /* renamed from: m */
    private int f13721m;

    /* renamed from: n */
    private int f13722n;

    /* renamed from: o */
    private Path f13723o;

    public RoundFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13711c = 0;
        m11424a(context, attributeSet);
    }

    /* renamed from: a */
    private void m11424a(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, (Paint) null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RoundFrameLayout);
        this.f13712d = obtainStyledAttributes.getDimensionPixelOffset(2, this.f13711c);
        this.f13713e = obtainStyledAttributes.getDimensionPixelOffset(1, this.f13711c);
        this.f13714f = obtainStyledAttributes.getDimensionPixelOffset(4, this.f13711c);
        this.f13715g = obtainStyledAttributes.getDimensionPixelOffset(3, this.f13711c);
        this.f13716h = obtainStyledAttributes.getDimensionPixelOffset(0, this.f13711c);
        if (this.f13711c == this.f13713e) {
            this.f13713e = this.f13712d;
        }
        if (this.f13711c == this.f13714f) {
            this.f13714f = this.f13712d;
        }
        if (this.f13711c == this.f13715g) {
            this.f13715g = this.f13712d;
        }
        if (this.f13711c == this.f13716h) {
            this.f13716h = this.f13712d;
        }
        obtainStyledAttributes.recycle();
        this.f13717i = Math.max(this.f13713e, this.f13716h);
        int max = Math.max(this.f13714f, this.f13715g);
        this.f13718j = max;
        this.f13719k = this.f13717i + max;
        this.f13720l = Math.max(this.f13713e, this.f13714f);
        int max2 = Math.max(this.f13716h, this.f13715g);
        this.f13721m = max2;
        this.f13722n = this.f13720l + max2;
        this.f13723o = new Path();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f13709a = (float) getWidth();
        this.f13710b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f13709a >= ((float) this.f13719k) && this.f13710b > ((float) this.f13722n)) {
            this.f13723o.reset();
            this.f13723o.moveTo((float) this.f13713e, 0.0f);
            this.f13723o.lineTo(this.f13709a - ((float) this.f13714f), 0.0f);
            Path path = this.f13723o;
            float f = this.f13709a;
            path.quadTo(f, 0.0f, f, (float) this.f13714f);
            this.f13723o.lineTo(this.f13709a, this.f13710b - ((float) this.f13715g));
            Path path2 = this.f13723o;
            float f2 = this.f13709a;
            float f3 = this.f13710b;
            path2.quadTo(f2, f3, f2 - ((float) this.f13715g), f3);
            this.f13723o.lineTo((float) this.f13716h, this.f13710b);
            Path path3 = this.f13723o;
            float f4 = this.f13710b;
            path3.quadTo(0.0f, f4, 0.0f, f4 - ((float) this.f13716h));
            this.f13723o.lineTo(0.0f, (float) this.f13713e);
            this.f13723o.quadTo(0.0f, 0.0f, (float) this.f13713e, 0.0f);
            canvas.clipPath(this.f13723o);
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f13709a >= ((float) this.f13719k) && this.f13710b > ((float) this.f13722n)) {
            this.f13723o.reset();
            this.f13723o.moveTo((float) this.f13713e, 0.0f);
            this.f13723o.lineTo(this.f13709a - ((float) this.f13714f), 0.0f);
            Path path = this.f13723o;
            float f = this.f13709a;
            path.quadTo(f, 0.0f, f, (float) this.f13714f);
            this.f13723o.lineTo(this.f13709a, this.f13710b - ((float) this.f13715g));
            Path path2 = this.f13723o;
            float f2 = this.f13709a;
            float f3 = this.f13710b;
            path2.quadTo(f2, f3, f2 - ((float) this.f13715g), f3);
            this.f13723o.lineTo((float) this.f13716h, this.f13710b);
            Path path3 = this.f13723o;
            float f4 = this.f13710b;
            path3.quadTo(0.0f, f4, 0.0f, f4 - ((float) this.f13716h));
            this.f13723o.lineTo(0.0f, (float) this.f13713e);
            this.f13723o.quadTo(0.0f, 0.0f, (float) this.f13713e, 0.0f);
            canvas.clipPath(this.f13723o);
        }
        super.dispatchDraw(canvas);
    }
}
