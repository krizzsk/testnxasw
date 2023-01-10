package com.didi.map.sdk.degrade;

import android.text.TextUtils;
import android.util.Log;
import com.didi.map.sdk.navtracker.log.DLog;
import java.lang.Thread;

public class DegradeUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f30547a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b */
    private ICrashListener f30548b;

    public DegradeUncaughtExceptionHandler(ICrashListener iCrashListener) {
        this.f30548b = iCrashListener;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m23567a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f30547a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    private void m23567a(Throwable th) {
        if (th == null) {
            DLog.m23804d("ccc", "throwable is null", new Object[0]);
            return;
        }
        String stackTraceString = Log.getStackTraceString(th);
        if (TextUtils.isEmpty(stackTraceString)) {
            DLog.m23804d("ccc", "crash msg is empty", new Object[0]);
            return;
        }
        ICrashListener iCrashListener = this.f30548b;
        if (iCrashListener != null) {
            iCrashListener.onCrashed(stackTraceString);
        }
    }
}
