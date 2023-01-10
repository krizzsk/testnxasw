package com.didi.dimina.container.p065ui.map.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.dimina.container.util.PixUtil;

/* renamed from: com.didi.dimina.container.ui.map.view.DMCornerImageView */
public class DMCornerImageView extends AppCompatImageView {

    /* renamed from: a */
    private float[] f19462a;

    /* renamed from: b */
    private final PaintFlagsDrawFilter f19463b;

    /* renamed from: c */
    private final Path f19464c;

    /* renamed from: d */
    private final RectF f19465d;

    public DMCornerImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DMCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19462a = new float[8];
        this.f19464c = new Path();
        this.f19465d = new RectF();
        this.f19463b = new PaintFlagsDrawFilter(0, 1);
        float dip2px = (float) PixUtil.dip2px(context, 10.0f);
        float[] fArr = this.f19462a;
        fArr[0] = dip2px;
        fArr[1] = dip2px;
        fArr[2] = dip2px;
        fArr[3] = dip2px;
    }

    public void setRadius(float[] fArr) {
        this.f19462a = fArr;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float[] fArr = this.f19462a;
        if (!(fArr == null || fArr.length <= 0 || this.f19465d == null)) {
            this.f19464c.reset();
            this.f19465d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f19464c.addRoundRect(this.f19465d, this.f19462a, Path.Direction.CW);
            canvas.setDrawFilter(this.f19463b);
            canvas.clipPath(this.f19464c);
        }
        super.onDraw(canvas);
    }
}
