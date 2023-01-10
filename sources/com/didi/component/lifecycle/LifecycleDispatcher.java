package com.didi.component.lifecycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LifecycleDispatcher implements Lifecycle {

    /* renamed from: a */
    private List<LifecycleListener> f16033a = Collections.synchronizedList(new ArrayList());

    public final void dispatchAdd() {
        for (LifecycleListener onAdd : m13316a()) {
            onAdd.onAdd();
        }
    }

    public final void dispatchPageStart() {
        for (LifecycleListener onPageStart : m13316a()) {
            onPageStart.onPageStart();
        }
    }

    public final void dispatchPageResume() {
        for (LifecycleListener onPageResume : m13316a()) {
            onPageResume.onPageResume();
        }
    }

    public final void dispatchPagePause() {
        for (LifecycleListener onPagePause : m13316a()) {
            onPagePause.onPagePause();
        }
    }

    public final void dispatchPageStop() {
        for (LifecycleListener onPageStop : m13316a()) {
            onPageStop.onPageStop();
        }
    }

    public final void dispatchRemove() {
        for (LifecycleListener onRemove : m13316a()) {
            onRemove.onRemove();
        }
    }

    public final void dispatchPageShow() {
        for (LifecycleListener onPageShow : m13316a()) {
            onPageShow.onPageShow();
        }
    }

    public final void dispatchPageHide() {
        for (LifecycleListener onPageHide : m13316a()) {
            onPageHide.onPageHide();
        }
    }

    public final void dispatchLeaveHome() {
        for (LifecycleListener onLeaveHome : m13316a()) {
            onLeaveHome.onLeaveHome();
        }
    }

    public final void dispatchBackHome() {
        for (LifecycleListener onBackHome : m13316a()) {
            onBackHome.onBackHome();
        }
    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        this.f16033a.add(lifecycleListener);
    }

    /* renamed from: a */
    private LifecycleListener[] m13316a() {
        List<LifecycleListener> list = this.f16033a;
        return (LifecycleListener[]) list.toArray(new LifecycleListener[list.size()]);
    }
}
