package com.didi.sdk.logging.upload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.PeriodicWorkRequest;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.logging.upload.persist.TaskRecord;
import com.didi.sdk.logging.upload.persist.UploadTaskDatabase;
import com.didi.sdk.logging.util.ArchTaskExecutor;
import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.ReportUtils;
import com.didi.sdk.logging.util.Supplier;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import global.didi.pay.newview.pix.IPixView;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class UploadTaskManager extends BroadcastReceiver {
    public static final String ACTION_GET_TREE = "bamai_get_tree";
    public static final String ACTION_UPLOAD_LOG = "bamai_upload_log";

    /* renamed from: a */
    private static UploadTaskManager f39362a;

    /* renamed from: b */
    private boolean f39363b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f39364c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private ConnectivityManager f39365d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f39366e = new Object();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f39367f;

    /* renamed from: g */
    private Context f39368g;

    /* renamed from: h */
    private Set<String> f39369h = Collections.synchronizedSet(new HashSet());

    /* renamed from: i */
    private SharedPreferences f39370i;

    public static UploadTaskManager getInstance() {
        if (f39362a == null) {
            f39362a = new UploadTaskManager();
        }
        return f39362a;
    }

    private UploadTaskManager() {
    }

    public synchronized void init(Context context) {
        if (!this.f39363b) {
            this.f39363b = true;
            this.f39368g = context;
            m29684d(IPixView.PAGE_STATUS_INIT);
            this.f39370i = SystemUtils.getSharedPreferences(this.f39368g, "logging_record", 0);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.f39365d = connectivityManager;
            if (connectivityManager != null) {
                m29670a(context);
            }
        }
    }

    /* renamed from: a */
    private void m29670a(final Context context) {
        synchronized (this.f39366e) {
            if (!this.f39367f) {
                m29677b(context);
                ArchTaskExecutor.getInstance().executeOnDiskIO(new Runnable() {
                    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r4 = this;
                            r0 = 1
                            java.lang.String r1 = "onInit"
                            com.didi.sdk.logging.upload.UploadTaskManager.m29684d((java.lang.String) r1)     // Catch:{ all -> 0x002a }
                            android.content.Context r1 = r3     // Catch:{ all -> 0x002a }
                            com.didi.sdk.logging.upload.persist.UploadTaskDatabase.initDatabase(r1)     // Catch:{ all -> 0x002a }
                            com.didi.sdk.logging.upload.UploadTaskManager r1 = com.didi.sdk.logging.upload.UploadTaskManager.this     // Catch:{ all -> 0x002a }
                            r1.mo99076c()     // Catch:{ all -> 0x002a }
                            com.didi.sdk.logging.upload.UploadTaskManager r1 = com.didi.sdk.logging.upload.UploadTaskManager.this
                            java.lang.Object r1 = r1.f39366e
                            monitor-enter(r1)
                            com.didi.sdk.logging.upload.UploadTaskManager r2 = com.didi.sdk.logging.upload.UploadTaskManager.this     // Catch:{ all -> 0x0027 }
                            boolean unused = r2.f39367f = r0     // Catch:{ all -> 0x0027 }
                            com.didi.sdk.logging.upload.UploadTaskManager r0 = com.didi.sdk.logging.upload.UploadTaskManager.this     // Catch:{ all -> 0x0027 }
                            java.lang.Object r0 = r0.f39366e     // Catch:{ all -> 0x0027 }
                            r0.notifyAll()     // Catch:{ all -> 0x0027 }
                            monitor-exit(r1)     // Catch:{ all -> 0x0027 }
                            goto L_0x004b
                        L_0x0027:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch:{ all -> 0x0027 }
                            throw r0
                        L_0x002a:
                            r1 = move-exception
                            java.lang.String r2 = "init err"
                            com.didi.sdk.logging.util.Debug.logOrThrow(r2, r1)     // Catch:{ all -> 0x004f }
                            java.lang.String r2 = "logging_init_err"
                            com.didi.sdk.logging.util.ReportUtils.reportProgramError(r2, r1)     // Catch:{ all -> 0x004f }
                            com.didi.sdk.logging.upload.UploadTaskManager r1 = com.didi.sdk.logging.upload.UploadTaskManager.this
                            java.lang.Object r1 = r1.f39366e
                            monitor-enter(r1)
                            com.didi.sdk.logging.upload.UploadTaskManager r2 = com.didi.sdk.logging.upload.UploadTaskManager.this     // Catch:{ all -> 0x004c }
                            boolean unused = r2.f39367f = r0     // Catch:{ all -> 0x004c }
                            com.didi.sdk.logging.upload.UploadTaskManager r0 = com.didi.sdk.logging.upload.UploadTaskManager.this     // Catch:{ all -> 0x004c }
                            java.lang.Object r0 = r0.f39366e     // Catch:{ all -> 0x004c }
                            r0.notifyAll()     // Catch:{ all -> 0x004c }
                            monitor-exit(r1)     // Catch:{ all -> 0x004c }
                        L_0x004b:
                            return
                        L_0x004c:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch:{ all -> 0x004c }
                            throw r0
                        L_0x004f:
                            r1 = move-exception
                            com.didi.sdk.logging.upload.UploadTaskManager r2 = com.didi.sdk.logging.upload.UploadTaskManager.this
                            java.lang.Object r2 = r2.f39366e
                            monitor-enter(r2)
                            com.didi.sdk.logging.upload.UploadTaskManager r3 = com.didi.sdk.logging.upload.UploadTaskManager.this     // Catch:{ all -> 0x0067 }
                            boolean unused = r3.f39367f = r0     // Catch:{ all -> 0x0067 }
                            com.didi.sdk.logging.upload.UploadTaskManager r0 = com.didi.sdk.logging.upload.UploadTaskManager.this     // Catch:{ all -> 0x0067 }
                            java.lang.Object r0 = r0.f39366e     // Catch:{ all -> 0x0067 }
                            r0.notifyAll()     // Catch:{ all -> 0x0067 }
                            monitor-exit(r2)     // Catch:{ all -> 0x0067 }
                            throw r1
                        L_0x0067:
                            r0 = move-exception
                            monitor-exit(r2)     // Catch:{ all -> 0x0067 }
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.upload.UploadTaskManager.C132291.run():void");
                    }
                });
            }
        }
    }

    /* renamed from: b */
    private void m29677b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_GET_TREE);
        intentFilter.addAction(ACTION_UPLOAD_LOG);
        if (Debug.isDebuggable()) {
            try {
                context.registerReceiver(this, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            LocalBroadcastManager.getInstance(context).registerReceiver(this, intentFilter);
        } else {
            LocalBroadcastManager.getInstance(context).registerReceiver(this, intentFilter);
        }
        try {
            context.registerReceiver(this, new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION));
        } catch (Exception e2) {
            Log.d("Context", "registerReceiver", e2);
        }
    }

    public void onReceive(Context context, final Intent intent) {
        if (intent != null) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(new Runnable() {
                public void run() {
                    UploadTaskManager.this.m29683d();
                    try {
                        UploadTaskManager.this.m29671a(intent);
                    } catch (Exception e) {
                        Debug.logOrThrow("perform receive err", e);
                        ReportUtils.reportProgramError("logging_receiver_err", e);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:14:0x0003, LOOP_START, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m29683d() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f39366e
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r2.f39367f     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0012
            java.lang.String r1 = "awaitDatabaseLoadedLocked"
            m29684d((java.lang.String) r1)     // Catch:{ InterruptedException -> 0x0003 }
            java.lang.Object r1 = r2.f39366e     // Catch:{ InterruptedException -> 0x0003 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0003 }
            goto L_0x0003
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.upload.UploadTaskManager.m29683d():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29671a(Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("im_message_extra");
        m29684d("receive msg, action: " + action + " extra: " + stringExtra);
        if (NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION.equals(action)) {
            m29685e();
        } else if (ACTION_UPLOAD_LOG.equals(action)) {
            ReportUtils.reportReceivePush(action, stringExtra);
            m29681c(stringExtra);
        } else if (ACTION_GET_TREE.equals(action)) {
            ReportUtils.reportReceivePush(action, stringExtra);
            m29679b(stringExtra);
        }
    }

    /* renamed from: b */
    private void m29679b(String str) {
        GetTreeTask parseGetTreeTask = GetTreeTask.parseGetTreeTask(str);
        if (parseGetTreeTask != null) {
            long currentTimeMillis = System.currentTimeMillis() - parseGetTreeTask.getPushTimestamp();
            m29684d("getTree timeDif = " + currentTimeMillis);
            if (currentTimeMillis < 20000) {
                m29672a(parseGetTreeTask, this.f39368g);
            } else {
                OmegaSDKAdapter.trackEvent("tone_p_x_catchdata_tree_timeout_sw");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m29685e() {
        if (m29686f()) {
            UploadService.getInstance().start(this.f39368g);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo99072a() {
        if (m29686f()) {
            this.f39364c.postDelayed(new Runnable() {
                public void run() {
                    UploadTaskManager.this.m29685e();
                }
            }, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo99075b() {
        try {
            Supplier<String> uidSupplier = LoggerFactory.getConfig().getUidSupplier();
            if (uidSupplier != null && !TextUtils.isEmpty(uidSupplier.get())) {
                Pair<TaskRecord, String> a = C13234a.m29692a(uidSupplier.get());
                if (a.first != null) {
                    ReportUtils.reportReceivePush("query_task_result", (String) a.second);
                    m29674a((TaskRecord) a.first);
                }
            }
        } catch (Exception e) {
            Debug.logOrThrow("query Task err", e);
            ReportUtils.reportProgramError("logging_query_task_err", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo99076c() {
        final C132324 r0 = new Runnable() {
            public void run() {
                Supplier<String> uidSupplier = LoggerFactory.getConfig().getUidSupplier();
                if (uidSupplier != null && !TextUtils.isEmpty(uidSupplier.get())) {
                    UploadTaskManager.this.mo99075b();
                }
            }
        };
        final long millis = TimeUnit.MINUTES.toMillis((long) LoggerFactory.getConfig().getQueryTimeInterval());
        this.f39364c.postDelayed(new Runnable() {
            public void run() {
                ArchTaskExecutor.getInstance().executeOnDiskIO(r0);
                UploadTaskManager.this.f39364c.postDelayed(this, millis);
            }
        }, 15000);
    }

    /* renamed from: a */
    private void m29672a(GetTreeTask getTreeTask, Context context) {
        if (getTreeTask != null && getTreeTask.hasTaskId()) {
            String networkType = LoggerUtils.getNetworkType(context);
            File parentFile = context.getFilesDir().getParentFile();
            FileTree fileTree = new FileTree();
            for (File fileEntry : parentFile.listFiles()) {
                fileTree.addSubTree(new FileEntry(fileEntry));
            }
            C13234a.m29695a(getTreeTask.getTaskId(), networkType, fileTree);
        }
    }

    /* renamed from: c */
    private void m29681c(String str) {
        m29674a(TaskRecord.fromJson(str));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:89|(2:91|92)|(1:94)|95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ee, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01f1, code lost:
        r19 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01f6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01f7, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01f8, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01fa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01fb, code lost:
        r18 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0221 */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x020c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ee A[ExcHandler: all (th java.lang.Throwable), Splitter:B:49:0x018a] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01f6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:42:0x0175] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0206 A[SYNTHETIC, Splitter:B:84:0x0206] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0219 A[SYNTHETIC, Splitter:B:91:0x0219] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x021e A[Catch:{ Exception -> 0x0221 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:95:0x0221=Splitter:B:95:0x0221, B:105:0x02a2=Splitter:B:105:0x02a2, B:24:0x00f6=Splitter:B:24:0x00f6} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m29674a(com.didi.sdk.logging.upload.persist.TaskRecord r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r0 = "Task "
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "create task record: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.didi.sdk.logging.util.Debug.m29710i(r3)
            java.lang.String r3 = ""
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L_0x02c3
            boolean r6 = r22.isValid()
            if (r6 != 0) goto L_0x0028
            goto L_0x02c3
        L_0x0028:
            java.lang.String r6 = r22.getTaskId()
            android.content.SharedPreferences r7 = r1.f39370i
            boolean r7 = r7.getBoolean(r6, r4)
            if (r7 == 0) goto L_0x0049
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "task already done: "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.didi.sdk.logging.util.Debug.m29710i(r0)
            return
        L_0x0049:
            com.didi.sdk.logging.upload.persist.UploadTaskDatabase r7 = com.didi.sdk.logging.upload.persist.UploadTaskDatabase.getDatabase()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.upload.persist.TaskRecordDao r14 = r7.getTaskRecordDao()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.upload.persist.TaskRecord r7 = r14.getRecordsByTaskId(r6)     // Catch:{ all -> 0x02bc }
            java.util.Set<java.lang.String> r8 = r1.f39369h     // Catch:{ all -> 0x02bc }
            boolean r8 = r8.contains(r6)     // Catch:{ all -> 0x02bc }
            if (r8 != 0) goto L_0x02a2
            if (r7 == 0) goto L_0x0061
            goto L_0x02a2
        L_0x0061:
            java.util.Set<java.lang.String> r7 = r1.f39369h     // Catch:{ all -> 0x02bc }
            r7.add(r6)     // Catch:{ all -> 0x02bc }
            r7 = 3
            java.lang.String r8 = "已收到日志上传任务"
            com.didi.sdk.logging.upload.C13234a.m29694a((java.lang.String) r6, (int) r7, (java.lang.String) r8)     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.LoggerContext r7 = com.didi.sdk.logging.LoggerContext.getDefault()     // Catch:{ all -> 0x02bc }
            java.io.File r8 = r7.getMainLogPathDir()     // Catch:{ all -> 0x02bc }
            java.lang.String r9 = r22.getBuffers()     // Catch:{ all -> 0x02bc }
            long r10 = r22.getStartTimestamp()     // Catch:{ all -> 0x02bc }
            long r12 = r22.getEndTimestamp()     // Catch:{ all -> 0x02bc }
            java.util.List r7 = com.didi.sdk.logging.util.LoggerUtils.collectLogFilesWithRange((java.io.File) r8, (java.lang.String) r9, (long) r10, (long) r12)     // Catch:{ all -> 0x02bc }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bc }
            r8.<init>()     // Catch:{ all -> 0x02bc }
            r8.append(r0)     // Catch:{ all -> 0x02bc }
            java.lang.String r9 = r22.getTaskId()     // Catch:{ all -> 0x02bc }
            r8.append(r9)     // Catch:{ all -> 0x02bc }
            java.lang.String r9 = " collect main log dir files: "
            r8.append(r9)     // Catch:{ all -> 0x02bc }
            r8.append(r7)     // Catch:{ all -> 0x02bc }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.util.Debug.m29710i(r8)     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.LoggerContext r8 = com.didi.sdk.logging.LoggerContext.getDefault()     // Catch:{ all -> 0x02bc }
            java.io.File r8 = r8.getSecondaryLogPathDir()     // Catch:{ all -> 0x02bc }
            if (r8 == 0) goto L_0x00be
            java.lang.String r16 = r22.getBuffers()     // Catch:{ all -> 0x02bc }
            long r17 = r22.getStartTimestamp()     // Catch:{ all -> 0x02bc }
            long r19 = r22.getEndTimestamp()     // Catch:{ all -> 0x02bc }
            r15 = r8
            java.util.List r9 = com.didi.sdk.logging.util.LoggerUtils.collectLogFilesWithRange((java.io.File) r15, (java.lang.String) r16, (long) r17, (long) r19)     // Catch:{ all -> 0x02bc }
            goto L_0x00bf
        L_0x00be:
            r9 = r5
        L_0x00bf:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bc }
            r10.<init>()     // Catch:{ all -> 0x02bc }
            r10.append(r0)     // Catch:{ all -> 0x02bc }
            java.lang.String r0 = r22.getTaskId()     // Catch:{ all -> 0x02bc }
            r10.append(r0)     // Catch:{ all -> 0x02bc }
            java.lang.String r0 = " collect secondary log dir files: "
            r10.append(r0)     // Catch:{ all -> 0x02bc }
            r10.append(r9)     // Catch:{ all -> 0x02bc }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.util.Debug.m29710i(r0)     // Catch:{ all -> 0x02bc }
            boolean r0 = com.didi.sdk.logging.util.LoggerUtils.isEmpty(r7)     // Catch:{ all -> 0x02bc }
            if (r0 == 0) goto L_0x00f6
            boolean r0 = com.didi.sdk.logging.util.LoggerUtils.isEmpty(r9)     // Catch:{ all -> 0x02bc }
            if (r0 == 0) goto L_0x00f6
            r0 = 101(0x65, float:1.42E-43)
            java.lang.String r2 = "该任务时间段无待上传文件"
            com.didi.sdk.logging.upload.C13234a.m29694a((java.lang.String) r6, (int) r0, (java.lang.String) r2)     // Catch:{ all -> 0x02bc }
            java.util.Set<java.lang.String> r0 = r1.f39369h
            r0.remove(r6)
            return
        L_0x00f6:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x02bc }
            r0.<init>()     // Catch:{ all -> 0x02bc }
            boolean r10 = com.didi.sdk.logging.util.LoggerUtils.isEmpty(r7)     // Catch:{ all -> 0x02bc }
            if (r10 != 0) goto L_0x0111
            com.didi.sdk.logging.LoggerContext r10 = com.didi.sdk.logging.LoggerContext.getDefault()     // Catch:{ all -> 0x02bc }
            java.io.File r10 = r10.getMainLogPathDir()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.util.ZipUtil$EntrySet r11 = new com.didi.sdk.logging.util.ZipUtil$EntrySet     // Catch:{ all -> 0x02bc }
            r11.<init>(r5, r10, r7)     // Catch:{ all -> 0x02bc }
            r0.add(r11)     // Catch:{ all -> 0x02bc }
        L_0x0111:
            boolean r7 = com.didi.sdk.logging.util.LoggerUtils.isEmpty(r9)     // Catch:{ all -> 0x02bc }
            if (r7 != 0) goto L_0x0121
            com.didi.sdk.logging.util.ZipUtil$EntrySet r7 = new com.didi.sdk.logging.util.ZipUtil$EntrySet     // Catch:{ all -> 0x02bc }
            java.lang.String r10 = "secondary_log"
            r7.<init>(r10, r8, r9)     // Catch:{ all -> 0x02bc }
            r0.add(r7)     // Catch:{ all -> 0x02bc }
        L_0x0121:
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x02bc }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x02bc }
            r15.<init>()     // Catch:{ all -> 0x02bc }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x02bc }
        L_0x012e:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x02bc }
            if (r0 == 0) goto L_0x022a
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.util.ZipUtil$EntrySet r0 = (com.didi.sdk.logging.util.ZipUtil.EntrySet) r0     // Catch:{ all -> 0x02bc }
            java.util.List<java.io.File> r9 = r0.files     // Catch:{ all -> 0x02bc }
            java.io.File r10 = r0.baseDir     // Catch:{ all -> 0x02bc }
            java.lang.String r11 = r0.prefixPath     // Catch:{ all -> 0x02bc }
            if (r9 == 0) goto L_0x0222
            r12 = 0
        L_0x0143:
            int r0 = r9.size()     // Catch:{ all -> 0x02bc }
            if (r12 >= r0) goto L_0x0222
            java.lang.Object r0 = r9.get(r12)     // Catch:{ all -> 0x02bc }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x02bc }
            java.io.File r13 = new java.io.File     // Catch:{ all -> 0x02bc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bc }
            r5.<init>()     // Catch:{ all -> 0x02bc }
            java.lang.String r4 = r0.getAbsolutePath()     // Catch:{ all -> 0x02bc }
            r5.append(r4)     // Catch:{ all -> 0x02bc }
            java.lang.String r4 = ".zip"
            r5.append(r4)     // Catch:{ all -> 0x02bc }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x02bc }
            r13.<init>(r4)     // Catch:{ all -> 0x02bc }
            r15.add(r13)     // Catch:{ all -> 0x02bc }
            boolean r4 = r13.exists()     // Catch:{ all -> 0x02bc }
            if (r4 == 0) goto L_0x0175
            r13.delete()     // Catch:{ all -> 0x02bc }
        L_0x0175:
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x01fa, all -> 0x01f6 }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x01fa, all -> 0x01f6 }
            r18 = r8
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01f4, all -> 0x01f6 }
            r8.<init>(r13)     // Catch:{ Exception -> 0x01f4, all -> 0x01f6 }
            r5.<init>(r8)     // Catch:{ Exception -> 0x01f4, all -> 0x01f6 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x01f4, all -> 0x01f6 }
            java.lang.String r5 = "/"
            if (r10 != 0) goto L_0x0191
            java.lang.String r8 = r0.getName()     // Catch:{ Exception -> 0x01f0, all -> 0x01ee }
            r19 = r9
            goto L_0x01ae
        L_0x0191:
            java.lang.String r8 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x01f0, all -> 0x01ee }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f0, all -> 0x01ee }
            r13.<init>()     // Catch:{ Exception -> 0x01f0, all -> 0x01ee }
            r19 = r9
            java.lang.String r9 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r13.append(r9)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r13.append(r5)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            java.lang.String r9 = r13.toString()     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            java.lang.String r8 = r8.replace(r9, r3)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
        L_0x01ae:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            if (r9 == 0) goto L_0x01b5
            goto L_0x01c7
        L_0x01b5:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r9.<init>()     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r9.append(r11)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r9.append(r5)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r9.append(r8)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
        L_0x01c7:
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r5.<init>(r8)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r4.putNextEntry(r5)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
            r5.<init>(r0)     // Catch:{ Exception -> 0x01ec, all -> 0x01ee }
        L_0x01d4:
            int r0 = r5.read(r7)     // Catch:{ Exception -> 0x01ea }
            r8 = -1
            if (r0 == r8) goto L_0x01e0
            r8 = 0
            r4.write(r7, r8, r0)     // Catch:{ Exception -> 0x01ea }
            goto L_0x01d4
        L_0x01e0:
            r4.flush()     // Catch:{ Exception -> 0x01ea }
            r5.close()     // Catch:{ Exception -> 0x020c }
        L_0x01e6:
            r4.close()     // Catch:{ Exception -> 0x020c }
            goto L_0x020c
        L_0x01ea:
            r0 = move-exception
            goto L_0x0201
        L_0x01ec:
            r0 = move-exception
            goto L_0x0200
        L_0x01ee:
            r0 = move-exception
            goto L_0x01f8
        L_0x01f0:
            r0 = move-exception
            r19 = r9
            goto L_0x0200
        L_0x01f4:
            r0 = move-exception
            goto L_0x01fd
        L_0x01f6:
            r0 = move-exception
            r4 = 0
        L_0x01f8:
            r5 = 0
            goto L_0x0217
        L_0x01fa:
            r0 = move-exception
            r18 = r8
        L_0x01fd:
            r19 = r9
            r4 = 0
        L_0x0200:
            r5 = 0
        L_0x0201:
            r0.printStackTrace()     // Catch:{ all -> 0x0216 }
            if (r5 == 0) goto L_0x0209
            r5.close()     // Catch:{ Exception -> 0x020c }
        L_0x0209:
            if (r4 == 0) goto L_0x020c
            goto L_0x01e6
        L_0x020c:
            int r12 = r12 + 1
            r8 = r18
            r9 = r19
            r4 = 0
            r5 = 0
            goto L_0x0143
        L_0x0216:
            r0 = move-exception
        L_0x0217:
            if (r5 == 0) goto L_0x021c
            r5.close()     // Catch:{ Exception -> 0x0221 }
        L_0x021c:
            if (r4 == 0) goto L_0x0221
            r4.close()     // Catch:{ Exception -> 0x0221 }
        L_0x0221:
            throw r0     // Catch:{ all -> 0x02bc }
        L_0x0222:
            r18 = r8
            r8 = r18
            r4 = 0
            r5 = 0
            goto L_0x012e
        L_0x022a:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x02bc }
            r0.<init>()     // Catch:{ all -> 0x02bc }
            r4 = 0
        L_0x0230:
            int r3 = r15.size()     // Catch:{ all -> 0x02bc }
            if (r4 >= r3) goto L_0x0262
            java.lang.Object r3 = r15.get(r4)     // Catch:{ all -> 0x02bc }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x02bc }
            long r16 = r3.length()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.upload.persist.SliceRecord r5 = new com.didi.sdk.logging.upload.persist.SliceRecord     // Catch:{ all -> 0x02bc }
            int r9 = r15.size()     // Catch:{ all -> 0x02bc }
            java.lang.String r11 = r3.getAbsolutePath()     // Catch:{ all -> 0x02bc }
            r18 = 0
            r7 = r5
            r8 = r6
            r10 = r4
            r12 = r16
            r3 = r14
            r20 = r15
            r14 = r18
            r7.<init>(r8, r9, r10, r11, r12, r14, r16)     // Catch:{ all -> 0x02bc }
            r0.add(r5)     // Catch:{ all -> 0x02bc }
            int r4 = r4 + 1
            r14 = r3
            r15 = r20
            goto L_0x0230
        L_0x0262:
            r3 = r14
            r3.add(r2)     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.upload.persist.UploadTaskDatabase r3 = com.didi.sdk.logging.upload.persist.UploadTaskDatabase.getDatabase()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.upload.persist.SliceRecordDao r3 = r3.getFileRecordDao()     // Catch:{ all -> 0x02bc }
            r3.addAll(r0)     // Catch:{ all -> 0x02bc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bc }
            r3.<init>()     // Catch:{ all -> 0x02bc }
            java.lang.String r4 = "create task successfully: record:"
            r3.append(r4)     // Catch:{ all -> 0x02bc }
            r3.append(r2)     // Catch:{ all -> 0x02bc }
            java.lang.String r2 = " sliceRecords:"
            r3.append(r2)     // Catch:{ all -> 0x02bc }
            r3.append(r0)     // Catch:{ all -> 0x02bc }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.util.Debug.m29710i(r0)     // Catch:{ all -> 0x02bc }
            java.util.Set<java.lang.String> r0 = r1.f39369h
            r0.remove(r6)
            r0 = 4
            java.lang.String r2 = "文件上传中"
            com.didi.sdk.logging.upload.C13234a.m29694a((java.lang.String) r6, (int) r0, (java.lang.String) r2)
            com.didi.sdk.logging.upload.UploadService r0 = com.didi.sdk.logging.upload.UploadService.getInstance()
            android.content.Context r2 = r1.f39368g
            r0.start(r2)
            return
        L_0x02a2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bc }
            r0.<init>()     // Catch:{ all -> 0x02bc }
            java.lang.String r3 = "task already exists: "
            r0.append(r3)     // Catch:{ all -> 0x02bc }
            r0.append(r2)     // Catch:{ all -> 0x02bc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02bc }
            com.didi.sdk.logging.util.Debug.m29710i(r0)     // Catch:{ all -> 0x02bc }
            java.util.Set<java.lang.String> r0 = r1.f39369h
            r0.remove(r6)
            return
        L_0x02bc:
            r0 = move-exception
            java.util.Set<java.lang.String> r2 = r1.f39369h
            r2.remove(r6)
            throw r0
        L_0x02c3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "参数异常:"
            r0.append(r4)
            if (r2 == 0) goto L_0x02d4
            java.lang.String r5 = r22.getRawData()
            goto L_0x02d5
        L_0x02d4:
            r5 = 0
        L_0x02d5:
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r4 = 0
            com.didi.sdk.logging.util.ReportUtils.reportUploadTaskResult(r4, r3, r3, r0)
            if (r2 == 0) goto L_0x02f1
            boolean r3 = r22.isValid()
            if (r3 != 0) goto L_0x02f1
            java.lang.String r2 = r22.getTaskId()
            r3 = 102(0x66, float:1.43E-43)
            com.didi.sdk.logging.upload.C13234a.m29694a((java.lang.String) r2, (int) r3, (java.lang.String) r0)
        L_0x02f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.upload.UploadTaskManager.m29674a(com.didi.sdk.logging.upload.persist.TaskRecord):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo99074a(Context context, String str, String str2) {
        m29684d("task failed:" + str);
        this.f39370i.edit().putBoolean(str, true).apply();
        if (str2 == null) {
            str2 = "文件上传失败";
        }
        C13234a.m29694a(str, 102, str2);
        ReportUtils.reportUploadTaskResult(false, LoggerUtils.getNetworkType(context), str, str2);
        UploadTaskDatabase.getDatabase().getTaskRecordDao().deleteByTaskId(str);
        UploadTaskDatabase.getDatabase().getFileRecordDao().deleteByTaskId(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo99073a(Context context, String str) {
        m29684d("task success:" + str);
        this.f39370i.edit().putBoolean(str, true).apply();
        ReportUtils.reportUploadTaskResult(true, LoggerUtils.getNetworkType(context), str, "success");
        UploadTaskDatabase.getDatabase().getTaskRecordDao().deleteByTaskId(str);
    }

    /* renamed from: f */
    private boolean m29686f() {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(this.f39365d);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m29684d(String str) {
        Debug.m29707d("UploadTaskManager: " + str);
    }
}
