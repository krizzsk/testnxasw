package com.didi.sdk.apm.crash;

import android.os.Build;
import android.os.DeadSystemException;
import android.util.Log;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class DeadSystemExceptionInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f37763a = "DeadSystemExceptionInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            if (th instanceof RuntimeException) {
                if (isMatchSpecialExceptionMsg(th, "android.os.DeadSystemException") && isMatchSpecialStackTraceElement(th, "android.app.ActivityThread", "handleBindApplication")) {
                    return true;
                }
                if (isMatchSpecialStackTraceElement(th, "android.location.LocationManager$LocationListenerTransport$1", "onComplete")) {
                    m28476a(thread, th);
                    return true;
                }
            }
            if (m28477b(thread, th)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m28476a(Thread thread, Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("t_name", thread.getName());
        hashMap.put("error", Log.getStackTraceString(th));
        OmegaSDKAdapter.trackEvent("map_location_listener_transport_error_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private boolean m28477b(Thread thread, Throwable th) {
        return Build.VERSION.SDK_INT >= 24 && (th instanceof DeadSystemException);
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f37763a, "doCrashStrategy", th);
        closeApp();
    }
}
