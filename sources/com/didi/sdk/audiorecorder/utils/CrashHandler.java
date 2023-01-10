package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import android.os.Process;
import java.lang.Thread;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler -> ";

    /* renamed from: a */
    private static CrashHandler f38332a = new CrashHandler();

    /* renamed from: b */
    private Context f38333b;

    /* renamed from: c */
    private Thread.UncaughtExceptionHandler f38334c;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return f38332a;
    }

    public void init(Context context) {
        this.f38333b = context.getApplicationContext();
        this.f38334c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        LogUtil.log(TAG, "uncaughtException occur. " + th);
        Process.killProcess(Process.myPid());
    }
}
