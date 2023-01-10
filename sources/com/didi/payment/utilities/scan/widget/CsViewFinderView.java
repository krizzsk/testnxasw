package com.didi.payment.utilities.scan.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import p068me.dm7.barcodescanner.core.ViewFinderView;

public class CsViewFinderView extends ViewFinderView {

    /* renamed from: b */
    private static final int[] f34255b = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: c */
    private static final int f34256c = 10;

    /* renamed from: d */
    private static final long f34257d = 80;

    /* renamed from: a */
    private int f34258a;

    /* renamed from: e */
    private int f34259e;

    /* renamed from: f */
    private int f34260f;

    /* renamed from: g */
    private OnFrameRectUpdatedListener f34261g;

    public interface OnFrameRectUpdatedListener {
        void onFrameRectUpdated(Rect rect);
    }

    public CsViewFinderView(Context context) {
        super(context);
    }

    public CsViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFrameRectUpdatedListener(OnFrameRectUpdatedListener onFrameRectUpdatedListener) {
        this.f34261g = onFrameRectUpdatedListener;
    }

    public synchronized void updateFramingRect() {
        super.updateFramingRect();
        this.f34259e = getWidth() / 2;
        this.f34260f = getHeight() / 2;
        int height = getHeight() / 4;
        Rect framingRect = getFramingRect();
        framingRect.left = 0;
        framingRect.right = getWidth();
        framingRect.top = this.f34260f - (height / 2);
        framingRect.bottom = this.f34260f + (height / 2);
        if (this.f34261g != null) {
            this.f34261g.onFrameRectUpdated(framingRect);
        }
    }

    public void drawViewFinderMask(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect framingRect = getFramingRect();
        Canvas canvas2 = canvas;
        float f = (float) width;
        canvas2.drawRect(0.0f, 0.0f, f, (float) framingRect.top, this.mFinderMaskPaint);
        canvas2.drawRect(0.0f, (float) (framingRect.bottom + 1), f, (float) height, this.mFinderMaskPaint);
    }

    public void drawLaser(Canvas canvas) {
        Rect framingRect = getFramingRect();
        this.mLaserPaint.setAlpha(f34255b[this.f34258a]);
        this.f34258a = (this.f34258a + 1) % f34255b.length;
        canvas.drawRect((float) (framingRect.left + 2), (float) (this.f34260f - 5), (float) (framingRect.right - 1), (float) (this.f34260f + 5), this.mLaserPaint);
        postInvalidateDelayed(f34257d, framingRect.left - 10, framingRect.top - 10, framingRect.right + 10, framingRect.bottom + 10);
    }
}
