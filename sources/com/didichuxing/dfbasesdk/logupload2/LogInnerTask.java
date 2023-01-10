package com.didichuxing.dfbasesdk.logupload2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.logupload.LogRecord;
import com.didichuxing.dfbasesdk.logupload.UploadObj;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class LogInnerTask extends BaseLogTask {

    /* renamed from: f */
    static final String f49297f = "LogInnerTask";

    /* renamed from: n */
    private static LogInnerTask f49298n = new LogInnerTask();

    /* renamed from: g */
    protected final List<LogData> f49299g = new LinkedList();

    /* renamed from: h */
    private final HandlerThread f49300h;

    /* renamed from: i */
    private final Handler f49301i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C16121a f49302j;

    /* renamed from: k */
    private volatile boolean f49303k;

    /* renamed from: l */
    private boolean f49304l;

    /* renamed from: m */
    private SPHelper f49305m;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f49306o = 0;

    /* renamed from: p */
    private final Runnable f49307p = new Runnable() {
        public void run() {
            if (LogInnerTask.this.f49299g.size() > 0) {
                boolean z = false;
                String str = LogInnerTask.this.f49299g.get(0).url;
                String postKey = LogInnerTask.this.getPostKey(str);
                LogUtils.m37052d(LogInnerTask.f49297f, "repeated upload check, uploadUrl===" + str);
                List a = LogInnerTask.this.m36984b(str);
                if (a != null && !a.isEmpty()) {
                    LogUtils.m37052d(LogInnerTask.f49297f, "schedule upload...");
                    UploadObj buildUploadObj = LogInnerTask.this.buildUploadObj(a, str, postKey);
                    Boolean bool = (Boolean) LogInnerTask.this.encryptMap.get(str);
                    if (bool != null && bool.booleanValue()) {
                        z = true;
                    }
                    String str2 = (String) LogInnerTask.this.versionMap.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        LogInnerTask.this.f49302j.mo122327a(str, buildUploadObj, postKey, str2);
                    } else {
                        LogInnerTask.this.f49302j.mo122328a(str, buildUploadObj, postKey, z);
                    }
                }
            } else {
                LogInnerTask.this.m36986c();
            }
        }
    };

    public static class LogData {
        public String content;
        public String extra;
        public boolean isUploading;
        public String url;
    }

    /* renamed from: b */
    static /* synthetic */ int m36983b(LogInnerTask logInnerTask) {
        int i = logInnerTask.f49306o;
        logInnerTask.f49306o = i + 1;
        return i;
    }

    private LogInnerTask() {
        HandlerThread handlerThread = new HandlerThread("inner_thread2", 10);
        this.f49300h = handlerThread;
        handlerThread.start();
        InnerHandler innerHandler = new InnerHandler(this.f49300h.getLooper());
        this.f49301i = innerHandler;
        this.f49302j = new C16121a(innerHandler);
        this.f49301i.postDelayed(this.f49307p, 5000);
    }

    /* renamed from: a */
    public static LogInnerTask m36980a() {
        return f49298n;
    }

    /* renamed from: a */
    public void mo122310a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            LogData logData = new LogData();
            logData.url = str;
            logData.content = str2;
            logData.extra = str3;
            Message obtain = Message.obtain(this.f49301i);
            obtain.what = 1;
            obtain.obj = logData;
            obtain.sendToTarget();
        }
    }

    private class InnerHandler extends Handler {
        InnerHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                LogInnerTask.this.f49299g.add((LogData) message.obj);
                LogInnerTask.this.m36986c();
            } else if (message.what == 2) {
                int unused = LogInnerTask.this.f49306o = 0;
                LogUtils.m37052d(LogInnerTask.f49297f, "upload ok, logDataList.size() = " + LogInnerTask.this.f49299g.size());
                List list = (List) message.obj;
                if (list != null) {
                    LogInnerTask.this.f49299g.removeAll(list);
                }
                LogInnerTask.this.m36986c();
            } else if (message.what == 3) {
                LogInnerTask.m36983b(LogInnerTask.this);
                List<LogData> list2 = (List) message.obj;
                if (list2 != null) {
                    for (LogData logData : list2) {
                        logData.isUploading = false;
                    }
                }
                LogInnerTask.this.m36986c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36986c() {
        if (!this.f49302j.mo122329a()) {
            if (this.f49306o >= 3) {
                if (this.f49299g.size() > 0) {
                    mo122311b();
                }
            } else if (this.f49299g.size() >= 15 && this.f49306o <= 0) {
                this.f49301i.removeCallbacks(this.f49307p);
                this.f49307p.run();
            } else if (!this.f49301i.hasCallbacks(this.f49307p)) {
                this.f49301i.postDelayed(this.f49307p, 10000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<LogRecord> m36984b(String str) {
        String str2;
        if (this.f49299g.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LogData next : this.f49299g) {
            if (!next.isUploading && (str2 = next.url) != null && str2.equals(str)) {
                arrayList.add(new LogRecord(next, next.content, 0, 0));
                next.isUploading = true;
                if (arrayList.size() >= 15) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo122311b() {
        if (this.f49299g.size() > 0) {
            for (int size = this.f49299g.size() - 1; size >= 0; size--) {
                LogData logData = this.f49299g.get(size);
                if (!logData.isUploading) {
                    SystemUtils.log(3, "martin", "dumLogToDB ...............", (Throwable) null, "com.didichuxing.dfbasesdk.logupload2.LogInnerTask", 204);
                    LogDBTask.m36957b().mo122290a(logData.url, logData.content, logData.extra);
                    this.f49299g.remove(logData);
                }
            }
            LogReporter2.saveDBStatus(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo122309a(String str) {
        if (this.f49305m == null) {
            synchronized (LogInnerTask.class) {
                if (this.f49305m == null) {
                    this.f49305m = new SPHelper(AppContextHolder.getAppContext(), "access_security_sp");
                }
            }
        }
        String str2 = "log_number_" + str;
        int intValue = ((Integer) this.f49305m.get(str2, 0)).intValue();
        this.f49305m.put(str2, Integer.valueOf(intValue + 1)).apply();
        return intValue;
    }
}
