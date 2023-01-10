package com.didi.addressnew.view.enhance;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.didi.common.map.util.DisplayUtils;

public class RoundBackgroundColorSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f9427a;

    /* renamed from: b */
    private int f9428b;

    /* renamed from: c */
    private int f9429c;

    /* renamed from: d */
    private boolean f9430d;

    /* renamed from: e */
    private Context f9431e;

    public RoundBackgroundColorSpan(Context context, int i, int i2, int i3, boolean z) {
        this.f9427a = i;
        this.f9428b = i2;
        this.f9429c = i3;
        this.f9430d = z;
        this.f9431e = context;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) paint.measureText(charSequence, i, i2);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (paint != null) {
            int color = paint.getColor();
            paint.setColor(this.f9427a);
            DisplayUtils.dp2px(this.f9431e, 12.0f);
            float dp2px = (float) DisplayUtils.dp2px(this.f9431e, 4.0f);
            float dp2px2 = (float) DisplayUtils.dp2px(this.f9431e, 8.0f);
            if (charSequence.length() > i && i2 <= charSequence.length()) {
                String charSequence2 = charSequence.subSequence(i, i2).toString();
                float f2 = f + dp2px;
                RectF rectF = new RectF(f2, ((float) i3) + 8.5f, ((float) (((int) paint.measureText(charSequence, i, i2)) - 25)) + f2, ((float) i5) - 4.5f);
                canvas.drawRoundRect(rectF, dp2px2, dp2px2, paint);
                paint.setFakeBoldText(true);
                paint.setTextSize((float) this.f9429c);
                paint.setColor(this.f9428b);
                paint.setTextAlign(Paint.Align.CENTER);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                int centerY = (int) ((rectF.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f));
                if (charSequence2 != null) {
                    canvas.drawText(charSequence2, rectF.centerX(), (float) centerY, paint);
                }
                paint.setColor(color);
            }
        }
    }
}
