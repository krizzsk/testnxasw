package com.didi.map.global.component.dropoff.recmarker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.common.map.util.DisplayUtils;

public class StrokeTextView extends AppCompatTextView {

    /* renamed from: a */
    TextPaint f27846a = new TextPaint();

    /* renamed from: b */
    private final int f27847b;

    /* renamed from: c */
    private final float f27848c;

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27848c = (float) DisplayUtils.dp2px(context, 2.0f);
        this.f27847b = -1;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        ColorStateList textColors = getTextColors();
        TextPaint paint = getPaint();
        this.f27846a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f27846a.setStrokeJoin(Paint.Join.ROUND);
        this.f27846a.setStrokeMiter(10.0f);
        setTextColor(this.f27847b);
        this.f27846a.setStrokeWidth(this.f27848c);
        super.onDraw(canvas);
        this.f27846a.setStyle(Paint.Style.FILL);
        setTextColor(textColors);
        super.onDraw(canvas);
    }
}
