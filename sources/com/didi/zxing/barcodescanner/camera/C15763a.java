package com.didi.zxing.barcodescanner.camera;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.didi.zxing.barcodescanner.camera.a */
/* compiled from: CameraThread */
class C15763a {

    /* renamed from: a */
    private static final String f48051a = "CameraThread";

    /* renamed from: b */
    private static C15763a f48052b;

    /* renamed from: c */
    private Handler f48053c;

    /* renamed from: d */
    private HandlerThread f48054d;

    /* renamed from: e */
    private int f48055e = 0;

    /* renamed from: f */
    private final Object f48056f = new Object();

    /* renamed from: a */
    public static C15763a m36067a() {
        if (f48052b == null) {
            f48052b = new C15763a();
        }
        return f48052b;
    }

    private C15763a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo120368a(Runnable runnable) {
        synchronized (this.f48056f) {
            m36068c();
            this.f48053c.post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo120369a(Runnable runnable, long j) {
        synchronized (this.f48056f) {
            m36068c();
            this.f48053c.postDelayed(runnable, j);
        }
    }

    /* renamed from: c */
    private void m36068c() {
        synchronized (this.f48056f) {
            if (this.f48053c == null) {
                if (this.f48055e > 0) {
                    HandlerThread handlerThread = new HandlerThread(f48051a);
                    this.f48054d = handlerThread;
                    handlerThread.start();
                    this.f48053c = new Handler(this.f48054d.getLooper());
                } else {
                    throw new IllegalStateException("CameraThread is not open");
                }
            }
        }
    }

    /* renamed from: d */
    private void m36069d() {
        synchronized (this.f48056f) {
            this.f48054d.quit();
            this.f48054d = null;
            this.f48053c = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo120370b() {
        synchronized (this.f48056f) {
            int i = this.f48055e - 1;
            this.f48055e = i;
            if (i == 0) {
                m36069d();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo120371b(Runnable runnable) {
        synchronized (this.f48056f) {
            this.f48055e++;
            mo120368a(runnable);
        }
    }
}
