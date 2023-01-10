package com.didi.beatles.p101im.views.eggs.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMWindowUtil;
import com.didi.beatles.p101im.views.eggs.IIMEggsDrop;
import com.didi.beatles.p101im.views.eggs.IIMEggsView;
import com.didi.beatles.p101im.views.eggs.IMEggsDropFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didi.beatles.im.views.eggs.impl.IMEggsSurfaceView */
public class IMEggsSurfaceView extends SurfaceView implements SurfaceHolder.Callback, IIMEggsView, Runnable {

    /* renamed from: a */
    private static final String f12070a = IMEggsSurfaceView.class.getSimpleName();

    /* renamed from: b */
    private static final int f12071b = 20;

    /* renamed from: c */
    private static final int f12072c = 40;

    /* renamed from: d */
    private int f12073d;

    /* renamed from: e */
    private int f12074e;

    /* renamed from: f */
    private AtomicBoolean f12075f;

    /* renamed from: g */
    private AtomicBoolean f12076g;

    /* renamed from: h */
    private Thread f12077h;

    /* renamed from: i */
    private List<IIMEggsDrop> f12078i;

    /* renamed from: j */
    private IIMEggsView.OnDrawCallback f12079j;

    public IMEggsSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMEggsSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMEggsSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12073d = 20;
        this.f12074e = 40;
        this.f12075f = new AtomicBoolean(false);
        this.f12076g = new AtomicBoolean(false);
        this.f12078i = new CopyOnWriteArrayList();
        getHolder().setFormat(-2);
        getHolder().setFormat(-3);
        getHolder().addCallback(this);
        if (Build.VERSION.SDK_INT >= 21) {
            setZOrderOnTop(true);
        } else if (Build.VERSION.SDK_INT > 18) {
            setZOrderMediaOverlay(true);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IMLog.m10020d(f12070a, "[surfaceCreated]");
        this.f12075f = new AtomicBoolean(true);
        m10362a();
    }

    /* renamed from: a */
    private void m10362a() {
        this.f12076g.set(true);
        if (this.f12077h == null) {
            Thread thread = new Thread(this, "IMEggsSurfaceView");
            this.f12077h = thread;
            thread.start();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        String str = f12070a;
        IMLog.m10020d(str, "[surfaceChanged] width=" + i2 + " |height=" + i3);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IMLog.m10020d(f12070a, "[surfaceDestroyed]");
        m10364b();
        this.f12075f = new AtomicBoolean(false);
        this.f12077h = null;
    }

    /* renamed from: b */
    private void m10364b() {
        this.f12076g.set(false);
        Thread thread = this.f12077h;
        this.f12077h = null;
        try {
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFrameInterval(int i) {
        this.f12073d = i;
    }

    public void setMaxCount(int i) {
        this.f12074e = i;
    }

    public void displayEggs(IMConfig.EggsInfo eggsInfo, Bitmap bitmap) {
        if (getVisibility() == 0) {
            this.f12078i.clear();
            int min = Math.min(eggsInfo.count, this.f12074e);
            for (int i = 0; i < min; i++) {
                IIMEggsDrop create = IMEggsDropFactory.create(eggsInfo);
                if (create != null) {
                    create.init(bitmap, IMWindowUtil.dip2px((float) eggsInfo.width), IMWindowUtil.dip2px((float) eggsInfo.height));
                    this.f12078i.add(create);
                }
            }
        }
    }

    public void setOnDrawCallback(IIMEggsView.OnDrawCallback onDrawCallback) {
        this.f12079j = onDrawCallback;
    }

    public void reset() {
        if (this.f12079j != null) {
            for (IIMEggsDrop onFinished : this.f12078i) {
                this.f12079j.onFinished(onFinished);
            }
        }
        this.f12078i.clear();
    }

    public void run() {
        Canvas lockCanvas;
        while (this.f12076g.get()) {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.f12075f.get() && getHolder().getSurface().isValid() && (lockCanvas = getHolder().lockCanvas()) != null) {
                    m10363a(lockCanvas);
                    m10365b(lockCanvas);
                    getHolder().unlockCanvasAndPost(lockCanvas);
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (uptimeMillis2 - ((long) this.f12073d) < 0) {
                    try {
                        Thread.sleep(((long) this.f12073d) - uptimeMillis2);
                    } catch (InterruptedException e) {
                        IMLog.m10021e(f12070a, "[run]", e);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                reset();
                throw th;
            }
        }
        reset();
    }

    /* renamed from: a */
    private void m10363a(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    /* renamed from: b */
    private void m10365b(Canvas canvas) {
        for (IIMEggsDrop next : this.f12078i) {
            next.draw(canvas);
            if (!next.isActive()) {
                this.f12078i.remove(next);
                IIMEggsView.OnDrawCallback onDrawCallback = this.f12079j;
                if (!(onDrawCallback == null || next == null)) {
                    onDrawCallback.onFinished(next);
                }
            }
        }
    }
}
