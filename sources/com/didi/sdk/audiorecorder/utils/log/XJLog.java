package com.didi.sdk.audiorecorder.utils.log;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.utils.AppUtil;
import com.didi.sdk.audiorecorder.utils.log.LogWriter;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;

final class XJLog {

    /* renamed from: a */
    static final String f38365a = "";

    public enum LogType {
        RECORD,
        RECORD_SERVICE
    }

    /* renamed from: c */
    private static String m28932c(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public static void m28928a(String str, String str2) {
        SystemUtils.log(3, str, m28932c(str2), (Throwable) null, "com.didi.sdk.audiorecorder.utils.log.XJLog", 25);
    }

    /* renamed from: a */
    public static void m28924a(Context context, String str, String str2, Throwable th) {
        SystemUtils.log(3, str, m28932c(str2) + AppUtil.createCrashMessage(context, th), (Throwable) null, "com.didi.sdk.audiorecorder.utils.log.XJLog", 29);
    }

    /* renamed from: a */
    public static void m28927a(String str) {
        m28926a(LogType.RECORD, str);
    }

    /* renamed from: a */
    public static void m28925a(Context context, String str, Throwable th) {
        m28926a(LogType.RECORD, str);
        m28923a(context, LogType.RECORD, th);
    }

    /* renamed from: b */
    public static void m28930b(String str) {
        m28926a(LogType.RECORD_SERVICE, str);
    }

    /* renamed from: b */
    public static void m28929b(Context context, String str, Throwable th) {
        m28926a(LogType.RECORD_SERVICE, str);
        m28923a(context, LogType.RECORD_SERVICE, th);
    }

    /* renamed from: b */
    public static void m28931b(String str, String str2) {
        new LogWriter.Action(2).put("fileName", str).put("log", str2).send();
    }

    /* renamed from: a */
    public static void m28922a() {
        new LogWriter.Action(1).send();
    }

    /* renamed from: c */
    public static void m28933c(String str, String str2) {
        new LogWriter.Action(4).put("originalFileName", str).put("newFileName", str2).send();
    }

    /* renamed from: com.didi.sdk.audiorecorder.utils.log.XJLog$1 */
    static /* synthetic */ class C129491 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$audiorecorder$utils$log$XJLog$LogType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.sdk.audiorecorder.utils.log.XJLog$LogType[] r0 = com.didi.sdk.audiorecorder.utils.log.XJLog.LogType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$audiorecorder$utils$log$XJLog$LogType = r0
                com.didi.sdk.audiorecorder.utils.log.XJLog$LogType r1 = com.didi.sdk.audiorecorder.utils.log.XJLog.LogType.RECORD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$audiorecorder$utils$log$XJLog$LogType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.audiorecorder.utils.log.XJLog$LogType r1 = com.didi.sdk.audiorecorder.utils.log.XJLog.LogType.RECORD_SERVICE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.utils.log.XJLog.C129491.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static void m28926a(LogType logType, String str) {
        int i = C129491.$SwitchMap$com$didi$sdk$audiorecorder$utils$log$XJLog$LogType[logType.ordinal()];
        if (i == 1) {
            m28931b(SDKConsts.TAG_KEY_RECORD, str);
        } else if (i != 2) {
            m28931b("", str);
        } else {
            m28931b("record_service", str);
        }
    }

    /* renamed from: a */
    private static void m28923a(Context context, LogType logType, Throwable th) {
        if (th != null) {
            m28926a(logType, AppUtil.createCrashMessage(context, th));
        }
    }

    private XJLog() {
    }
}
