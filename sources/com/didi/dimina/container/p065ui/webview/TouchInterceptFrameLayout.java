package com.didi.dimina.container.p065ui.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.didi.dimina.container.util.SnapShotUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didi.dimina.container.ui.webview.TouchInterceptFrameLayout */
public class TouchInterceptFrameLayout extends FrameLayout {

    /* renamed from: a */
    private boolean f19740a;

    /* renamed from: b */
    private CopyOnWriteArrayList<TouchInterceptFrame> f19741b;

    /* renamed from: c */
    private boolean f19742c;

    public TouchInterceptFrameLayout(Context context) {
        super(context);
        m16801a();
    }

    public TouchInterceptFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16801a();
    }

    public TouchInterceptFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16801a();
    }

    public void setInterceptEnabled(boolean z) {
        this.f19740a = z;
    }

    /* renamed from: a */
    private void m16801a() {
        this.f19740a = false;
        this.f19742c = false;
        this.f19741b = new CopyOnWriteArrayList<>();
    }

    public void updateInterceptFrame(Map<String, List<TouchInterceptFrame>> map) {
        this.f19741b = new CopyOnWriteArrayList<>();
        for (List<TouchInterceptFrame> addAll : map.values()) {
            this.f19741b.addAll(addAll);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (SnapShotUtil.getInstance().isNeedInterceptSnapshot()) {
            SnapShotUtil.getInstance().stopTimingSaveSnapshot();
        }
        if (!this.f19740a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0 && motionEvent.getPointerId(motionEvent.getActionIndex()) == 0) {
            this.f19742c = true;
            Iterator<TouchInterceptFrame> it = this.f19741b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TouchInterceptFrame next = it.next();
                if (next != null && ((float) next.f19738x) < motionEvent.getX() && motionEvent.getX() < ((float) (next.f19738x + next.width)) && ((float) next.f19739y) < motionEvent.getY() && motionEvent.getY() < ((float) (next.f19739y + next.height))) {
                    this.f19742c = false;
                    break;
                }
            }
        }
        if (!this.f19742c) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
