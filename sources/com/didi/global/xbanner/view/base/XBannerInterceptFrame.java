package com.didi.global.xbanner.view.base;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

class XBannerInterceptFrame extends FrameLayout {

    /* renamed from: a */
    private static final int f24859a = 500;

    /* renamed from: b */
    private View.OnClickListener f24860b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Rect f24861c = new Rect();

    public XBannerInterceptFrame(Context context) {
        super(context);
    }

    public XBannerInterceptFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XBannerInterceptFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setNotInterceptArea(View view) {
        CheckHandler checkHandler = new CheckHandler(this);
        Message obtain = Message.obtain();
        obtain.arg1 = 1;
        obtain.obj = view;
        checkHandler.sendMessageDelayed(obtain, 500);
    }

    private static class CheckHandler extends Handler {
        private WeakReference<XBannerInterceptFrame> ref;

        CheckHandler(XBannerInterceptFrame xBannerInterceptFrame) {
            this.ref = new WeakReference<>(xBannerInterceptFrame);
        }

        public void handleMessage(Message message) {
            XBannerInterceptFrame xBannerInterceptFrame = (XBannerInterceptFrame) this.ref.get();
            if (xBannerInterceptFrame != null) {
                ((View) message.obj).getGlobalVisibleRect(xBannerInterceptFrame.f24861c);
                if (message.arg1 >= 5 || xBannerInterceptFrame.m19944a()) {
                    removeCallbacksAndMessages((Object) null);
                    return;
                }
                Message obtain = Message.obtain();
                obtain.arg1 += message.arg1;
                obtain.obj = message.obj;
                sendMessageDelayed(obtain, 500);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19944a() {
        return (this.f24861c.top == 0 && this.f24861c.bottom == 0) ? false : true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f24861c == null) {
            return false;
        }
        if ((motionEvent.getRawY() >= ((float) this.f24861c.top) && motionEvent.getRawX() <= ((float) this.f24861c.bottom)) || this.f24860b == null) {
            return false;
        }
        setVisibility(8);
        this.f24860b.onClick(this);
        return false;
    }

    public void setInterceptListener(View.OnClickListener onClickListener) {
        this.f24860b = onClickListener;
    }
}
