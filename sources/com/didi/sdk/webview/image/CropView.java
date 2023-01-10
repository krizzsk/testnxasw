package com.didi.sdk.webview.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CropView extends View {
    public static final int BORDERDISTANCE = 50;

    /* renamed from: a */
    private Paint f41160a;

    /* renamed from: b */
    private int f41161b;

    /* renamed from: c */
    private int f41162c;

    public CropView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41160a = new Paint();
    }

    public void setWidthScale(int i) {
        this.f41161b = i;
    }

    public void setHeightScale(int i) {
        this.f41162c = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i = ((width - 100) * this.f41162c) / this.f41161b;
        this.f41160a.setColor(-1442840576);
        float f = (float) width;
        float f2 = (float) ((height - i) / 2);
        Canvas canvas2 = canvas;
        float f3 = f;
        canvas2.drawRect(0.0f, 0.0f, f3, f2, this.f41160a);
        float f4 = (float) ((i + height) / 2);
        canvas2.drawRect(0.0f, f4, f3, (float) height, this.f41160a);
        float f5 = f2;
        float f6 = f4;
        canvas2.drawRect(0.0f, f5, 50.0f, f6, this.f41160a);
        float f7 = (float) (width - 50);
        canvas2.drawRect(f7, f5, f, f6, this.f41160a);
        this.f41160a.setColor(-1);
        this.f41160a.setStrokeWidth(2.0f);
        float f8 = f7;
        canvas2.drawLine(50.0f, f5, f8, f2, this.f41160a);
        float f9 = f4;
        canvas2.drawLine(50.0f, f4, f8, f9, this.f41160a);
        float f10 = f2;
        canvas2.drawLine(50.0f, f10, 50.0f, f9, this.f41160a);
        canvas2.drawLine(f7, f10, f7, f9, this.f41160a);
    }
}
