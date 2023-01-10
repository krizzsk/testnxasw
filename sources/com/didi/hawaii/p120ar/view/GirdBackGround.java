package com.didi.hawaii.p120ar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.didi.hawaii.p120ar.utils.DisplayUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.GirdBackGround */
public class GirdBackGround extends View {

    /* renamed from: a */
    private Paint f25658a = new Paint();

    /* renamed from: b */
    private Path f25659b;

    /* renamed from: c */
    private int f25660c;

    /* renamed from: d */
    private int f25661d;

    public GirdBackGround(Context context) {
        super(context);
        m20405a();
    }

    public GirdBackGround(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20405a();
    }

    public GirdBackGround(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20405a();
    }

    /* renamed from: a */
    private void m20405a() {
        this.f25658a.setColor(getResources().getColor(R.color.gird_color));
        this.f25658a.setAntiAlias(true);
        this.f25658a.setStyle(Paint.Style.STROKE);
        this.f25658a.setStrokeWidth(1.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f25660c = getMeasuredWidth();
        this.f25661d = getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((float) (this.f25660c / 2), (float) (this.f25661d / 2));
        canvas.save();
        m20406a(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private void m20406a(Canvas canvas) {
        Rect rect = new Rect(((-this.f25660c) / 2) + getPaddingLeft(), ((-this.f25661d) / 2) + getPaddingTop(), (this.f25660c / 2) - getPaddingRight(), (this.f25661d / 2) - getPaddingBottom());
        if (this.f25659b == null) {
            this.f25659b = new Path();
            float dip2px = (float) DisplayUtils.dip2px(getContext(), 8.0f);
            int i = 0;
            int i2 = 0;
            while (true) {
                float f = ((float) i2) * dip2px;
                if (((float) rect.left) + f > ((float) rect.right)) {
                    break;
                }
                this.f25659b.moveTo(((float) rect.left) + f, (float) rect.top);
                this.f25659b.lineTo(((float) rect.left) + f, (float) rect.bottom);
                i2++;
            }
            while (true) {
                float f2 = ((float) i) * dip2px;
                if (((float) rect.top) + f2 > ((float) rect.bottom)) {
                    break;
                }
                this.f25659b.moveTo((float) rect.left, ((float) rect.top) + f2);
                this.f25659b.lineTo((float) rect.right, ((float) rect.top) + f2);
                i++;
            }
        }
        canvas.drawPath(this.f25659b, this.f25658a);
    }
}
