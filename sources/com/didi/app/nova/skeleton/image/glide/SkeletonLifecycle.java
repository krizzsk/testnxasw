package com.didi.app.nova.skeleton.image.glide;

import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.util.C1850Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class SkeletonLifecycle implements Lifecycle {

    /* renamed from: a */
    private Set<LifecycleListener> f10296a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private boolean f10297b;

    /* renamed from: c */
    private boolean f10298c;

    public void addListener(LifecycleListener lifecycleListener) {
        this.f10296a.add(lifecycleListener);
        if (this.f10297b) {
            lifecycleListener.onDestroy();
        } else if (this.f10298c) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    public void removeListener(LifecycleListener lifecycleListener) {
        this.f10296a.remove(lifecycleListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45852a() {
        this.f10298c = true;
        for (T onStart : C1850Util.getSnapshot(this.f10296a)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo45853b() {
        this.f10298c = false;
        for (T onStop : C1850Util.getSnapshot(this.f10296a)) {
            onStop.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo45854c() {
        this.f10297b = true;
        for (T onDestroy : C1850Util.getSnapshot(this.f10296a)) {
            onDestroy.onDestroy();
        }
    }
}
