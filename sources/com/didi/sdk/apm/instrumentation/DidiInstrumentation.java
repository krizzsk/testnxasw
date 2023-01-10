package com.didi.sdk.apm.instrumentation;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class DidiInstrumentation extends Instrumentation {

    /* renamed from: c */
    private static final String f37794c = "DidiInstrumentation";

    /* renamed from: d */
    private static String[] f37795d = {"android.os.Parcel.createException"};

    /* renamed from: a */
    Instrumentation f37796a;

    /* renamed from: b */
    boolean f37797b = false;

    public DidiInstrumentation(Instrumentation instrumentation) {
        this.f37796a = instrumentation;
    }

    public DidiInstrumentation(Instrumentation instrumentation, boolean z) {
        this.f37796a = instrumentation;
        this.f37797b = z;
    }

    public boolean onException(Object obj, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("onException:");
        String str = "";
        sb.append(obj != null ? obj.toString() : str);
        Log.e(f37794c, sb.toString(), th);
        String stackTraceString = Log.getStackTraceString(th);
        HashMap hashMap = new HashMap();
        if (obj != null) {
            str = obj.toString();
        }
        hashMap.put("obj", str);
        hashMap.put("error", stackTraceString);
        OmegaSDKAdapter.trackEvent("tech_instrumentation_error", (Map<String, Object>) hashMap);
        if (stackTraceString != null) {
            for (String contains : f37795d) {
                if (stackTraceString.contains(contains)) {
                    Log.e(f37794c, "will not catch exception");
                    return true;
                }
            }
        }
        return false;
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Instrumentation instrumentation = this.f37796a;
        if (instrumentation != null) {
            return instrumentation.newActivity(classLoader, str, intent);
        }
        return super.newActivity(classLoader, str, intent);
    }

    public Application newApplication(ClassLoader classLoader, String str, Context context) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Instrumentation instrumentation = this.f37796a;
        if (instrumentation != null) {
            return instrumentation.newApplication(classLoader, str, context);
        }
        return super.newApplication(classLoader, str, context);
    }
}
