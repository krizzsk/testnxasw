package com.didi.sdk.apm.crash;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.utils.ReflectUtils;
import com.didi.sdk.apm.utils.RemoteConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppCrashInterceptor implements Handler.Callback {

    /* renamed from: a */
    private static final String f37752a = "AppCrashInterceptor";

    /* renamed from: b */
    private static final String f37753b = "global_app_system_crash_intercept";

    /* renamed from: c */
    private static final String f37754c = "systemError";

    /* renamed from: d */
    private static AppCrashInterceptor f37755d = new AppCrashInterceptor();

    /* renamed from: e */
    private static boolean f37756e = false;

    /* renamed from: f */
    private static int f37757f = 134;

    /* renamed from: g */
    private static Handler.Callback f37758g;

    /* renamed from: h */
    private static List<String> f37759h;

    /* renamed from: i */
    private static String[] f37760i = {"can't deliver broadcast"};

    public static synchronized void init() {
        synchronized (AppCrashInterceptor.class) {
            if (!f37756e) {
                f37756e = true;
                try {
                    m28474a();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m28474a() {
        synchronized (AppCrashInterceptor.class) {
            if (RemoteConfiguration.isOpen(f37753b, true)) {
                List<String> splittableConfig = RemoteConfiguration.getSplittableConfig(f37753b, f37754c);
                f37759h = splittableConfig;
                if (splittableConfig == null) {
                    f37759h = new ArrayList();
                }
                f37759h.addAll(Arrays.asList(f37760i));
            }
        }
    }

    public static void hookActivityThreadHandler(Object obj) {
        try {
            f37757f = ((Integer) ReflectUtils.getFieldObject("android.app.ActivityThread$H", (Object) null, "SCHEDULE_CRASH")).intValue();
            Handler handler = (Handler) ReflectUtils.getFieldObject("android.app.ActivityThread", obj, "mH");
            f37758g = (Handler.Callback) ReflectUtils.getFieldObject("android.os.Handler", handler, "mCallback");
            ReflectUtils.setFieldObject("android.os.Handler", "mCallback", handler, f37755d);
            Log.w(f37752a, "hookActivityThread success ");
        } catch (Exception e) {
            Log.w(f37752a, "hookActivityThread failed ", e);
        }
    }

    public boolean handleMessage(Message message) {
        if (m28475a(message)) {
            return true;
        }
        Handler.Callback callback = f37758g;
        if (callback == null || !callback.handleMessage(message)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m28475a(Message message) {
        List<String> list;
        if (message.what != f37757f || !(message.obj instanceof String) || (list = f37759h) == null || list.size() <= 0) {
            return false;
        }
        String str = (String) message.obj;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String next : f37759h) {
            if (!TextUtils.isEmpty(next) && str.startsWith(next)) {
                Log.w(f37752a, "Intercepted an error from system, error = " + str);
                return true;
            }
        }
        return false;
    }
}
