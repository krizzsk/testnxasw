package com.didichuxing.dfbasesdk.logupload;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.DFApi;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogSaver {
    public static final int MSG_SAVE_LOG = 1;
    public static final int MSG_UPLOAD_FAIL = 3;
    public static final int MSG_UPLOAD_OK = 2;

    /* renamed from: a */
    private static final long f49251a = 5000;

    /* renamed from: b */
    private static final long f49252b = 20000;

    /* renamed from: l */
    private static LogSaver f49253l = new LogSaver();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile LogDbHelper f49254c;

    /* renamed from: d */
    private HandlerThread f49255d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f49256e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LogUploader f49257f;

    /* renamed from: g */
    private volatile boolean f49258g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f49259h;

    /* renamed from: i */
    private boolean f49260i;

    /* renamed from: j */
    private volatile String f49261j;

    /* renamed from: k */
    private volatile String f49262k;

    /* renamed from: m */
    private final Runnable f49263m = new Runnable() {
        public void run() {
            LogUtils.m37052d(LogRecord.LOG_TAG, "repeated upload check...");
            List<LogRecord> c = LogSaver.this.f49254c.mo122258c();
            if (!c.isEmpty()) {
                List a = LogSaver.this.m36937a(c);
                if (!a.isEmpty()) {
                    LogUtils.m37052d(LogRecord.LOG_TAG, "send upload msg...");
                    Message obtain = Message.obtain(LogSaver.this.f49257f.mo122280a());
                    obtain.what = 1;
                    obtain.obj = LogSaver.this.m36942b((List<LogRecord>) a);
                    obtain.sendToTarget();
                    LogSaver.this.f49254c.mo122253a();
                    return;
                }
                LogUtils.m37052d(LogRecord.LOG_TAG, "remainings are all uploading logs...");
            }
        }
    };

    /* renamed from: n */
    private final Runnable f49264n = new Runnable() {
        public void run() {
            LogUtils.m37052d(LogRecord.LOG_TAG, "repeated upload check...");
            List<LogRecord> b = LogSaver.this.f49254c.mo122255b();
            if (!b.isEmpty()) {
                LogUtils.m37052d(LogRecord.LOG_TAG, "schedule upload...");
                Message obtain = Message.obtain(LogSaver.this.f49257f.mo122280a());
                obtain.what = 1;
                UploadObj b2 = LogSaver.this.m36942b(b);
                obtain.obj = b2;
                obtain.sendToTarget();
                LogSaver.this.f49254c.mo122257b(b2.ids);
            }
            if (LogSaver.this.f49259h) {
                LogUtils.m37052d(LogRecord.LOG_TAG, "schedule exit in 20s...");
                if (LogSaver.this.f49256e != null) {
                    LogSaver.this.f49256e.postDelayed(LogSaver.this.f49265o, 20000);
                    return;
                }
                return;
            }
            LogUtils.m37052d(LogRecord.LOG_TAG, "schedule next check...");
            if (LogSaver.this.f49256e != null) {
                LogSaver.this.f49256e.postDelayed(this, 5000);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Runnable f49265o = new Runnable() {
        public void run() {
            LogSaver.this.m36943b();
        }
    };

    public static LogSaver getInstance() {
        return f49253l;
    }

    public void onEnter(Context context, String str, String str2) {
        LogUtils.m37052d(LogRecord.LOG_TAG, "onEnter, mInited=" + this.f49260i);
        this.f49259h = false;
        this.f49258g = false;
        if (!this.f49260i) {
            m36939a(context, str2);
            this.f49260i = true;
        } else {
            Handler handler = this.f49256e;
            if (handler != null) {
                handler.removeCallbacks(this.f49265o);
                this.f49256e.removeCallbacks(this.f49264n);
            }
        }
        this.f49261j = str;
    }

    public void setSdkVer(String str) {
        this.f49262k = str;
    }

    public void onEnter(Context context, String str, String str2, String str3) {
        LogUtils.m37052d(LogRecord.LOG_TAG, "onEnter, mInited=" + this.f49260i);
        this.f49259h = false;
        this.f49258g = false;
        if (!this.f49260i) {
            m36940a(context, str, str3);
            this.f49260i = true;
        } else {
            Handler handler = this.f49256e;
            if (handler != null) {
                handler.removeCallbacks(this.f49265o);
                this.f49256e.removeCallbacks(this.f49264n);
            }
        }
        this.f49261j = str2;
    }

    /* renamed from: a */
    private void m36940a(Context context, String str, String str2) {
        this.f49254c = new LogDbHelper(context, str);
        HandlerThread handlerThread = new HandlerThread("db_thread", 10);
        this.f49255d = handlerThread;
        handlerThread.start();
        DbHandler dbHandler = new DbHandler(this.f49255d.getLooper());
        this.f49256e = dbHandler;
        this.f49257f = new LogUploader(dbHandler, str2);
    }

    /* renamed from: a */
    private void m36939a(Context context, String str) {
        this.f49254c = new LogDbHelper(context);
        HandlerThread handlerThread = new HandlerThread("db_thread", 10);
        this.f49255d = handlerThread;
        handlerThread.start();
        DbHandler dbHandler = new DbHandler(this.f49255d.getLooper());
        this.f49256e = dbHandler;
        this.f49257f = new LogUploader(dbHandler, str);
    }

    public void setSessionId(String str) {
        this.f49261j = str;
    }

    public void save(LoggerParam loggerParam) {
        save(GsonUtils.toJsonStr(loggerParam));
    }

    public <T> void save(T t) {
        save(GsonUtils.toJsonStr(t));
    }

    public void syncSave(LoggerParam loggerParam) {
        this.f49254c.mo122252a(GsonUtils.toJsonStr(loggerParam));
    }

    public <T> void syncSave(T t) {
        this.f49254c.mo122252a(GsonUtils.toJsonStr(t));
    }

    public void syncSave(String str) {
        this.f49254c.mo122252a(str);
    }

    public void uploadOnce() {
        this.f49256e.postDelayed(this.f49263m, 5000);
    }

    public void save(String str) {
        Handler handler = this.f49256e;
        if (handler != null) {
            Message obtain = Message.obtain(handler);
            obtain.what = 1;
            obtain.obj = str;
            obtain.sendToTarget();
        }
    }

    private class DbHandler extends Handler {
        DbHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (LogSaver.this.f49254c != null) {
                if (message.what == 1) {
                    long a = LogSaver.this.f49254c.mo122252a((String) message.obj);
                    LogUtils.m37052d(LogRecord.LOG_TAG, "insert ok, id=" + a);
                    LogSaver.this.m36938a();
                } else if (message.what == 2) {
                    LogUtils.m37052d(LogRecord.LOG_TAG, "upload ok, del ids=" + message.obj);
                    LogSaver.this.f49254c.mo122254a((List<String>) (List) message.obj);
                } else if (message.what == 3) {
                    LogUtils.m37052d(LogRecord.LOG_TAG, "upload failed, ids=" + message.obj);
                    LogSaver.this.f49254c.mo122259c((List) message.obj);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36938a() {
        if (!this.f49258g) {
            Handler handler = this.f49256e;
            if (handler != null) {
                handler.postDelayed(this.f49264n, 5000);
            }
            this.f49258g = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<LogRecord> m36937a(List<LogRecord> list) {
        ArrayList arrayList = new ArrayList();
        for (LogRecord next : list) {
            if (next.isNeedUpload()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public UploadObj m36942b(List<LogRecord> list) {
        UploadObj uploadObj = new UploadObj();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (LogRecord next : list) {
                uploadObj.ids.add(next.f49250id);
                jSONArray.put(new JSONObject(next.content));
            }
            jSONObject.put("jsonArray", jSONArray);
            jSONObject.put("sessionId", this.f49261j);
            jSONObject.put("extra", DFApi.getCommonExtra(this.f49262k));
            uploadObj.jsonBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.logStackTrace(e);
        }
        return uploadObj;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36943b() {
        LogUtils.m37052d(LogRecord.LOG_TAG, "exit sdk uninit");
        CheckUtils.checkAssert(this.f49260i, "mInited is false, should be true!!!");
        if (this.f49260i) {
            this.f49257f = null;
            HandlerThread handlerThread = this.f49255d;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.f49255d = null;
            this.f49256e = null;
            this.f49254c.mo122260d();
            this.f49254c = null;
            this.f49260i = false;
        }
    }

    public void onExit() {
        this.f49259h = true;
    }
}
