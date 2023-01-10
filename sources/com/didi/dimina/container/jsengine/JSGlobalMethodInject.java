package com.didi.dimina.container.jsengine;

import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.method.Invoke;
import com.didi.dimina.container.jsengine.method.JSCallback;
import com.didi.dimina.container.jsengine.method.JSWindowApi;
import com.didi.dimina.container.jsengine.method.NativeLog;
import com.didi.dimina.container.jsengine.method.Publish;
import com.didi.dimina.container.jsengine.method.VConsoleLog;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import java.util.HashMap;

public class JSGlobalMethodInject {

    /* renamed from: a */
    private static final String f18711a = "DiminaServiceBridge";

    /* renamed from: b */
    private static final String f18712b = "invoke";

    /* renamed from: c */
    private static final String f18713c = "publish";

    /* renamed from: d */
    private static final String f18714d = "nativeLog";

    /* renamed from: e */
    private static final String f18715e = "vConsoleLog";

    /* renamed from: f */
    private static final String f18716f = "setTimeoutNative";

    /* renamed from: g */
    private static final String f18717g = "clearTimeoutNative";

    /* renamed from: h */
    private static final String f18718h = "setIntervalNative";

    /* renamed from: i */
    private static final String f18719i = "clearIntervalNative";

    /* renamed from: j */
    private static final String f18720j = "setTimeoutCallback";

    /* renamed from: k */
    private static final String f18721k = "setIntervalCallback";

    /* renamed from: l */
    private JSWindowApi f18722l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final DMMina f18723m;

    public JSGlobalMethodInject(DMMina dMMina) {
        this.f18723m = dMMina;
    }

    public void inject() {
        JSEngineWrapper jSEngine = this.f18723m.getJSEngine();
        jSEngine.registerCallBack(f18711a, f18712b, new Invoke(this.f18723m));
        jSEngine.registerCallBack(f18711a, f18713c, new Publish(this.f18723m));
        jSEngine.registerCallBack(f18714d, new NativeLog(this.f18723m));
        jSEngine.registerCallBack(f18715e, new VConsoleLog(this.f18723m));
        jSEngine.registerCallBack(f18716f, new JSCallbackImpl(f18716f));
        jSEngine.registerCallBack(f18718h, new JSCallbackImpl(f18718h));
        jSEngine.registerCallBack(f18717g, new JSCallbackImpl(f18717g));
        jSEngine.registerCallBack(f18719i, new JSCallbackImpl(f18719i));
        this.f18722l = new JSWindowApi(this.f18723m);
    }

    public JSWindowApi getJSWindowApi() {
        return this.f18722l;
    }

    public void release() {
        this.f18722l.release();
    }

    private class JSCallbackImpl implements JSCallback {
        private final String methodName;

        public JSCallbackImpl(String str) {
            this.methodName = str;
        }

        public Object callback(JSArray jSArray) {
            try {
                return JSGlobalMethodInject.this.m15900a(this.methodName, jSArray);
            } catch (Exception e) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("method", this.methodName);
                    hashMap.put("params", jSArray.toJSONString());
                    hashMap.put("error", Log.getStackTraceString(e));
                    TraceUtil.trackEventError(JSGlobalMethodInject.this.f18723m.getMinaIndex(), "WindowAPIexception", 1001, JSONUtil.toJson(hashMap));
                    LogUtil.eRelease("WindowAPIException", Log.getStackTraceString(e));
                } catch (Exception unused) {
                }
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m15900a(java.lang.String r6, com.didi.dimina.container.jsengine.JSArray r7) {
        /*
            r5 = this;
            com.didi.dimina.container.jsengine.-$$Lambda$JSGlobalMethodInject$9iEhNmcPXjyen3jqc1Imf2_tkM0 r0 = new com.didi.dimina.container.jsengine.-$$Lambda$JSGlobalMethodInject$9iEhNmcPXjyen3jqc1Imf2_tkM0
            r0.<init>(r6)
            int r1 = r6.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1738842218: goto L_0x002e;
                case 592190347: goto L_0x0024;
                case 1024241897: goto L_0x001a;
                case 1776676414: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0038
        L_0x0010:
            java.lang.String r1 = "setIntervalNative"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0038
            r6 = 2
            goto L_0x0039
        L_0x001a:
            java.lang.String r1 = "clearIntervalNative"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0038
            r6 = 3
            goto L_0x0039
        L_0x0024:
            java.lang.String r1 = "clearTimeoutNative"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0038
            r6 = 1
            goto L_0x0039
        L_0x002e:
            java.lang.String r1 = "setTimeoutNative"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0038
            r6 = 0
            goto L_0x0039
        L_0x0038:
            r6 = -1
        L_0x0039:
            if (r6 == 0) goto L_0x0059
            if (r6 == r4) goto L_0x0053
            if (r6 == r3) goto L_0x004d
            if (r6 == r2) goto L_0x0047
            java.lang.String r6 = "unsupported method invoke"
            com.didi.dimina.container.util.LogUtil.m16839e(r6)
            goto L_0x005e
        L_0x0047:
            com.didi.dimina.container.jsengine.method.JSWindowApi r6 = r5.f18722l
            r6.clearInterval(r7)
            goto L_0x005e
        L_0x004d:
            com.didi.dimina.container.jsengine.method.JSWindowApi r6 = r5.f18722l
            r6.setInterval(r7, r0)
            goto L_0x005e
        L_0x0053:
            com.didi.dimina.container.jsengine.method.JSWindowApi r6 = r5.f18722l
            r6.clearTimeout(r7)
            goto L_0x005e
        L_0x0059:
            com.didi.dimina.container.jsengine.method.JSWindowApi r6 = r5.f18722l
            r6.setTimeout(r7, r0)
        L_0x005e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.jsengine.JSGlobalMethodInject.m15900a(java.lang.String, com.didi.dimina.container.jsengine.JSArray):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15901a(String str, Object[] objArr) {
        String str2 = TextUtils.equals(str, f18716f) ? f18720j : f18721k;
        JSEngineWrapper jSEngine = this.f18723m.getJSEngine();
        jSEngine.executeScript(str2 + "(\"" + objArr[0] + "\")");
    }
}
