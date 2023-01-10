package com.didichuxing.sofa.animation;

import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: com.didichuxing.sofa.animation.t */
/* compiled from: RunnableWrapper */
class C17274t {

    /* renamed from: a */
    private WeakReference<View> f51697a;

    /* renamed from: b */
    private Runnable f51698b;

    C17274t(View view, Runnable runnable) {
        WeakReference<View> weakReference;
        if (view == null) {
            weakReference = null;
        } else {
            weakReference = new WeakReference<>(view);
        }
        this.f51697a = weakReference;
        this.f51698b = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo127665a() {
        WeakReference<View> weakReference = this.f51697a;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Runnable mo127666b() {
        return this.f51698b;
    }
}
