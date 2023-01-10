package com.didi.sdk.audiorecorder.utils.log;

import android.content.Context;

public final class LogService {
    public static LogService getInstance() {
        return Singleton.INSTANCE;
    }

    private LogService() {
    }

    /* renamed from: d */
    public void mo97683d(String str, String str2) {
        XJLog.m28928a(str, str2);
    }

    /* renamed from: d */
    public void mo97682d(Context context, String str, String str2, Throwable th) {
        XJLog.m28924a(context, str, str2, th);
    }

    public static void log2sd4Record(String str) {
        XJLog.m28927a(str);
    }

    public static void log2sd4Record(Context context, String str, Throwable th) {
        XJLog.m28925a(context, str, th);
    }

    public static void log2sd4RecordService(String str) {
        XJLog.m28930b(str);
    }

    public static void log2sd4RecordService(Context context, String str, Throwable th) {
        XJLog.m28929b(context, str, th);
    }

    public void changeFileName(String str, String str2) {
        XJLog.m28933c(str, str2);
    }

    public void delete() {
        XJLog.m28922a();
    }

    private static final class Singleton {
        static final LogService INSTANCE = new LogService();

        private Singleton() {
        }
    }
}
