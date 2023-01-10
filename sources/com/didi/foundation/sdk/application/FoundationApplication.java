package com.didi.foundation.sdk.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.multidex.MultiDex;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.foundation.sdk.service.LocaleService;
import com.didi.sdk.onehotpatch.ONEPatchFacade;
import com.didi.sofa.utils.ProcessUtils;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FoundationApplication extends Application {

    /* renamed from: a */
    private static final String f23019a = "com.didi.foundation.sdk.application.LaunchApplicationListener";

    /* renamed from: b */
    private Object f23020b;

    /* renamed from: c */
    private HashMap<String, Method> f23021c = new HashMap<>();

    public boolean isMainProcess() {
        return ProcessUtils.isMainProcess(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (isMainProcess()) {
            m18990a(this.f23020b, "onConfigurationChanged", this, configuration);
        }
    }

    public void onCreate() {
        super.onCreate();
        if (isMainProcess()) {
            m18990a(this.f23020b, NachoLifecycleManager.LIFECYCLE_ON_CREATE, this);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (isMainProcess()) {
            m18990a(this.f23020b, "onLowMemory", this);
        }
    }

    public void onTerminate() {
        super.onTerminate();
        if (isMainProcess()) {
            m18990a(this.f23020b, "onTerminate", this);
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (isMainProcess()) {
            m18990a(this.f23020b, "onTrimMemory", this, Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleService.getInstance().attachBaseContext(context));
        if (Build.VERSION.SDK_INT < 21) {
            MultiDex.install(this);
        }
        ONEPatchFacade.launch(this);
        m18989a();
        if (isMainProcess()) {
            m18990a(this.f23020b, "attachBaseContext", context);
        }
    }

    /* renamed from: a */
    private void m18989a() {
        try {
            Class<?> cls = Class.forName(f23019a, true, getClassLoader());
            this.f23020b = cls.newInstance();
            for (Method method : cls.getDeclaredMethods()) {
                this.f23021c.put(method.getName(), method);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m18990a(Object obj, String str, Object... objArr) {
        try {
            Method method = this.f23021c.get(str);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj, objArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
