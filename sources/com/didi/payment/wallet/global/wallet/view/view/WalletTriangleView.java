package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class WalletTriangleView extends View {
    public static final byte STYLE_DOWN = 2;
    public static final byte STYLE_LEFT = 3;
    public static final byte STYLE_RIGHT = 4;
    public static final byte STYLE_UP = 1;

    /* renamed from: a */
    private Paint f35080a;

    /* renamed from: b */
    private Path f35081b;

    /* renamed from: c */
    private byte f35082c;

    public WalletTriangleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WalletTriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletTriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f35082c = 1;
        m26732a();
    }

    /* renamed from: a */
    private void m26732a() {
        Paint paint = new Paint(1);
        this.f35080a = paint;
        paint.setStrokeJoin(Paint.Join.ROUND);
        this.f35080a.setColor(-10780240);
        this.f35081b = new Path();
    }

    public void setColor(int i) {
        this.f35080a.setColor(i);
    }

    public void setStyle(byte b) {
        this.f35082c = b;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        this.f35081b.reset();
        int width = getWidth();
        int height = getHeight();
        byte b = this.f35082c;
        if (b == 1) {
            this.f35081b.moveTo((float) (width / 2), 0.0f);
            float f = (float) height;
            this.f35081b.lineTo((float) width, f);
            this.f35081b.lineTo(0.0f, f);
        } else if (b == 2) {
            this.f35081b.moveTo(0.0f, 0.0f);
            this.f35081b.lineTo((float) (width / 2), (float) height);
            this.f35081b.lineTo((float) width, 0.0f);
        } else if (b == 3) {
            this.f35081b.moveTo(0.0f, (float) (height / 2));
            float f2 = (float) width;
            this.f35081b.lineTo(f2, 0.0f);
            this.f35081b.lineTo(f2, (float) height);
        } else if (b == 4) {
            this.f35081b.moveTo(0.0f, 0.0f);
            this.f35081b.lineTo(0.0f, (float) height);
            this.f35081b.lineTo((float) width, (float) (height / 2));
        }
        this.f35081b.close();
        canvas.drawPath(this.f35081b, this.f35080a);
    }
}
