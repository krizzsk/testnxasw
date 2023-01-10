package com.didichuxing.dfbasesdk.logupload2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.logupload.LogRecord;
import com.didichuxing.dfbasesdk.logupload.UploadObj;
import com.didichuxing.dfbasesdk.logupload2.LogDbHelper2;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.List;

class LogDBTask extends BaseLogTask {

    /* renamed from: f */
    static final String f49278f = "LogUpload2";

    /* renamed from: m */
    private static LogDBTask f49279m = new LogDBTask();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final LogDbHelper2 f49280g = new LogDbHelper2(AppContextHolder.getAppContext());

    /* renamed from: h */
    private final HandlerThread f49281h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Handler f49282i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C16121a f49283j;

    /* renamed from: k */
    private volatile boolean f49284k;

    /* renamed from: l */
    private boolean f49285l;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f49286n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Runnable f49287o = new Runnable() {
        public void run() {
            LogUtils.m37052d(LogDBTask.f49278f, "uploadRunnable execute, failTimes=" + LogDBTask.this.f49286n);
            if (LogDBTask.this.f49286n < 3) {
                String b = LogDBTask.this.f49280g.mo122298b();
                if (TextUtils.isEmpty(b)) {
                    b = LogDBTask.this.activeUrl;
                }
                String postKey = LogDBTask.this.getPostKey(b);
                LogUtils.m37052d(LogDBTask.f49278f, "repeated upload check, uploadUrl===" + b);
                List<LogRecord> b2 = LogDBTask.this.f49280g.mo122299b(b);
                if (b2 != null && !b2.isEmpty()) {
                    LogUtils.m37052d(LogDBTask.f49278f, "schedule upload...");
                    UploadObj buildUploadObj = LogDBTask.this.buildUploadObj(b2, b, postKey);
                    Boolean bool = (Boolean) LogDBTask.this.encryptMap.get(b);
                    boolean z = bool != null && bool.booleanValue();
                    String str = (String) LogDBTask.this.versionMap.get(b);
                    if (!TextUtils.isEmpty(str)) {
                        LogDBTask.this.f49283j.mo122327a(b, buildUploadObj, postKey, str);
                    } else {
                        LogDBTask.this.f49283j.mo122328a(b, buildUploadObj, postKey, z);
                    }
                    LogDBTask.this.f49280g.mo122300b(buildUploadObj.ids);
                }
            }
        }
    };

    /* renamed from: d */
    static /* synthetic */ int m36960d(LogDBTask logDBTask) {
        int i = logDBTask.f49286n;
        logDBTask.f49286n = i + 1;
        return i;
    }

    private LogDBTask() {
        HandlerThread handlerThread = new HandlerThread("db_thread2", 10);
        this.f49281h = handlerThread;
        handlerThread.start();
        DbHandler dbHandler = new DbHandler(this.f49281h.getLooper());
        this.f49282i = dbHandler;
        this.f49283j = new C16121a(dbHandler);
    }

    /* renamed from: a */
    public void mo122289a() {
        Handler handler = this.f49282i;
        if (handler != null) {
            handler.postDelayed(this.f49287o, 5000);
        }
    }

    /* renamed from: b */
    public static LogDBTask m36957b() {
        return f49279m;
    }

    /* renamed from: a */
    public void mo122290a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.activeUrl = str;
            Message obtain = Message.obtain(this.f49282i);
            obtain.what = 1;
            obtain.obj = new LogDbHelper2.DbRecord(str, str2, str3);
            obtain.sendToTarget();
        }
    }

    private class DbHandler extends Handler {
        DbHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                long a = LogDBTask.this.f49280g.mo122295a((LogDbHelper2.DbRecord) message.obj);
                LogUtils.m37052d(LogDBTask.f49278f, "insert ok, id=" + a);
            } else if (message.what == 2) {
                LogUtils.m37052d(LogDBTask.f49278f, "upload ok, del ids=" + message.obj);
                int unused = LogDBTask.this.f49286n = 0;
                if (LogDBTask.this.f49280g.mo122294a((List<String>) (List) message.obj) > 0) {
                    LogDBTask.this.f49282i.postDelayed(LogDBTask.this.f49287o, 3000);
                }
            } else if (message.what == 3) {
                LogUtils.m37052d(LogDBTask.f49278f, "upload failed, ids=" + message.obj);
                LogDBTask.m36960d(LogDBTask.this);
                LogDBTask.this.f49280g.mo122302c((List) message.obj);
                LogDBTask.this.f49282i.postDelayed(LogDBTask.this.f49287o, 10000);
            }
        }
    }

    /* renamed from: b */
    public void mo122291b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.activeUrl = str;
            Message obtain = Message.obtain(this.f49282i);
            obtain.what = 1;
            obtain.obj = new LogDbHelper2.DbRecord(str, str2, str3);
            obtain.sendToTarget();
        }
    }
}
