package com.didi.global.ninja.crash;

import android.content.Context;
import com.didi.global.ninja.strategy.StrategyManager;
import java.lang.Thread;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f24784a;

    /* renamed from: b */
    private Context f24785b;

    public void init(Context context) {
        this.f24785b = context.getApplicationContext();
        this.f24784a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m19873a(thread, th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f24784a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    private void m19873a(Thread thread, Throwable th) {
        StrategyManager.getInstance(this.f24785b).filterException(th.getStackTrace());
    }
}
