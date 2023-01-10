package com.didi.sdk.apm;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.didi.sdk.apm.crash.AppCrashInterceptor;
import com.didi.sdk.apm.ext.VoidPrintStream;
import com.didi.sdk.apm.utils.ApmUncaughtExceptionHandler;
import com.didi.sdk.apm.utils.DebugUtils;
import com.didi.sdk.apm.utils.TimingLogger;
import global.didi.pay.newview.pix.IPixView;

public class ApmServiceManager {
    public static final String TAG = "ApmServiceManager";

    /* renamed from: a */
    private static final ApmServiceManager f37686a = new ApmServiceManager();

    /* renamed from: b */
    private BroadcastReceiverMonitor f37687b;

    /* renamed from: c */
    private boolean f37688c;

    public static ApmServiceManager getInstance() {
        return f37686a;
    }

    private ApmServiceManager() {
    }

    public synchronized ApmServiceManager init(Context context) {
        if (this.f37688c) {
            return this;
        }
        this.f37688c = true;
        try {
            m28415a(context);
        } catch (Throwable th) {
            Log.e(TAG, "init error: ", th);
        }
        return this;
    }

    /* renamed from: a */
    private void m28415a(Context context) {
        TimingLogger timingLogger = new TimingLogger(TAG, IPixView.PAGE_STATUS_INIT);
        timingLogger.setDisabled(!DebugUtils.isDebuggableApp(context));
        ApmUncaughtExceptionHandler.init();
        timingLogger.addSplit("ApmUncaughtExceptionHandler init");
        SystemUtils.m28437a(context);
        timingLogger.addSplit("SystemUtils init");
        AppCrashInterceptor.init();
        timingLogger.addSplit("AppCrashInterceptor init");
        C12712d.m28479a(context);
        timingLogger.addSplit("PreLoaders start");
        SystemServiceHelper.m28434a(context);
        timingLogger.addSplit("SystemServiceHelper init");
        timingLogger.addSplit("LogcatFilter init");
        m28419e(context);
        timingLogger.addSplit("redirectLogStreams");
        timingLogger.dumpToLog();
    }

    /* renamed from: b */
    private void m28416b(Context context) {
        TimingLogger timingLogger = new TimingLogger(TAG, IPixView.PAGE_STATUS_INIT);
        timingLogger.setDisabled(!DebugUtils.isDebuggableApp(context));
        timingLogger.addSplit("redirectLogStreams");
        m28419e(context);
        timingLogger.addSplit("AppStateMonitor init");
        AppStateMonitor.getInstance().init(context);
        timingLogger.addSplit("PreLoaders start");
        C12712d.m28479a(context);
        timingLogger.addSplit("SystemServiceHelper init");
        SystemServiceHelper.m28434a(context);
        timingLogger.addSplit("SystemUtils init");
        SystemUtils.m28437a(context);
        timingLogger.addSplit("startStrictMode");
        m28418d(context);
        timingLogger.addSplit("AntiHookHelper init");
        AntiHookHelper.init(context);
        timingLogger.addSplit("LogcatFilter init");
        if (Build.VERSION.SDK_INT <= 27) {
            timingLogger.addSplit("BroadcastReceiverMonitor <init>");
            this.f37687b = new BroadcastReceiverMonitor(context);
        }
        timingLogger.addSplit("Runtime addShutdownHook");
        m28417c(context);
        timingLogger.addSplit("AppAutoCloser init");
        C12701a.m28443a().mo96709a(context);
        timingLogger.dumpToLog();
    }

    public void start() {
        if (this.f37688c) {
            try {
                Log.i(TAG, "start");
                m28414a();
            } catch (Throwable th) {
                Log.e(TAG, "start error: ", th);
            }
        }
    }

    /* renamed from: a */
    private void m28414a() {
        BroadcastReceiverMonitor broadcastReceiverMonitor = this.f37687b;
        if (broadcastReceiverMonitor != null) {
            broadcastReceiverMonitor.mo96679a();
        }
        C12701a.m28443a().mo96710b();
    }

    /* renamed from: c */
    private void m28417c(Context context) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                Log.e(ApmServiceManager.TAG, "Runtime exit called");
                super.run();
            }
        });
    }

    /* renamed from: d */
    private void m28418d(Context context) {
        if (DebugUtils.isDebuggableApp(context)) {
            Log.i(TAG, "startStrictMode");
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectActivityLeaks().detectLeakedClosableObjects().detectLeakedSqlLiteObjects().penaltyLog().build());
        }
    }

    /* renamed from: e */
    private void m28419e(Context context) {
        if (!DebugUtils.isDebuggableApp(context)) {
            Log.i(TAG, "redirectLogStreams");
            try {
                VoidPrintStream voidPrintStream = new VoidPrintStream();
                System.out.close();
                System.setOut(voidPrintStream);
                System.err.close();
                System.setErr(voidPrintStream);
            } catch (Exception unused) {
            }
        }
    }
}
