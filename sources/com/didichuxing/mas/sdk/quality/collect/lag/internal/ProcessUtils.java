package com.didichuxing.mas.sdk.quality.collect.lag.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.didichuxing.mas.sdk.quality.collect.lag.BlockCanaryInternals;
import java.util.List;

public class ProcessUtils {

    /* renamed from: a */
    private static volatile String f50714a;

    /* renamed from: b */
    private static final Object f50715b = new Object();

    private ProcessUtils() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static String myProcessName() {
        if (f50714a != null) {
            return f50714a;
        }
        synchronized (f50715b) {
            if (f50714a != null) {
                String str = f50714a;
                return str;
            }
            f50714a = m37776a(BlockCanaryInternals.getContext().provideContext());
            String str2 = f50714a;
            return str2;
        }
    }

    /* renamed from: a */
    private static String m37776a(Context context) {
        int myPid = Process.myPid();
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next != null && next.pid == myPid) {
                        return next.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
