package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class BundleCompat {

    static class BundleCompatBaseImpl {
        private static final String TAG = "BundleCompatBaseImpl";
        private static Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        private BundleCompatBaseImpl() {
        }

        public static IBinder getBinder(Bundle bundle, String str) {
            if (!sGetIBinderMethodFetched) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    sGetIBinderMethod = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    SystemUtils.log(4, TAG, "Failed to retrieve getIBinder method", e, "androidx.core.app.BundleCompat$BundleCompatBaseImpl", 53);
                }
                sGetIBinderMethodFetched = true;
            }
            Method method2 = sGetIBinderMethod;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    SystemUtils.log(4, TAG, "Failed to invoke getIBinder via reflection", e2, "androidx.core.app.BundleCompat$BundleCompatBaseImpl", 63);
                    sGetIBinderMethod = null;
                }
            }
            return null;
        }

        public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
            if (!sPutIBinderMethodFetched) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    sPutIBinderMethod = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    SystemUtils.log(4, TAG, "Failed to retrieve putIBinder method", e, "androidx.core.app.BundleCompat$BundleCompatBaseImpl", 77);
                }
                sPutIBinderMethodFetched = true;
            }
            Method method2 = sPutIBinderMethod;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    SystemUtils.log(4, TAG, "Failed to invoke putIBinder via reflection", e2, "androidx.core.app.BundleCompat$BundleCompatBaseImpl", 87);
                    sPutIBinderMethod = null;
                }
            }
        }
    }

    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return BundleCompatBaseImpl.getBinder(bundle, str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            BundleCompatBaseImpl.putBinder(bundle, str, iBinder);
        }
    }
}
