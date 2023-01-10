package com.didichuxing.swarm.launcher;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.didichuxing.swarm.launcher.e */
/* compiled from: ViewManagerDelegate */
class C17301e implements ViewManager, Iterable<Map.Entry<View, ViewGroup.LayoutParams>> {

    /* renamed from: a */
    private final ViewManager f51769a;

    /* renamed from: b */
    private final Map<View, ViewGroup.LayoutParams> f51770b = Collections.synchronizedMap(new LinkedHashMap());

    public C17301e(ViewManager viewManager) {
        this.f51769a = viewManager;
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        synchronized (this.f51770b) {
            this.f51769a.addView(view, layoutParams);
            this.f51770b.put(view, layoutParams);
        }
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        this.f51769a.updateViewLayout(view, layoutParams);
        this.f51770b.put(view, layoutParams);
    }

    public void removeView(View view) {
        synchronized (this.f51770b) {
            this.f51769a.removeView(view);
            this.f51770b.remove(view);
        }
    }

    public Iterator<Map.Entry<View, ViewGroup.LayoutParams>> iterator() {
        return this.f51770b.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127739a() {
        synchronized (this.f51770b) {
            for (View visibility : this.f51770b.keySet()) {
                visibility.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo127741b() {
        synchronized (this.f51770b) {
            for (View visibility : this.f51770b.keySet()) {
                visibility.setVisibility(4);
            }
        }
    }
}
