package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.DiminaEngine;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.p109v8.C8369V8;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.p108ui.windowpop.GlobalDispatcher;
import com.didi.dimina.starbox.util.AppCtxProvider;
import com.didi.dimina.starbox.util.ForegroundChecker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class MemoryProvider implements IPerformance<JSONObject>, ForegroundChecker.OnForegroundChange, Runnable {
    public static String TAG_TOTAL_MEMORY = "total";
    public static String TAG_V8_MEMORY = "v8_memory";

    /* renamed from: a */
    private IDataProvider<JSONObject> f19958a;

    /* renamed from: b */
    private final JSONObject f19959b = new JSONObject();

    /* renamed from: c */
    private final String f19960c;

    /* renamed from: d */
    private final Debug.MemoryInfo f19961d = new Debug.MemoryInfo();

    /* renamed from: e */
    private final int[] f19962e = {Process.myPid()};

    /* renamed from: f */
    private Method f19963f;

    /* renamed from: g */
    private String f19964g = "0m";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f19965h;

    /* renamed from: i */
    private V8MemoryTask f19966i;

    public MemoryProvider(String str) {
        this.f19960c = str;
    }

    public void registerProvider(IDataProvider<JSONObject> iDataProvider) {
        this.f19958a = iDataProvider;
        GlobalDispatcher.post(this);
    }

    public void run() {
        m16940c();
        try {
            this.f19959b.put(TAG_TOTAL_MEMORY, m16938a());
            this.f19959b.put(TAG_V8_MEMORY, (double) this.f19965h);
            this.f19958a.onProvide(this.f19959b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GlobalDispatcher.postDelay(this, 1000);
    }

    /* renamed from: a */
    private String m16938a() {
        ActivityManager activityManager;
        if (Build.VERSION.SDK_INT < 29 && (activityManager = (ActivityManager) AppCtxProvider.getApp().getSystemService("activity")) != null) {
            Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(this.f19962e);
            if (processMemoryInfo.length > 0) {
                return (((float) processMemoryInfo[0].getTotalPss()) / 1024.0f) + "m";
            }
        }
        String lowerCase = C8333a.m16943a("RES").toLowerCase(Locale.US);
        if (lowerCase.startsWith("0")) {
            return this.f19964g;
        }
        this.f19964g = lowerCase;
        return lowerCase;
    }

    /* renamed from: b */
    private float m16939b() {
        int totalPss;
        try {
            if (this.f19963f == null) {
                Method declaredMethod = Debug.class.getDeclaredMethod("getMemoryInfo", new Class[]{Integer.TYPE, Debug.MemoryInfo.class});
                this.f19963f = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            this.f19963f.invoke(Debug.class, new Object[]{Integer.valueOf(Process.myPid()), this.f19961d});
            totalPss = this.f19961d.getTotalPss();
        } catch (Exception e) {
            e.printStackTrace();
            Debug.getMemoryInfo(this.f19961d);
            LogUtil.m16838d("MemoryInfo", C8333a.m16943a("RES") + "  " + this.f19961d);
            totalPss = this.f19961d.getTotalPss();
        }
        return ((float) totalPss) / 1024.0f;
    }

    /* renamed from: c */
    private void m16940c() {
        DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(this.f19960c);
        if (findDMMinaByAppId != null) {
            V8MemoryTask v8MemoryTask = this.f19966i;
            if (v8MemoryTask == null || v8MemoryTask.dmMina != findDMMinaByAppId) {
                JSEngineWrapper jSEngine = findDMMinaByAppId.getJSEngine();
                try {
                    Field declaredField = JSEngineWrapper.class.getDeclaredField("b");
                    declaredField.setAccessible(true);
                    DiminaEngine diminaEngine = (DiminaEngine) declaredField.get(jSEngine);
                    Field declaredField2 = DiminaEngine.class.getDeclaredField("mV8Runtime");
                    declaredField2.setAccessible(true);
                    V8MemoryTask v8MemoryTask2 = new V8MemoryTask(findDMMinaByAppId, new Handler(diminaEngine.getLooper()), (C8369V8) declaredField2.get(diminaEngine));
                    this.f19966i = v8MemoryTask2;
                    v8MemoryTask2.track();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                this.f19966i.track();
            }
        }
    }

    class V8MemoryTask implements Runnable {
        final DMMina dmMina;
        final Handler handler;

        /* renamed from: v8 */
        final C8369V8 f19967v8;

        V8MemoryTask(DMMina dMMina, Handler handler2, C8369V8 v8) {
            this.dmMina = dMMina;
            this.handler = handler2;
            this.f19967v8 = v8;
        }

        public void run() {
            for (String str : this.f19967v8.heapRecordStats().split(";")) {
                if (!str.isEmpty()) {
                    LogUtil.m16838d("JSMemoryInfo", str);
                    if (str.startsWith("total_heap_size-")) {
                        float unused = MemoryProvider.this.f19965h = ((((float) Integer.parseInt(str.split("-", 2)[1])) + 0.0f) / 1024.0f) / 1024.0f;
                    }
                }
            }
        }

        public void track() {
            this.handler.post(this);
        }
    }

    public void onChange(boolean z) {
        GlobalDispatcher.removeCallbacks(this);
        if (z) {
            GlobalDispatcher.post(this);
        }
    }
}
