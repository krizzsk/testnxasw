package com.didi.app.nova.skeleton;

import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.conductor.internal.ThreadUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ComponentGroup implements IScopeLifecycle, Iterable<Component> {

    /* renamed from: a */
    private List<Component> f10089a = new LinkedList();

    /* renamed from: b */
    private IScopeLifecycle.PageStatus f10090b = null;

    public final Component getComponent(Class<? extends Component> cls) {
        for (Component next : this.f10089a) {
            if (next.getClass() == cls) {
                return next;
            }
        }
        return null;
    }

    public final boolean addComponent(Component component) {
        ThreadUtils.ensureMainThread();
        if (component == null) {
            return false;
        }
        component.mo45328a();
        this.f10089a.add(component);
        if (this.f10090b == null) {
            return true;
        }
        int i = C42351.$SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus[this.f10090b.ordinal()];
        if (i == 1) {
            component.onCreate();
        } else if (i == 2) {
            component.onCreate();
            component.onStart();
        } else if (i == 3) {
            component.onCreate();
            component.onStart();
            component.onResume();
        } else if (i == 4) {
            component.onCreate();
            component.onStart();
        } else if (i == 5) {
            component.onCreate();
        }
        return true;
    }

    /* renamed from: com.didi.app.nova.skeleton.ComponentGroup$1 */
    static /* synthetic */ class C42351 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.app.nova.skeleton.IScopeLifecycle$PageStatus[] r0 = com.didi.app.nova.skeleton.IScopeLifecycle.PageStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus = r0
                com.didi.app.nova.skeleton.IScopeLifecycle$PageStatus r1 = com.didi.app.nova.skeleton.IScopeLifecycle.PageStatus.Create     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.app.nova.skeleton.IScopeLifecycle$PageStatus r1 = com.didi.app.nova.skeleton.IScopeLifecycle.PageStatus.Start     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.app.nova.skeleton.IScopeLifecycle$PageStatus r1 = com.didi.app.nova.skeleton.IScopeLifecycle.PageStatus.Resume     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.app.nova.skeleton.IScopeLifecycle$PageStatus r1 = com.didi.app.nova.skeleton.IScopeLifecycle.PageStatus.Pause     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.app.nova.skeleton.IScopeLifecycle$PageStatus r1 = com.didi.app.nova.skeleton.IScopeLifecycle.PageStatus.Stop     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.app.nova.skeleton.IScopeLifecycle$PageStatus r1 = com.didi.app.nova.skeleton.IScopeLifecycle.PageStatus.Destroy     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.skeleton.ComponentGroup.C42351.<clinit>():void");
        }
    }

    public boolean removeComponent(Component component) {
        ThreadUtils.ensureMainThread();
        if (component == null || !this.f10089a.remove(component)) {
            return false;
        }
        if (this.f10090b == null) {
            return true;
        }
        int i = C42351.$SwitchMap$com$didi$app$nova$skeleton$IScopeLifecycle$PageStatus[this.f10090b.ordinal()];
        if (i == 1) {
            component.onDestroy();
        } else if (i == 2) {
            component.onStop();
            component.onDestroy();
        } else if (i == 3) {
            component.onPause();
            component.onStop();
            component.onDestroy();
        } else if (i == 4) {
            component.onStop();
            component.onDestroy();
        } else if (i == 5) {
            component.onDestroy();
        }
        component.mo45330b();
        return true;
    }

    public final void clear() {
        this.f10089a.clear();
        this.f10090b = null;
    }

    public Iterator<Component> iterator() {
        return Collections.unmodifiableCollection(this.f10089a).iterator();
    }

    public void onCreate(ILive iLive) {
        this.f10090b = IScopeLifecycle.PageStatus.Create;
        for (Component onCreate : this.f10089a) {
            onCreate.onCreate();
        }
    }

    public void onStart(ILive iLive) {
        this.f10090b = IScopeLifecycle.PageStatus.Start;
        for (Component onStart : this.f10089a) {
            onStart.onStart();
        }
    }

    public void onResume(ILive iLive) {
        this.f10090b = IScopeLifecycle.PageStatus.Resume;
        for (Component onResume : this.f10089a) {
            onResume.onResume();
        }
    }

    public void onPause(ILive iLive) {
        this.f10090b = IScopeLifecycle.PageStatus.Pause;
        for (Component onPause : this.f10089a) {
            onPause.onPause();
        }
    }

    public void onStop(ILive iLive) {
        this.f10090b = IScopeLifecycle.PageStatus.Stop;
        for (Component onStop : this.f10089a) {
            onStop.onStop();
        }
    }

    public void onDestroy(ILive iLive) {
        this.f10090b = IScopeLifecycle.PageStatus.Destroy;
        for (Component onDestroy : this.f10089a) {
            onDestroy.onDestroy();
        }
    }
}
