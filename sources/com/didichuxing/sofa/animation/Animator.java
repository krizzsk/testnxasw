package com.didichuxing.sofa.animation;

import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class Animator extends C17258c implements C17260e {

    /* renamed from: a */
    private static final String f51642a = "Animator";

    /* renamed from: b */
    private List<C17274t> f51643b = new ArrayList();

    interface PrepareAnimationCallback {
        void onPrepared();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo127538a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo127540a(C17273s sVar);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo127542b(C17273s sVar);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void mo127544c(C17273s sVar);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void mo127545d(C17273s sVar);

    public abstract boolean isRunning();

    public abstract boolean isStarted();

    public abstract Animator start();

    public abstract void stop();

    /* renamed from: d */
    private void m38742d() {
        SystemUtils.log(3, "sofa.animation.Animator", "Reverse is unsupported.", (Throwable) null, "com.didichuxing.sofa.animation.Animator", 34);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127541a(C17274t tVar) {
        if (tVar != null) {
            this.f51643b.add(tVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo127543b() {
        return !this.f51643b.isEmpty();
    }

    /* renamed from: e */
    private List<C17274t> m38743e() {
        return this.f51643b;
    }

    /* renamed from: f */
    private void m38744f() {
        this.f51643b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127539a(final PrepareAnimationCallback prepareAnimationCallback) {
        if (mo127543b()) {
            final List<C17274t> e = m38743e();
            for (C17274t a : e) {
                View a2 = a.mo127665a();
                if (a2 == null) {
                    LoggerUtil.m38758e(f51642a, "prepareAnimation error: target is null !!");
                } else {
                    a2.setVisibility(4);
                }
            }
            for (C17274t a3 : e) {
                View a4 = a3.mo127665a();
                if (a4 != null) {
                    a4.post(new Runnable() {
                        public void run() {
                            for (C17274t b : e) {
                                b.mo127666b().run();
                            }
                            PrepareAnimationCallback prepareAnimationCallback = prepareAnimationCallback;
                            if (prepareAnimationCallback != null) {
                                prepareAnimationCallback.onPrepared();
                            }
                        }
                    });
                    return;
                }
            }
        } else if (prepareAnimationCallback != null) {
            prepareAnimationCallback.onPrepared();
        }
    }
}
