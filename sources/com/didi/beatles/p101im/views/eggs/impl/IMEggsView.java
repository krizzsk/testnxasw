package com.didi.beatles.p101im.views.eggs.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMWindowUtil;
import com.didi.beatles.p101im.views.eggs.IIMEggsDrop;
import com.didi.beatles.p101im.views.eggs.IIMEggsView;
import com.didi.beatles.p101im.views.eggs.IMEggsDropFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didi.beatles.im.views.eggs.impl.IMEggsView */
public class IMEggsView extends View implements IIMEggsView {

    /* renamed from: a */
    private static final String f12080a = IMEggsView.class.getSimpleName();

    /* renamed from: b */
    private static final int f12081b = 20;

    /* renamed from: c */
    private static final int f12082c = 20;

    /* renamed from: d */
    private int f12083d;

    /* renamed from: e */
    private int f12084e;

    /* renamed from: f */
    private List<IIMEggsDrop> f12085f;

    /* renamed from: g */
    private IIMEggsView.OnDrawCallback f12086g;

    public IMEggsView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMEggsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMEggsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12083d = 20;
        this.f12084e = 20;
        this.f12085f = new CopyOnWriteArrayList();
    }

    public void setFrameInterval(int i) {
        this.f12083d = i;
    }

    public void setMaxCount(int i) {
        this.f12084e = i;
    }

    public void displayEggs(IMConfig.EggsInfo eggsInfo, Bitmap bitmap) {
        String str = f12080a;
        IMLog.m10020d(str, "[displayEggs] count=" + eggsInfo.count + " |size=" + this.f12085f.size());
        if (getVisibility() == 0) {
            this.f12085f.clear();
            int min = Math.min(eggsInfo.count, this.f12084e);
            for (int i = 0; i < min; i++) {
                IIMEggsDrop create = IMEggsDropFactory.create(eggsInfo);
                if (create != null) {
                    create.init(bitmap, IMWindowUtil.dip2px((float) eggsInfo.width), IMWindowUtil.dip2px((float) eggsInfo.height));
                    this.f12085f.add(create);
                }
            }
            invalidate();
        }
    }

    public void setOnDrawCallback(IIMEggsView.OnDrawCallback onDrawCallback) {
        this.f12086g = onDrawCallback;
    }

    public void reset() {
        this.f12085f.clear();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long uptimeMillis = SystemClock.uptimeMillis();
        m10366a(canvas);
        List<IIMEggsDrop> list = this.f12085f;
        if (list != null && list.size() > 0) {
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            int i = this.f12083d;
            if (uptimeMillis2 - ((long) i) < 0) {
                postInvalidateDelayed(((long) i) - uptimeMillis2);
            } else {
                postInvalidate();
            }
        }
    }

    /* renamed from: a */
    private void m10366a(Canvas canvas) {
        for (IIMEggsDrop next : this.f12085f) {
            next.draw(canvas);
            if (!next.isActive()) {
                this.f12085f.remove(next);
                IIMEggsView.OnDrawCallback onDrawCallback = this.f12086g;
                if (!(onDrawCallback == null || next == null)) {
                    onDrawCallback.onFinished(next);
                }
            }
        }
    }
}
