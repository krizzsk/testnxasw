package com.didi.sdk.apm;

import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.didi.sdk.apm.utils.RemoteConfiguration;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;

public class ToastCompatHelper {

    /* renamed from: a */
    private static final String f37723a = "ToastCompatHelper";

    /* renamed from: b */
    private static final String f37724b = "global_app_toast_fix_illegalstate_exception";

    /* renamed from: c */
    private static final boolean f37725c = false;

    /* renamed from: d */
    private static boolean f37726d = false;
    public static boolean sIsInit = false;

    /* renamed from: a */
    private static boolean m28440a() {
        return RemoteConfiguration.isOpen(f37724b, false);
    }

    public static void hook() {
        try {
            sIsInit = true;
            f37726d = m28440a();
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            if (Build.VERSION.SDK_INT < 26 || f37726d) {
                Log.i(f37723a, "hook start");
                Class<?> cls = Class.forName("android.os.ServiceManager");
                ClassLoader classLoader = cls.getClassLoader();
                Class[] clsArr = {IBinder.class};
                Field declaredField = cls.getDeclaredField("sCache");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get((Object) null);
                map.put("notification", (IBinder) Proxy.newProxyInstance(classLoader, clsArr, new BinderProxyHookHandler((IBinder) cls.getDeclaredMethod("getService", new Class[]{String.class}).invoke((Object) null, new Object[]{"notification"}))));
                Field declaredField2 = Toast.class.getDeclaredField("sService");
                declaredField2.setAccessible(true);
                declaredField2.set((Object) null, (Object) null);
            }
        } catch (Exception e) {
            Log.e(f37723a, "hook err", e);
        }
    }

    public static void releaseHook() {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            if (Build.VERSION.SDK_INT < 26 || f37726d) {
                Log.i(f37723a, "hook start");
                Class<?> cls = Class.forName("android.os.ServiceManager");
                Field declaredField = cls.getDeclaredField("sCache");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get((Object) null);
                map.put("notification", (IBinder) cls.getDeclaredMethod("getService", new Class[]{String.class}).invoke((Object) null, new Object[]{"notification"}));
                Field declaredField2 = Toast.class.getDeclaredField("sService");
                declaredField2.setAccessible(true);
                declaredField2.set((Object) null, (Object) null);
            }
        } catch (Exception e) {
            Log.e(f37723a, "releaseHook err", e);
        }
    }

    private static class BinderProxyHookHandler implements InvocationHandler {
        IBinder base;
        Class<?> iinterface;
        Class<?> stub;

        BinderProxyHookHandler(IBinder iBinder) {
            this.base = iBinder;
            try {
                this.stub = Class.forName("android.app.INotificationManager$Stub");
                this.iinterface = Class.forName("android.app.INotificationManager");
            } catch (ClassNotFoundException e) {
                Log.e(ToastCompatHelper.f37723a, "get INotificationManager err", e);
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.base, objArr);
            }
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{this.iinterface}, new NotificationHookHandler(this.base, this.stub));
        }
    }

    public static class NotificationHookHandler implements InvocationHandler {
        Object base;

        NotificationHookHandler(IBinder iBinder, Class<?> cls) {
            try {
                this.base = cls.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
            } catch (Exception e) {
                Log.e(ToastCompatHelper.f37723a, "get asInterface err", e);
                ToastCompatHelper.releaseHook();
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ("enqueueToast".equals(method.getName())) {
                Log.d(ToastCompatHelper.f37723a, "hook enqueueToast args=" + Arrays.toString(objArr));
                ToastCompatHelper.m28441b(objArr[1]);
            }
            return method.invoke(this.base, objArr);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m28441b(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            declaredField.set(obj, new ToastHandler((Handler) declaredField.get(obj)));
        } catch (Exception e) {
            Log.e(f37723a, "rp  ToastHandler err", e);
            releaseHook();
        }
    }

    private static class ToastHandler extends Handler {
        Handler mProxiedHandler;

        ToastHandler(Handler handler) {
            super(handler.getLooper());
            this.mProxiedHandler = handler;
        }

        public void dispatchMessage(Message message) {
            try {
                this.mProxiedHandler.dispatchMessage(message);
            } catch (WindowManager.BadTokenException e) {
                Log.e(ToastCompatHelper.f37723a, "dispatchMessage with BadTokenException: ", e);
            } catch (IllegalStateException e2) {
                Log.e(ToastCompatHelper.f37723a, "dispatchMessage with IllegalStateException: ", e2);
            }
        }
    }
}
