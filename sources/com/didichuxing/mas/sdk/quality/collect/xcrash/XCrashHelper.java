package com.didichuxing.mas.sdk.quality.collect.xcrash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.collect.crash.CrashCallbacks;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.mem.FdUtil;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.mem.MemUtil;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.ThreadCollector;
import com.didichuxing.mas.sdk.quality.report.record.ANRRecord;
import com.didichuxing.mas.sdk.quality.report.record.NativeCrashRecord;
import com.didichuxing.mas.sdk.quality.report.record.RecordFactory;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.DataTrackUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.getkeepsafe.relinker.ReLinker;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import xcrash.C3712Util;
import xcrash.ICrashCallback;
import xcrash.ILibLoader;
import xcrash.ILogger;
import xcrash.TombstoneManager;
import xcrash.TombstoneParser;
import xcrash.XCrash;

public class XCrashHelper {

    /* renamed from: a */
    private static final ArrayList<CrashCallbacks> f50813a = new ArrayList<>();

    /* renamed from: b */
    private static final AtomicBoolean f50814b = new AtomicBoolean(false);

    public static void init(final Context context, final boolean z, final boolean z2) {
        if (f50814b.compareAndSet(false, true)) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                m37834b(context, z, z2);
            } else {
                new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        XCrashHelper.m37834b(context, z, z2);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m37834b(final Context context, boolean z, boolean z2) {
        OLog.m37863i("XCrashHelper init crashEnabled:" + z + " anrEnabled:" + z2);
        if (z || z2) {
            try {
                XCrash.InitParameters initParameters = new XCrash.InitParameters();
                XCrash.InitParameters disableJavaCrashHandler = initParameters.setLogDir(context.getExternalFilesDir((String) null) + "/tombstones").setAppVersion(PackageCollector.getVN()).setAnrLogcatEventsLines(0).setAnrLogcatMainLines(0).setAnrLogcatSystemLines(0).setNativeLogcatEventsLines(0).setNativeLogcatMainLines(0).setNativeLogcatSystemLines(0).setPlaceholderSizeKb(0).setAnrDumpFds(true).setAnrDumpNetwork(false).setAnrLogCountMax(20).setNativeLogCountMax(20).setNativeDumpAllThreads(true).setNativeDumpAllThreadsCountMax(0).setNativeDumpElfHash(false).setNativeDumpMap(MASConfig.SWITCH_NATIVE_DUMP_MAP).setNativeDumpFds(MASConfig.OPEN_DUMP_MEMORY_FD_THREAD_PROCESS_INFO).setNativeDumpNetwork(false).disableJavaCrashHandler();
                disableJavaCrashHandler.setLogger(new ILogger() {
                    /* renamed from: v */
                    public void mo43611v(String str, String str2) {
                        OLog.m37863i(str + ":" + str2);
                    }

                    /* renamed from: v */
                    public void mo43612v(String str, String str2, Throwable th) {
                        OLog.m37864i(str + ":" + str2, th);
                    }

                    /* renamed from: d */
                    public void mo43605d(String str, String str2) {
                        OLog.m37863i(str + ":" + str2);
                    }

                    /* renamed from: d */
                    public void mo43606d(String str, String str2, Throwable th) {
                        OLog.m37864i(str + ":" + str2, th);
                    }

                    /* renamed from: i */
                    public void mo43609i(String str, String str2) {
                        OLog.m37863i(str + ":" + str2);
                    }

                    /* renamed from: i */
                    public void mo43610i(String str, String str2, Throwable th) {
                        OLog.m37864i(str + ":" + str2, th);
                    }

                    /* renamed from: w */
                    public void mo43613w(String str, String str2) {
                        OLog.m37867w(str + ":" + str2);
                    }

                    /* renamed from: w */
                    public void mo43614w(String str, String str2, Throwable th) {
                        OLog.m37868w(str + ":" + str2, th);
                    }

                    /* renamed from: e */
                    public void mo43607e(String str, String str2) {
                        OLog.m37861e(str + ":" + str2);
                    }

                    /* renamed from: e */
                    public void mo43608e(String str, String str2, Throwable th) {
                        OLog.m37862e(str + ":" + str2, th);
                    }
                });
                disableJavaCrashHandler.setLibLoader(new ILibLoader() {
                    public void loadLibrary(String str) {
                        ReLinker.loadLibrary(context, str);
                    }
                });
                if (z) {
                    disableJavaCrashHandler.enableNativeCrashHandler();
                } else {
                    disableJavaCrashHandler.disableNativeCrashHandler();
                }
                if (z2) {
                    disableJavaCrashHandler.enableAnrCrashHandler();
                } else {
                    disableJavaCrashHandler.disableAnrCrashHandler();
                }
                disableJavaCrashHandler.setAnrCallback(new ICrashCallback() {
                    public void onCrash(String str, String str2) throws Exception {
                        XCrashHelper.m37838c(str, str2, true);
                    }
                }).setNativeCallback(new ICrashCallback() {
                    public void onCrash(String str, String str2) throws Exception {
                        XCrashHelper.m37840d(str, str2, true);
                    }
                });
                disableJavaCrashHandler.setAnrRethrow(true);
                XCrash.init(context, disableJavaCrashHandler);
                MASConfig.PRE_INIT_ANR = true;
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            for (File file : TombstoneManager.getAllTombstones()) {
                                if (!TombstoneManager.isAnr(file)) {
                                    if (!TombstoneManager.isTrace(file)) {
                                        if (TombstoneManager.isNativeCrash(file)) {
                                            XCrashHelper.m37839d(file, "", false);
                                        }
                                    }
                                }
                                XCrashHelper.m37837c(file, "", false);
                            }
                        } catch (Exception e) {
                            OLog.m37862e("Upload remain files failed", e);
                        }
                    }
                }).start();
            } catch (Exception e) {
                OLog.m37862e("XCrash init error", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m37838c(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                OLog.m37867w(str + "对应的ANR文件不存在");
                return;
            }
            m37837c(file, str2, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m37837c(File file, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("handle ");
        sb.append(z ? "realtime" : "unfinished");
        sb.append(" ANR, path:");
        sb.append(file);
        sb.append(" emergency:");
        sb.append(str);
        OLog.m37867w(sb.toString());
        try {
            ANRRecord createANRRecord = RecordFactory.createANRRecord(file.getAbsolutePath());
            boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_anr", MASConfig.UPPER_LIMIT_ANR_EVENT_PER_DAY);
            createANRRecord.takeLogCatWithAnrReason();
            DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.ANR, createANRRecord.getRecordId(), isUpperLimitByDay);
            if (!isUpperLimitByDay) {
                RecordStorage.save(createANRRecord);
                CommonUtil.addUpperLimitByDay("upper_limit_anr");
            }
        } catch (Exception e) {
            OLog.m37862e("handleAnr error", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m37840d(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                OLog.m37867w(str + "对应的Native Crash文件不存在");
                return;
            }
            m37839d(file, str2, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m37839d(File file, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("handle ");
        sb.append(z ? "realtime" : "unfinished");
        sb.append(" Native crash, path:");
        sb.append(file);
        sb.append(" emergency:");
        sb.append(str);
        OLog.m37867w(sb.toString());
        try {
            Map<String, String> parse = TombstoneParser.parse(file);
            String str2 = parse.get("signal");
            String str3 = parse.get("code");
            String str4 = parse.get(TombstoneParser.keyFaultAddr);
            String str5 = parse.get(TombstoneParser.keyBacktrace);
            boolean contains = !TextUtils.isEmpty(str5) ? str5.contains("/system/lib/libunwind.so") : false;
            OLog.m37867w("Crash reason: signal " + str2 + ", code " + str3 + " fault addr: " + str4 + "should ignore:" + contains);
            if (contains) {
                file.delete();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "native");
            hashMap.put("signal", str2);
            hashMap.put("code", str3);
            hashMap.put(TombstoneParser.keyBacktrace, str5);
            hashMap.put("faultAddr", str4);
            hashMap.put("path", file.getAbsolutePath());
            Object[] objArr = null;
            synchronized (f50813a) {
                if (f50813a.size() > 0) {
                    objArr = f50813a.toArray();
                }
            }
            if (objArr != null) {
                for (Object obj : objArr) {
                    ((CrashCallbacks) obj).onCrash(hashMap);
                }
            }
            NativeCrashRecord createUnwindRecord = RecordFactory.createUnwindRecord(file);
            if (MASConfig.OPEN_DUMP_MEMORY_FD_THREAD_PROCESS_INFO) {
                createUnwindRecord.setAppMemoryInfo(MemUtil.getSimpleRuntimeMemInfo() + parse.get(TombstoneParser.keyProcessSummaryFromProcSmaps) + "\n-\n" + parse.get(TombstoneParser.keyFromProcStatus) + "\n-\n" + parse.get(TombstoneParser.keyFromProcLimits) + "\n-\n" + parse.get(TombstoneParser.keyProcessDetailsFromProcSmaps) + "\n-\n" + parse.get(TombstoneParser.keyProcessDalvikDetailsFromProcSmaps));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C3712Util.getCensusDalvikVmMemoryInfo());
                sb2.append(parse.get(TombstoneParser.keyFromProcMemInfo));
                createUnwindRecord.setSystemMemoryInfo(sb2.toString());
                createUnwindRecord.setProcessStatusInfo(parse.get(TombstoneParser.keyFromProcStatus));
                createUnwindRecord.setFdStatusInfo(FdUtil.censusFdInfo(parse.get(TombstoneParser.keyOpenFiles)));
                createUnwindRecord.setThreadStatusInfo(ThreadCollector.getCensusAllThreadInfo());
            }
            boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_native_crash", MASConfig.UPPER_LIMIT_NATIVE_CRASH_EVENT_PER_DAY);
            DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.NATIVE_CRASH, createUnwindRecord.getRecordId(), isUpperLimitByDay);
            if (!isUpperLimitByDay) {
                RecordStorage.save(createUnwindRecord);
                CommonUtil.addUpperLimitByDay("upper_limit_native_crash");
            }
        } catch (Exception e) {
            OLog.m37862e("handleNativeCrash error", e);
        }
    }

    public static void testJavaCrash(boolean z) throws RuntimeException {
        XCrash.testJavaCrash(z);
    }

    public static void testNativeCrash(boolean z) {
        XCrash.testNativeCrash(z);
    }

    public static void registerCrashCallbacks(CrashCallbacks crashCallbacks) {
        synchronized (f50813a) {
            f50813a.add(crashCallbacks);
        }
    }

    public static void unregisterCrashCallbacks(CrashCallbacks crashCallbacks) {
        synchronized (f50813a) {
            f50813a.remove(crashCallbacks);
        }
    }
}
