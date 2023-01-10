package com.didichuxing.swarm.launcher;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewManager;
import android.view.WindowManager;
import com.didichuxing.swarm.toolkit.ToolkitService;
import org.osgi.framework.launch.Framework;

/* renamed from: com.didichuxing.swarm.launcher.d */
/* compiled from: ToolkitServiceImpl */
class C17300d implements ToolkitService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f51764a;

    /* renamed from: b */
    private final Handler f51765b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C17301e f51766c;

    /* renamed from: d */
    private final Application f51767d;

    /* renamed from: e */
    private final Framework f51768e;

    C17300d(Application application, Framework framework) {
        this.f51767d = application;
        this.f51768e = framework;
        this.f51766c = new C17301e((WindowManager) application.getSystemService("window"));
        if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new ToolkitServiceImpl$1(this));
        }
    }

    public ViewManager getViewManager() {
        return this.f51766c;
    }

    public void show() {
        this.f51765b.post(new ToolkitServiceImpl$2(this));
    }

    public void hide() {
        this.f51765b.post(new ToolkitServiceImpl$3(this));
    }

    public Activity getActivity() {
        return this.f51764a;
    }

    /* renamed from: a */
    public Application mo127734a() {
        return this.f51767d;
    }
}
