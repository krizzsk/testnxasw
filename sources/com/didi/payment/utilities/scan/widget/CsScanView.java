package com.didi.payment.utilities.scan.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.didi.payment.utilities.scan.widget.CsViewFinderView;
import com.didi.unifiedPay.util.UIUtils;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.taxis99.R;
import p068me.dm7.barcodescanner.core.IViewFinder;

public class CsScanView extends CsI25ZBarScannerView {

    /* renamed from: b */
    private CsViewFinderView f34253b;

    /* renamed from: c */
    private float f34254c;

    public CsScanView(Context context) {
        super(context);
    }

    public CsScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public IViewFinder createViewFinderView(Context context) {
        CsViewFinderView csViewFinderView = new CsViewFinderView(context);
        this.f34253b = csViewFinderView;
        csViewFinderView.setBorderColor(Integer.MIN_VALUE);
        this.f34253b.setBorderStrokeWidth(UIUtils.dip2px(getContext(), 4.0f));
        this.f34253b.setBorderLineLength(UIUtils.dip2px(getContext(), 32.0f));
        this.f34253b.setBorderCornerRounded(false);
        this.f34253b.setBorderCornerRadius(0);
        this.f34253b.setLaserEnabled(true);
        this.f34253b.setLaserColor(getResources().getColor(R.color.wallet_color_FF6F26));
        this.f34253b.setMaskColor(-436207616);
        this.f34253b.setSquareViewFinder(false);
        this.f34253b.setViewFinderOffset(0);
        return this.f34253b;
    }

    public void startCamera() {
        try {
            super.startCamera();
        } catch (RuntimeException e) {
            LogUtils.m36180e(e.getMessage());
        }
    }

    public void stopCamera() {
        super.stopCamera();
    }

    public void setOnFrameUpdatedListener(CsViewFinderView.OnFrameRectUpdatedListener onFrameRectUpdatedListener) {
        CsViewFinderView csViewFinderView = this.f34253b;
        if (csViewFinderView != null) {
            csViewFinderView.setOnFrameRectUpdatedListener(onFrameRectUpdatedListener);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float a = m26169a(motionEvent);
            float f = this.f34254c;
            if (a > f) {
                setZoom(true);
            } else if (a < f) {
                setZoom(false);
            }
            this.f34254c = a;
        } else if (action == 5) {
            this.f34254c = m26169a(motionEvent);
        }
        return true;
    }

    /* renamed from: a */
    private static float m26169a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }
}
