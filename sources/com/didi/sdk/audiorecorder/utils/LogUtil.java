package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didi.sdk.audiorecorder.utils.log.LogService;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class LogUtil {

    /* renamed from: a */
    private static final String f38342a = "LogUtil -> ";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f38343b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static boolean f38344c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Context f38345d;

    /* renamed from: e */
    private static String f38346e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static File f38347f;

    /* renamed from: g */
    private static final Executor f38348g = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("didi-recorder-logger");
            thread.setPriority(1);
            return thread;
        }
    });

    public static void init(Context context, boolean z) {
        f38345d = context.getApplicationContext();
        f38344c = z;
        f38348g.execute(new Runnable() {
            public void run() {
                boolean unused = LogUtil.f38343b = AudioRecordManager.isRecordProcess(LogUtil.f38345d);
                File unused2 = LogUtil.f38347f = C12947a.m28909a(LogUtil.f38345d);
                LogUtil.log("LogUtil -> init : sRecordProcessFlag = " + LogUtil.f38343b, ", isDebuggable = " + LogUtil.f38344c + ", sLogDir = " + LogUtil.f38347f);
            }
        });
    }

    public static File getLogDir() {
        try {
            if (!f38347f.exists()) {
                f38347f.mkdirs();
            }
            return f38347f;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void updateUserPhone(String str) {
        f38346e = str;
    }

    public static String getUserPhone() {
        return f38346e;
    }

    public static boolean isDebuggable() {
        return f38344c;
    }

    public static void log(final String... strArr) {
        f38348g.execute(new Runnable() {
            public void run() {
                StringBuilder sb = new StringBuilder();
                for (String append : strArr) {
                    sb.append(append);
                }
                String sb2 = sb.toString();
                if (LogUtil.f38343b) {
                    LogService.log2sd4RecordService(sb2);
                } else {
                    LogService.log2sd4Record(sb2);
                }
                if (LogUtil.f38344c) {
                    LogService.getInstance().mo97683d(LogUtil.f38342a, sb2);
                }
            }
        });
    }

    public static void log(final String str) {
        f38348g.execute(new Runnable() {
            public void run() {
                if (LogUtil.f38343b) {
                    LogService.log2sd4RecordService(str);
                } else {
                    LogService.log2sd4Record(str);
                }
                if (LogUtil.f38344c) {
                    LogService.getInstance().mo97683d(LogUtil.f38342a, str);
                }
            }
        });
    }

    public static void log(final String str, final Throwable th) {
        m28908e();
        f38348g.execute(new Runnable() {
            public void run() {
                if (LogUtil.f38343b) {
                    LogService.log2sd4RecordService(LogUtil.f38345d, str, th);
                } else {
                    LogService.log2sd4Record(LogUtil.f38345d, str, th);
                }
                if (LogUtil.f38344c) {
                    LogService.getInstance().mo97682d(LogUtil.f38345d, LogUtil.f38342a, str, th);
                }
            }
        });
    }

    public static void logD(String str, String str2) {
        if (str != null && str2 != null && f38344c) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.sdk.audiorecorder.utils.LogUtil", 132);
        }
    }

    /* renamed from: e */
    private static void m28908e() {
        if (f38345d == null) {
            throw new IllegalStateException("Please invoke init method first.");
        }
    }
}
