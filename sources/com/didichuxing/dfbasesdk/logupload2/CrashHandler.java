package com.didichuxing.dfbasesdk.logupload2;

import android.content.Context;
import java.lang.Thread;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static CrashHandler f49275a = new CrashHandler();

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f49276b;

    /* renamed from: c */
    private Context f49277c;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return f49275a;
    }

    public void init(Context context) {
        this.f49276b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f49277c = context.getApplicationContext();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            LogInnerTask.m36980a().mo122311b();
        } catch (Throwable unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f49276b;
        if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
