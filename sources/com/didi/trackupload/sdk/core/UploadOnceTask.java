package com.didi.trackupload.sdk.core;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.didi.trackupload.sdk.Constants;
import com.didi.trackupload.sdk.ICommonInfoDelegate;
import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.TrackOnceClient;
import com.didi.trackupload.sdk.datachannel.DataChannel;
import com.didi.trackupload.sdk.datachannel.SendResult;
import com.didi.trackupload.sdk.datachannel.protobuf.CollectSvrCoordinateReq;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackNode;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackUploadReq;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.storage.BizNodeEntity;
import com.didi.trackupload.sdk.utils.OmegaUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdu.didi.protobuf.MapTrackExtraPointData;
import com.squareup.wire.Wire;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class UploadOnceTask implements Runnable {

    /* renamed from: a */
    private static final String f46584a = "TrackOnceTask";

    /* renamed from: b */
    private static final String f46585b = "TrackOnceTaskDetail";

    /* renamed from: c */
    private static final Handler f46586c = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final SerialExecutor f46587d = new SerialExecutor();

    /* renamed from: e */
    private static final Gson f46588e = new GsonBuilder().setPrettyPrinting().create();

    /* renamed from: f */
    private static final Wire f46589f = new Wire((Class<?>[]) new Class[0]);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TrackOnceClient f46590g;

    /* renamed from: h */
    private long f46591h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnExecuteCompletedListenser f46592i;

    /* renamed from: j */
    private Long f46593j;

    /* renamed from: k */
    private Long f46594k;

    /* renamed from: l */
    private Long f46595l;

    /* renamed from: m */
    private Long f46596m;

    /* renamed from: n */
    private Integer f46597n;

    /* renamed from: o */
    private int f46598o;

    /* renamed from: p */
    private int f46599p;

    interface OnExecuteCompletedListenser {
        void onExecuteCompleted(UploadResult uploadResult);
    }

    /* renamed from: b */
    private String m34761b(String str) {
        return str != null ? str : "";
    }

    UploadOnceTask(TrackOnceClient trackOnceClient) {
        this(trackOnceClient, 0, (OnExecuteCompletedListenser) null);
    }

    UploadOnceTask(TrackOnceClient trackOnceClient, long j) {
        this(trackOnceClient, j, (OnExecuteCompletedListenser) null);
    }

    UploadOnceTask(TrackOnceClient trackOnceClient, long j, OnExecuteCompletedListenser onExecuteCompletedListenser) {
        this.f46591h = 0;
        this.f46590g = trackOnceClient;
        this.f46591h = j;
        this.f46592i = onExecuteCompletedListenser;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34764c() {
        this.f46594k = Long.valueOf(System.currentTimeMillis());
    }

    /* renamed from: d */
    private void m34765d() {
        this.f46595l = Long.valueOf(System.currentTimeMillis());
        m34758a(m34766e());
    }

    /* renamed from: a */
    private void m34758a(UploadResult uploadResult) {
        Long valueOf = uploadResult == UploadResult.ERR_OK ? Long.valueOf(System.currentTimeMillis()) : null;
        TrackLog.m34830d(f46584a, "upload completed task=" + toHexString() + " flags=" + this.f46591h + " result=" + uploadResult.toSimpleString());
        OmegaUtils.trackUploadResult(uploadResult, this.f46593j, this.f46594k, this.f46595l, this.f46596m, valueOf, this.f46597n, true, Long.valueOf(this.f46591h), Integer.valueOf(this.f46598o), Integer.valueOf(this.f46599p));
        m34762b(uploadResult);
    }

    /* renamed from: e */
    private UploadResult m34766e() {
        if (!DataChannel.getIntance().isConnected()) {
            return UploadResult.ERR_STATE_DATA_CHANNEL_NOT_CONNECTED;
        }
        ICommonInfoDelegate commonInfoDelegate = TrackController.getIntance().getInitParams().getCommonInfoDelegate();
        if (commonInfoDelegate == null) {
            return UploadResult.ERR_PARAMS_COMMON_INFO_DELEGATE;
        }
        if (this.f46590g == null) {
            return UploadResult.ERR_PARAMS_TRACK_CLIENT;
        }
        if (f46587d.hasPendingTask(this)) {
            return UploadResult.ERR_STATE_HAS_PENDING_TASK;
        }
        TrackLocationInfo f = m34767f();
        if (f == null) {
            return UploadResult.ERR_STATE_LAST_LOCATION;
        }
        this.f46593j = f.timestamp64_loc;
        BizNodeEntity a = UploadController.m34747a(this.f46590g);
        TrackUploadReq trackUploadReq = null;
        try {
            trackUploadReq = new TrackUploadReq.Builder().phone(m34761b(commonInfoDelegate.getPhone())).user_id(Long.valueOf(m34756a(commonInfoDelegate.getUid()))).upload_time64_mobile(Long.valueOf(System.currentTimeMillis())).upload_time64_loc(f.timestamp64_loc).loc(f).loc_rectified((TrackLocationInfo) null).loc_recent((List<TrackLocationInfo>) null).track_nodes((List<TrackNode>) null).biz_info(BizNodeEntity.toPBMessages((List<BizNodeEntity>) Collections.singletonList(a))).map_extra_message_data(f.map_extra_message_data).build();
        } catch (Exception e) {
            OmegaUtils.trackWireError(202, e);
        }
        if (trackUploadReq == null) {
            return UploadResult.ERR_STATE_BUILD_UPLOAD_REQ;
        }
        if (!DataChannel.getIntance().isConnected()) {
            return UploadResult.ERR_STATE_DATA_CHANNEL_NOT_CONNECTED;
        }
        TrackLog.m34830d(f46584a, "upload task=" + toHexString() + " loc.time=" + f.timestamp64_loc);
        if (Constants.DEBUG) {
            try {
                TrackLog.m34830d(f46585b, "---------------------------------------------------");
                TrackLog.m34830d(f46585b, "upload task=" + toHexString() + " TrackUploadReq=" + f46588e.toJson((Object) trackUploadReq, (Type) TrackUploadReq.class));
                TrackLog.m34830d(f46585b, "upload biz_info task=" + toHexString() + " tag={" + a.getTag() + "} CollectSvrCoordinateReq=" + f46588e.toJson((Object) (CollectSvrCoordinateReq) f46589f.parseFrom(a.getExtra_data(), CollectSvrCoordinateReq.class), (Type) CollectSvrCoordinateReq.class));
            } catch (Exception unused) {
            }
        }
        this.f46596m = Long.valueOf(System.currentTimeMillis());
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SendResult sendMessage = DataChannel.getIntance().sendMessage(trackUploadReq, this.f46591h, String.valueOf(a.getClient_type()));
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 5000) {
            TrackLog.m34830d(f46584a, "upload sendmsg task=" + toHexString() + " timediff=" + elapsedRealtime2 + "ms");
        }
        if (sendMessage == null) {
            return UploadResult.ERR_STATE_UPLOAD_FAILED;
        }
        this.f46597n = Integer.valueOf(sendMessage.getBytesLength());
        this.f46598o = sendMessage.getSendType();
        this.f46599p = sendMessage.getDetailCode();
        if (sendMessage.getResultCode() == 0) {
            return UploadResult.ERR_OK;
        }
        if (sendMessage.getResultCode() == -1 && sendMessage.getDetailCode() == -1100) {
            return UploadResult.ERR_STATE_BUILD_UPLOAD_REQ;
        }
        return sendMessage.getResultCode() == -2 ? UploadResult.ERR_STATE_UPLOAD_TIMEOUT : UploadResult.ERR_STATE_UPLOAD_FAILED;
    }

    public void run() {
        m34765d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115946a() {
        mo115947a(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115947a(long j) {
        f46586c.postDelayed(new Runnable() {
            public void run() {
                UploadOnceTask.this.m34764c();
                UploadOnceTask.f46587d.execute(UploadOnceTask.this);
            }
        }, j);
    }

    /* renamed from: b */
    private void m34762b(final UploadResult uploadResult) {
        f46586c.post(new Runnable() {
            public void run() {
                if (UploadOnceTask.this.f46592i != null) {
                    UploadOnceTask.this.f46592i.onExecuteCompleted(uploadResult);
                }
            }
        });
    }

    /* renamed from: f */
    private TrackLocationInfo m34767f() {
        TrackLocationInfo lastEffectiveLocation = LocationCenter.getIntance().getLastEffectiveLocation();
        if (lastEffectiveLocation != null) {
            TrackLog.m34830d(f46584a, "upload task=" + toHexString() + " getLocFromLocCache");
            return new TrackLocationInfo.Builder(lastEffectiveLocation).map_extra_point_data((MapTrackExtraPointData) null).build();
        }
        if (UploadFlags.hasFlag(this.f46591h, 4)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TrackLocationInfo requestLocationOnceSync = LocationCenter.getIntance().requestLocationOnceSync(10000);
            if (requestLocationOnceSync != null) {
                TrackLog.m34830d(f46584a, "upload task=" + toHexString() + " getLocFromLocOnce timediff=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                return new TrackLocationInfo.Builder(requestLocationOnceSync).map_extra_point_data((MapTrackExtraPointData) null).build();
            }
        }
        TrackLog.m34830d(f46584a, "upload task=" + toHexString() + " getLocFail");
        return null;
    }

    public String toString() {
        return "UploadOnceTask@" + Integer.toHexString(hashCode());
    }

    public String toHexString() {
        return Integer.toHexString(hashCode());
    }

    private static class SerialExecutor implements Executor {
        private Runnable mActive;
        final Map<String, Integer> mTagPendingTaskCount;
        final ArrayDeque<Runnable> mTasks;

        private SerialExecutor() {
            this.mTasks = new ArrayDeque<>();
            this.mTagPendingTaskCount = new HashMap();
        }

        public synchronized void execute(final Runnable runnable) {
            addPendingTask(runnable);
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        SerialExecutor.this.removePendingTask(runnable);
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: private */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void addPendingTask(java.lang.Runnable r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r3 instanceof com.didi.trackupload.sdk.core.UploadOnceTask     // Catch:{ all -> 0x0032 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r2)
                return
            L_0x0007:
                com.didi.trackupload.sdk.core.UploadOnceTask r3 = (com.didi.trackupload.sdk.core.UploadOnceTask) r3     // Catch:{ all -> 0x0032 }
                com.didi.trackupload.sdk.TrackOnceClient r0 = r3.f46590g     // Catch:{ all -> 0x0032 }
                if (r0 == 0) goto L_0x0030
                com.didi.trackupload.sdk.TrackOnceClient r3 = r3.f46590g     // Catch:{ all -> 0x0032 }
                java.lang.String r3 = r3.getTrackTag()     // Catch:{ all -> 0x0032 }
                java.util.Map<java.lang.String, java.lang.Integer> r0 = r2.mTagPendingTaskCount     // Catch:{ all -> 0x0032 }
                java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0032 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0032 }
                r1 = 1
                if (r0 == 0) goto L_0x0027
                int r0 = r0.intValue()     // Catch:{ all -> 0x0032 }
                int r1 = r1 + r0
            L_0x0027:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0032 }
                java.util.Map<java.lang.String, java.lang.Integer> r1 = r2.mTagPendingTaskCount     // Catch:{ all -> 0x0032 }
                r1.put(r3, r0)     // Catch:{ all -> 0x0032 }
            L_0x0030:
                monitor-exit(r2)
                return
            L_0x0032:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadOnceTask.SerialExecutor.addPendingTask(java.lang.Runnable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void removePendingTask(java.lang.Runnable r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r3 instanceof com.didi.trackupload.sdk.core.UploadOnceTask     // Catch:{ all -> 0x003a }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r2)
                return
            L_0x0007:
                com.didi.trackupload.sdk.core.UploadOnceTask r3 = (com.didi.trackupload.sdk.core.UploadOnceTask) r3     // Catch:{ all -> 0x003a }
                com.didi.trackupload.sdk.TrackOnceClient r0 = r3.f46590g     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0038
                com.didi.trackupload.sdk.TrackOnceClient r3 = r3.f46590g     // Catch:{ all -> 0x003a }
                java.lang.String r3 = r3.getTrackTag()     // Catch:{ all -> 0x003a }
                java.util.Map<java.lang.String, java.lang.Integer> r0 = r2.mTagPendingTaskCount     // Catch:{ all -> 0x003a }
                java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x003a }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x002e
                int r1 = r0.intValue()     // Catch:{ all -> 0x003a }
                if (r1 <= 0) goto L_0x002e
                int r0 = r0.intValue()     // Catch:{ all -> 0x003a }
                int r0 = r0 + -1
                goto L_0x002f
            L_0x002e:
                r0 = 0
            L_0x002f:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x003a }
                java.util.Map<java.lang.String, java.lang.Integer> r1 = r2.mTagPendingTaskCount     // Catch:{ all -> 0x003a }
                r1.put(r3, r0)     // Catch:{ all -> 0x003a }
            L_0x0038:
                monitor-exit(r2)
                return
            L_0x003a:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadOnceTask.SerialExecutor.removePendingTask(java.lang.Runnable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean hasPendingTask(java.lang.Runnable r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r4 instanceof com.didi.trackupload.sdk.core.UploadOnceTask     // Catch:{ all -> 0x002d }
                r1 = 0
                if (r0 != 0) goto L_0x0008
                monitor-exit(r3)
                return r1
            L_0x0008:
                com.didi.trackupload.sdk.core.UploadOnceTask r4 = (com.didi.trackupload.sdk.core.UploadOnceTask) r4     // Catch:{ all -> 0x002d }
                com.didi.trackupload.sdk.TrackOnceClient r0 = r4.f46590g     // Catch:{ all -> 0x002d }
                r2 = 1
                if (r0 == 0) goto L_0x002b
                com.didi.trackupload.sdk.TrackOnceClient r4 = r4.f46590g     // Catch:{ all -> 0x002d }
                java.lang.String r4 = r4.getTrackTag()     // Catch:{ all -> 0x002d }
                java.util.Map<java.lang.String, java.lang.Integer> r0 = r3.mTagPendingTaskCount     // Catch:{ all -> 0x002d }
                java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x002d }
                java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x002d }
                if (r4 == 0) goto L_0x002a
                int r4 = r4.intValue()     // Catch:{ all -> 0x002d }
                if (r4 <= 0) goto L_0x002a
                r1 = 1
            L_0x002a:
                r2 = r1
            L_0x002b:
                monitor-exit(r3)
                return r2
            L_0x002d:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.UploadOnceTask.SerialExecutor.hasPendingTask(java.lang.Runnable):boolean");
        }
    }

    /* renamed from: a */
    private long m34756a(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
