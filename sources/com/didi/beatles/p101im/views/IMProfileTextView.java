package com.didi.beatles.p101im.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* renamed from: com.didi.beatles.im.views.IMProfileTextView */
public class IMProfileTextView extends AppCompatTextView {

    /* renamed from: a */
    private int f11763a;

    /* renamed from: b */
    private int f11764b;

    public IMProfileTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMProfileTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMProfileTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 16842884);
        this.f11764b = Color.parseColor("#ff9933");
        m10086a();
    }

    public void setColor(int i) {
        this.f11764b = i;
    }

    /* renamed from: a */
    private void m10086a() {
        this.f11763a = ((int) getPaint().measureText("字")) / 2;
        setPadding(getPaddingLeft(), 0, this.f11763a, 0);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.save();
        int left = getLeft();
        int right = getRight();
        int top = getTop();
        int bottom = getBottom();
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        int i = right - left;
        float f = (float) i;
        path.lineTo(f, 0.0f);
        int i2 = bottom - top;
        path.lineTo((float) ((i - this.f11763a) + 5), (float) (i2 / 2));
        float f2 = (float) i2;
        path.lineTo(f, f2);
        path.lineTo(0.0f, f2);
        path.close();
        Paint paint = new Paint();
        paint.setColor(this.f11764b);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
        canvas.restore();
        super.onDraw(canvas);
    }
}
