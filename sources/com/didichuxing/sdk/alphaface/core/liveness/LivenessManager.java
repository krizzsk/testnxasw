package com.didichuxing.sdk.alphaface.core.liveness;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.didichuxing.sdk.alphaface.core.AlphaFaceFacade;
import com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy;
import com.didichuxing.sdk.alphaface.utils.AFLog;
import com.didichuxing.sdk.alphaface.utils.SkipFrame;
import java.util.concurrent.atomic.AtomicBoolean;

public class LivenessManager implements LifecycleObserver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AlphaFaceNativeProxy f51269a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final HandlerThread f51270b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f51271c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicBoolean f51272d;

    /* renamed from: e */
    private final SkipFrame f51273e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C17136a f51274f;

    /* renamed from: g */
    private final LivenessConfig f51275g;

    /* renamed from: h */
    private final C17138c f51276h;

    public LivenessManager(LivenessConfig livenessConfig) {
        this.f51272d = new AtomicBoolean(false);
        AlphaFaceNativeProxy afNative = AlphaFaceFacade.getInstance().getAfNative();
        this.f51269a = afNative;
        afNative.setLivenessThres(livenessConfig.getFrame_time_interval(), livenessConfig.getYaw_thresh(), livenessConfig.getPitch_thresh(), livenessConfig.getOcc_thresh(), livenessConfig.getIllum_thresh(), livenessConfig.getBlur_thresh());
        this.f51275g = livenessConfig;
        this.f51276h = new C17138c(this);
        HandlerThread handlerThread = new HandlerThread("LivenessManager");
        this.f51270b = handlerThread;
        handlerThread.start();
        this.f51271c = new Handler(this.f51270b.getLooper());
        this.f51273e = new SkipFrame(livenessConfig.getSkipTime());
        C17139d dVar = new C17139d(this);
        this.f51274f = dVar;
        dVar.mo127156a(new C17137b(this));
    }

    public LivenessManager(LivenessConfig livenessConfig, Lifecycle lifecycle) {
        this(livenessConfig);
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }

    public void detect(byte[] bArr, int i, int i2, int i3, int i4, float f, float f2, float f3, boolean z) {
        if (!this.f51272d.get() && !this.f51273e.skip()) {
            final int i5 = i;
            final int i6 = i2;
            final byte[] bArr2 = bArr;
            final int i7 = i3;
            final boolean z2 = z;
            final int i8 = i4;
            final float f4 = f;
            final float f5 = f2;
            final float f6 = f3;
            this.f51271c.post(new Runnable() {
                public void run() {
                    int i;
                    int i2;
                    if (!LivenessManager.this.f51272d.get()) {
                        byte[] bArr = new byte[(i5 * i6 * 4)];
                        long currentTimeMillis = System.currentTimeMillis();
                        LivenessManager.this.f51269a.yuvToRGBA(bArr2, i5, i6, bArr, 360 - i7, false);
                        if (z2) {
                            i2 = i5;
                            i = i6;
                        } else {
                            i2 = i6;
                            i = i5;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        AFLog.m38441v("yuvToRGBA NV21 to Bitmap consume: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        LivenessManager.this.f51274f.mo127157a(bArr, i2, i, i8, f4, f5, f6);
                        return;
                    }
                    LivenessManager.this.f51271c.removeCallbacksAndMessages((Object) null);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AlphaFaceNativeProxy mo127138a() {
        return this.f51269a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public LivenessConfig mo127139b() {
        return this.f51275g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C17138c mo127140c() {
        return this.f51276h;
    }

    public void reset() {
        this.f51274f.mo127161d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void restart() {
        this.f51276h.onRestart();
        this.f51274f.mo127161d();
        this.f51272d.set(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void exit() {
        this.f51272d.set(true);
        this.f51271c.removeCallbacksAndMessages((Object) null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void release() {
        this.f51272d.set(true);
        Handler handler = this.f51271c;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f51271c.post(new Runnable() {
                public void run() {
                    LivenessManager.this.f51271c.removeCallbacksAndMessages((Object) null);
                    AlphaFaceFacade.getInstance().unInitModels();
                    if (LivenessManager.this.f51270b != null) {
                        LivenessManager.this.f51270b.quit();
                    }
                }
            });
        }
    }
}
