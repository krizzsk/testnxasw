package com.xiaojuchefu.prism.monitor.core;

import android.content.Context;
import java.lang.reflect.Field;
import java.util.List;

public class GlobalWindowManager {

    /* renamed from: a */
    private static GlobalWindowManager f58862a;

    /* renamed from: b */
    private final WindowObserver f58863b = new WindowObserver();

    /* renamed from: c */
    private boolean f58864c;

    public static GlobalWindowManager getInstance() {
        GlobalWindowManager globalWindowManager;
        synchronized (GlobalWindowManager.class) {
            if (f58862a == null) {
                f58862a = new GlobalWindowManager();
            }
            globalWindowManager = f58862a;
        }
        return globalWindowManager;
    }

    private GlobalWindowManager() {
    }

    public void init(Context context) {
        if (!this.f58864c) {
            this.f58864c = true;
            m44506a(context);
        }
    }

    public WindowObserver getWindowObserver() {
        return this.f58863b;
    }

    /* renamed from: a */
    private void m44506a(Context context) {
        try {
            Object systemService = context.getSystemService("window");
            Field declaredField = systemService.getClass().getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(systemService);
            Field declaredField2 = obj.getClass().getDeclaredField("mViews");
            declaredField2.setAccessible(true);
            if (declaredField2.get(obj) instanceof List) {
                this.f58863b.addAll((List) declaredField2.get(obj));
                declaredField2.set(obj, this.f58863b);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }
}
