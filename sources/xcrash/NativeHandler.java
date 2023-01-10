package xcrash;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p116v2.NachoConstants;
import java.io.File;
import java.util.Map;

public class NativeHandler {

    /* renamed from: a */
    private long f8871a;

    /* renamed from: b */
    private Context f8872b;

    /* renamed from: c */
    private boolean f8873c;

    /* renamed from: d */
    private ICrashCallback f8874d;

    /* renamed from: e */
    private boolean f8875e;

    /* renamed from: f */
    private boolean f8876f;

    /* renamed from: g */
    private ICrashCallback f8877g;

    /* renamed from: h */
    private boolean f8878h;

    private static native int nativeInit(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, String[] strArr, boolean z8, boolean z9, int i6, int i7, int i8, boolean z10, boolean z11);

    private static native void nativeNotifyJavaCrashed();

    private static native void nativeTestCrash(int i);

    private NativeHandler() {
        this.f8871a = 15000;
        this.f8878h = false;
    }

    private static class NativeHandlerHolder {
        /* access modifiers changed from: private */
        public static NativeHandler INSTANCE = new NativeHandler();

        private NativeHandlerHolder() {
        }
    }

    public static NativeHandler getInstance() {
        return NativeHandlerHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo43617a(Context context, ILibLoader iLibLoader, String str, String str2, String str3, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, String[] strArr, ICrashCallback iCrashCallback, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, boolean z11, boolean z12, ICrashCallback iCrashCallback2) {
        ILibLoader iLibLoader2 = iLibLoader;
        if (iLibLoader2 == null) {
            try {
                System.loadLibrary("xcrash");
            } catch (Throwable th) {
                XCrash.getLogger().mo43608e("massdk xcrash", "NativeHandler System.loadLibrary failed", th);
                return -2;
            }
        } else {
            try {
                iLibLoader2.loadLibrary("xcrash");
            } catch (Throwable th2) {
                XCrash.getLogger().mo43608e("massdk xcrash", "NativeHandler ILibLoader.loadLibrary failed", th2);
                return -2;
            }
        }
        this.f8872b = context;
        this.f8873c = z2;
        this.f8874d = iCrashCallback;
        this.f8875e = z8;
        this.f8876f = z10;
        this.f8877g = iCrashCallback2;
        this.f8871a = z9 ? 15000 : 30000;
        try {
            if (nativeInit(Build.VERSION.SDK_INT, Build.VERSION.RELEASE, C3712Util.m7590b(), Build.MANUFACTURER, Build.BRAND, C3712Util.getMobileModel(), Build.FINGERPRINT, str, str2, context.getApplicationInfo().nativeLibraryDir, str3, z, z2, i, i2, i3, z3, z4, z5, z6, z7, i4, strArr, z8, z9, i5, i6, i7, z11, z12) != 0) {
                XCrash.getLogger().mo43607e("massdk xcrash", "NativeHandler init failed");
                return -3;
            }
            this.f8878h = true;
            return 0;
        } catch (Throwable th3) {
            XCrash.getLogger().mo43608e("massdk xcrash", "NativeHandler init failed", th3);
            return -3;
        }
    }

    public void notifyJavaCrashed() {
        if (this.f8878h && this.f8875e) {
            nativeNotifyJavaCrashed();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43618a(boolean z) {
        if (this.f8878h) {
            nativeTestCrash(z ? 1 : 0);
        }
    }

    /* renamed from: a */
    private static String m7569a(boolean z, String str) {
        try {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread = (Thread) next.getKey();
                if ((z && thread.getName().equals(NachoConstants.NACHO_ENTRYPOINT_NAME)) || (!z && thread.getName().contains(str))) {
                    StringBuilder sb = new StringBuilder();
                    for (StackTraceElement stackTraceElement : (StackTraceElement[]) next.getValue()) {
                        sb.append("    at ");
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception e) {
            XCrash.getLogger().mo43608e("massdk xcrash", "NativeHandler getStacktraceByThreadName failed", e);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0101, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void crashCallback(java.lang.String r7, java.lang.String r8, boolean r9, boolean r10, java.lang.String r11) {
        /*
            java.lang.Class<xcrash.NativeHandler> r0 = xcrash.NativeHandler.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0102 }
            if (r1 == 0) goto L_0x0016
            xcrash.ILogger r7 = xcrash.XCrash.getLogger()     // Catch:{ all -> 0x0102 }
            java.lang.String r8 = "massdk xcrash"
            java.lang.String r9 = "NativeHandler crashCallback logPath is null"
            r7.mo43607e(r8, r9)     // Catch:{ all -> 0x0102 }
            monitor-exit(r0)
            return
        L_0x0016:
            boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0102 }
            if (r1 == 0) goto L_0x0024
            java.lang.Thread r11 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0102 }
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0102 }
        L_0x0024:
            xcrash.ILogger r1 = xcrash.XCrash.getLogger()     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = "massdk xcrash"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r3.<init>()     // Catch:{ all -> 0x0102 }
            java.lang.String r4 = "NativeHandler crashCallback logPath:"
            r3.append(r4)     // Catch:{ all -> 0x0102 }
            r3.append(r7)     // Catch:{ all -> 0x0102 }
            java.lang.String r4 = " dumpJavaStacktrace:"
            r3.append(r4)     // Catch:{ all -> 0x0102 }
            r3.append(r9)     // Catch:{ all -> 0x0102 }
            java.lang.String r4 = " isMainThread:"
            r3.append(r4)     // Catch:{ all -> 0x0102 }
            r3.append(r10)     // Catch:{ all -> 0x0102 }
            java.lang.String r4 = " threadName:"
            r3.append(r4)     // Catch:{ all -> 0x0102 }
            r3.append(r11)     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0102 }
            r1.mo43613w(r2, r3)     // Catch:{ all -> 0x0102 }
            java.lang.String r1 = "java stacktrace:"
            int r1 = xcrash.TombstoneManager.findLocationBySpecial(r7, r1)     // Catch:{ all -> 0x0102 }
            long r1 = (long) r1     // Catch:{ all -> 0x0102 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ all -> 0x0102 }
            r4 = 1024(0x400, float:1.435E-42)
            r3.<init>(r4)     // Catch:{ all -> 0x0102 }
            r4 = -1
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x00a1
            java.lang.String r1 = "\njava stacktrace:\n"
            r3.append(r1)     // Catch:{ all -> 0x0102 }
            if (r9 == 0) goto L_0x0081
            java.lang.String r9 = m7569a(r10, r11)     // Catch:{ all -> 0x0102 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0102 }
            if (r10 == 0) goto L_0x007d
            java.lang.String r9 = "empty"
        L_0x007d:
            r3.append(r9)     // Catch:{ all -> 0x0102 }
            goto L_0x0086
        L_0x0081:
            java.lang.String r9 = "none"
            r3.append(r9)     // Catch:{ all -> 0x0102 }
        L_0x0086:
            java.lang.String r9 = "\n\nmemory info:\n"
            r3.append(r9)     // Catch:{ all -> 0x0102 }
            java.lang.String r9 = xcrash.C3712Util.getProcessMemoryInfo()     // Catch:{ all -> 0x0102 }
            r3.append(r9)     // Catch:{ all -> 0x0102 }
            java.lang.String r9 = "memory info:"
            int r9 = xcrash.TombstoneManager.findLocationBySpecial(r7, r9)     // Catch:{ all -> 0x0102 }
            long r9 = (long) r9     // Catch:{ all -> 0x0102 }
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x0102 }
            xcrash.TombstoneManager.insertToSpecial(r7, r9, r11)     // Catch:{ all -> 0x0102 }
            goto L_0x00c5
        L_0x00a1:
            java.lang.String r9 = "memory info:"
            java.lang.String r10 = "java stacktrace:"
            xcrash.TombstoneManager.operateSrcFile(r7, r9, r10)     // Catch:{ all -> 0x0102 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r9.<init>()     // Catch:{ all -> 0x0102 }
            r9.append(r7)     // Catch:{ all -> 0x0102 }
            java.lang.String r10 = ".bottom"
            r9.append(r10)     // Catch:{ all -> 0x0102 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0102 }
            java.lang.String r10 = "memory info"
            java.lang.String r11 = xcrash.C3712Util.getProcessMemoryInfo()     // Catch:{ all -> 0x0102 }
            xcrash.TombstoneManager.appendSection(r9, r10, r11)     // Catch:{ all -> 0x0102 }
            xcrash.TombstoneManager.compositeAll(r7)     // Catch:{ all -> 0x0102 }
        L_0x00c5:
            java.lang.String r9 = "foreground"
            xcrash.a r10 = xcrash.C3715a.m7594a()     // Catch:{ all -> 0x0102 }
            boolean r10 = r10.mo43677c()     // Catch:{ all -> 0x0102 }
            if (r10 == 0) goto L_0x00d4
            java.lang.String r10 = "yes"
            goto L_0x00d6
        L_0x00d4:
            java.lang.String r10 = "no"
        L_0x00d6:
            xcrash.TombstoneManager.appendSection(r7, r9, r10)     // Catch:{ all -> 0x0102 }
            xcrash.NativeHandler r9 = getInstance()     // Catch:{ all -> 0x0102 }
            xcrash.ICrashCallback r9 = r9.f8874d     // Catch:{ all -> 0x0102 }
            if (r9 == 0) goto L_0x00f1
            r9.onCrash(r7, r8)     // Catch:{ Exception -> 0x00e5 }
            goto L_0x00f1
        L_0x00e5:
            r7 = move-exception
            xcrash.ILogger r8 = xcrash.XCrash.getLogger()     // Catch:{ all -> 0x0102 }
            java.lang.String r9 = "massdk xcrash"
            java.lang.String r10 = "NativeHandler native crash callback.onCrash failed"
            r8.mo43614w(r9, r10, r7)     // Catch:{ all -> 0x0102 }
        L_0x00f1:
            xcrash.NativeHandler r7 = getInstance()     // Catch:{ all -> 0x0102 }
            boolean r7 = r7.f8873c     // Catch:{ all -> 0x0102 }
            if (r7 != 0) goto L_0x0100
            xcrash.a r7 = xcrash.C3715a.m7594a()     // Catch:{ all -> 0x0102 }
            r7.mo43676b()     // Catch:{ all -> 0x0102 }
        L_0x0100:
            monitor-exit(r0)
            return
        L_0x0102:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.NativeHandler.crashCallback(java.lang.String, java.lang.String, boolean, boolean, java.lang.String):void");
    }

    private static synchronized void traceCallback(String str, String str2) {
        synchronized (NativeHandler.class) {
            if (TextUtils.isEmpty(str)) {
                XCrash.getLogger().mo43607e("massdk xcrash", "NativeHandler traceCallback logPath is null");
                return;
            }
            XCrash.getLogger().mo43613w("massdk xcrash", "NativeHandler traceCallback logPath:" + str + " emergency:" + str2 + " threadName:" + Thread.currentThread().getName());
            TombstoneManager.appendSection(str, TombstoneParser.keyMemoryInfo, C3712Util.getProcessMemoryInfo());
            TombstoneManager.appendSection(str, TombstoneParser.keyForeground, C3715a.m7594a().mo43677c() ? "yes" : "no");
            if (getInstance().f8876f && !C3712Util.m7588a(getInstance().f8872b, getInstance().f8871a)) {
                C3717c.m7609a().mo43680a(new File(str));
                return;
            } else if (C3717c.m7609a().mo43683c()) {
                String str3 = str.substring(0, str.length() - 13) + ".anr.xcrash";
                File file = new File(str);
                boolean renameTo = file.renameTo(new File(str3));
                if (renameTo) {
                    file.delete();
                }
                if (renameTo) {
                    str = str3;
                }
                ICrashCallback iCrashCallback = getInstance().f8877g;
                if (iCrashCallback != null) {
                    try {
                        iCrashCallback.onCrash(str, str2);
                    } catch (Exception e) {
                        XCrash.getLogger().mo43614w("massdk xcrash", "NativeHandler ANR callback.onCrash failed", e);
                    }
                }
            } else {
                return;
            }
        }
        return;
    }
}
